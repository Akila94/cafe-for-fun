package cafe.lavilla.items.menu.core.dao.impl;

import cafe.lavilla.items.menu.core.constants.FoodMenuConstants;
import cafe.lavilla.items.menu.core.constants.SQLQueries;
import cafe.lavilla.items.menu.core.dao.FoodItemDAO;
import cafe.lavilla.items.menu.core.exception.FoodItemException;
import cafe.lavilla.items.menu.core.imageconverter.ImageDecoder;
import cafe.lavilla.items.menu.core.model.FoodItem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;

import static cafe.lavilla.items.menu.core.dbconnection.DBConnection.getDBConnection;

/**
 * Class to access the items table of the database.
 */
public class FoodItemDAOImpl implements FoodItemDAO {

    @Override
    public FoodItem addItem(FoodItem foodItem) throws FoodItemException {

        FoodItem addedItem;
        Savepoint savepoint;
        ImageDecoder imageDecoder = new ImageDecoder();

        String insertQuery = SQLQueries.INSERT_ITEM_QUERY;
        String lastInsertedIdQuery = SQLQueries.GET_LAST_INSERTED_ITEM_ID_QUERY;
        String insertImageQuery = SQLQueries.INSERT_ITEM_IMAGE_QUERY;
        File tmpFile = null;
        InputStream tmpInputStream = null;

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint();

            if (foodItem.getImgLocation() != null) {
                tmpFile = new File(
                        FoodMenuConstants.CommonConstants.TMP_IMAGE_DIRECTORY_PATH + foodItem.getImgLocation());
                tmpInputStream = new FileInputStream(tmpFile);
            }

            try (PreparedStatement insertPrepStat = connection.prepareStatement(insertQuery);
                 PreparedStatement lastInsertedIdPrepStat = connection.prepareStatement(lastInsertedIdQuery);
                 PreparedStatement insertImagePrepStat = connection.prepareStatement(insertImageQuery)) {
                insertPrepStat.setInt(1, foodItem.getCategoryId());
                insertPrepStat.setString(2, foodItem.getName());
                insertPrepStat.setString(3, foodItem.getDescription());
                insertPrepStat.setFloat(4, foodItem.getPrice());
                insertPrepStat.executeUpdate();
                try (ResultSet resultSet = lastInsertedIdPrepStat.executeQuery()) {
                    resultSet.first();

                    if (foodItem.getImgLocation() == null) {
                        insertImagePrepStat.setString(1, foodItem.getImgLocation());
                    } else {
                        List<String> imageDetails =
                                imageDecoder.saveImage(tmpInputStream, foodItem.getCategory(), resultSet.getInt(1));
                        insertImagePrepStat.setString(1, imageDetails.get(0));
                    }

                    insertImagePrepStat.setInt(2, resultSet.getInt(1));
                    insertImagePrepStat.executeUpdate();

                    addedItem = getItemById(connection, resultSet.getInt(1));
                }
                connection.commit();
            } catch (SQLException | FoodItemException e) {
                connection.rollback(savepoint);
                throw new FoodItemException(
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_ADD_ITEM_FAILURE.getErrorMessage(),
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_ADD_ITEM_FAILURE.getErrorCode(), e);
            }
        } catch (SQLException | FileNotFoundException e) {
            throw new FoodItemException(
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorMessage(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorCode(), e);
        }
        return addedItem;
    }

    @Override
    public FoodItem updateItem(FoodItem foodItem) throws FoodItemException {

        FoodItem updatedItem;
        Savepoint savepoint;
        ImageDecoder imageDecoder = new ImageDecoder();
        String updateQuery = SQLQueries.UPDATE_ITEM_QUERY;

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint();

            if (foodItem.getImgLocation() == null) {
                File tmpFile = new File(FoodMenuConstants.CommonConstants.IMAGE_DIRECTORY_PATH + foodItem.getItemId() +
                        FoodMenuConstants.CommonConstants.IMAGE_EXT);
                if (tmpFile.exists()) {
                    tmpFile.delete();
                }
            } else if (foodItem.getImgLocation().contains(FoodMenuConstants.CommonConstants.TMP_ID)) {
                File tmpFile = new File(
                        FoodMenuConstants.CommonConstants.TMP_IMAGE_DIRECTORY_PATH + foodItem.getImgLocation());
                InputStream tmpInputStream = new FileInputStream(tmpFile);
                List<String> imageDetails = imageDecoder.saveImage(tmpInputStream, foodItem.getCategory(), foodItem
                        .getItemId());
                foodItem.setImgLocation(imageDetails.get(0));
            } else if (foodItem.getImgLocation().contains(FoodMenuConstants.CommonConstants.IMAGE_SERVER_URL)) {
                FoodItem currentItem = getItemById(connection, foodItem.getItemId());
                foodItem.setImgLocation(currentItem.getImgPath());
            }

            try (PreparedStatement updatePrepStat = connection.prepareStatement(updateQuery)) {
                updatePrepStat.setInt(1, foodItem.getCategoryId());
                updatePrepStat.setString(2, foodItem.getName());
                updatePrepStat.setString(3, foodItem.getDescription());
                updatePrepStat.setFloat(4, foodItem.getPrice());
                updatePrepStat.setString(5, foodItem.getImgLocation());
                updatePrepStat.setInt(6, foodItem.getItemId());
                updatePrepStat.executeUpdate();
                updatedItem = getItemById(connection, foodItem.getItemId());
                connection.commit();
            } catch (SQLException e) {
                connection.rollback(savepoint);
                throw new FoodItemException(
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_UPDATE_ITEM_FAILURE.getErrorMessage(),
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_UPDATE_ITEM_FAILURE.getErrorCode(), e);
            }
        } catch (SQLException | FileNotFoundException e) {
            throw new FoodItemException(
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorMessage(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorCode(), e);
        }
        return updatedItem;
    }

    @Override
    public FoodItem deleteItem(int itemId) throws FoodItemException {

        FoodItem deletedItem;
        Savepoint savepoint;
        String deleteQuery = SQLQueries.DELETE_ITEM_QUERY;

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint();
            try (PreparedStatement deletePrepStat = connection.prepareStatement(deleteQuery)) {
                deletedItem = getItemById(connection, itemId);
                deletePrepStat.setInt(1, itemId);
                deletePrepStat.executeUpdate();
                if (deletedItem.getImgPath() != null) {
                    File image = new File(deletedItem.getImgPath());
                    if (image.delete()) {
                        //--Add a log
                    } else {
                        throw new FoodItemException(
                                FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_DELETE_IMAGE_FAILURE
                                        .getErrorMessage(),
                                FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_DELETE_IMAGE_FAILURE
                                        .getErrorCode());
                    }
                }
                connection.commit();
            } catch (SQLException | FoodItemException e) {
                connection.rollback(savepoint);
                throw new FoodItemException(
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_DELETE_ITEM_FAILURE.getErrorMessage(),
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_DELETE_ITEM_FAILURE.getErrorCode(), e);
            }
        } catch (SQLException e) {
            throw new FoodItemException(
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorMessage(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorCode(), e);
        }
        return deletedItem;
    }

    @Override
    public FoodItem getItem(int itemId) throws FoodItemException {

        try (Connection connection = getDBConnection()) {
            return getItemById(connection, itemId);
        } catch (SQLException e) {
            throw new FoodItemException(
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorMessage(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorCode(), e);
        }
    }

    private FoodItem getItemById(Connection connection, int itemId) throws FoodItemException {

        FoodItem foodItem = new FoodItem();
        String getItemByIdQuery = SQLQueries.GET_ITEM_BY_ID_QUERY;
        try (PreparedStatement getByIdPrepStat = connection.prepareStatement(getItemByIdQuery)) {
            getByIdPrepStat.setInt(1, itemId);
            try (ResultSet resultSet = getByIdPrepStat.executeQuery()) {
                resultSet.first();
                foodItem.setCategoryId(resultSet.getInt(1));
                foodItem.setCategory(resultSet.getString(2));
                foodItem.setItemId(resultSet.getInt(3));
                foodItem.setName(resultSet.getString(4));
                foodItem.setDescription(resultSet.getString(5));
                foodItem.setPrice(resultSet.getFloat(6));
                foodItem.setImgPath(resultSet.getString(7));
                if (resultSet.getString(7) != null) {
                    foodItem.setImgLocation(
                            FoodMenuConstants.CommonConstants.IMAGE_SERVER_URL + resultSet.getInt(3) +
                                    FoodMenuConstants.CommonConstants.IMAGE_EXT);
                } else {
                    foodItem.setImgLocation(null);
                }
            } catch (SQLException e) {
                throw new FoodItemException(
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_ITEM_FAILURE.getErrorMessage(),
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_ITEM_FAILURE.getErrorCode(), e);
            }
        } catch (SQLException e) {
            throw new FoodItemException(
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_CREATE_PREP_STAT_FAILURE.getErrorMessage(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_CREATE_PREP_STAT_FAILURE.getErrorCode(), e);
        }
        return foodItem;
    }

    public List<FoodItem> getItemsByCategory(int categoryId) throws FoodItemException {

        List<FoodItem> foodItemList = new ArrayList<>();
        String getItemsQuery = SQLQueries.GET_ITEMS_BY_CATEGORY_QUERY;

        try (Connection connection = getDBConnection()) {
            try (PreparedStatement getItemsPrepStat = connection.prepareStatement(getItemsQuery)) {
                getItemsPrepStat.setInt(1, categoryId);
                try (ResultSet getItemsRes = getItemsPrepStat.executeQuery()) {
                    while (getItemsRes.next()) {
                        FoodItem foodItem = new FoodItem();
                        foodItem.setCategoryId(getItemsRes.getInt(1));
                        foodItem.setCategory(getItemsRes.getString(2));
                        foodItem.setItemId(getItemsRes.getInt(3));
                        foodItem.setName(getItemsRes.getString(4));
                        foodItem.setDescription(getItemsRes.getString(5));
                        foodItem.setPrice(getItemsRes.getFloat(6));
                        if (getItemsRes.getString(7) != null) {
                            foodItem.setImgLocation(
                                    FoodMenuConstants.CommonConstants.IMAGE_SERVER_URL + getItemsRes.getInt(3) +
                                            FoodMenuConstants.CommonConstants.IMAGE_EXT);
                        } else {
                            foodItem.setImgLocation(null);
                        }
                        foodItemList.add(foodItem);
                    }
                } catch (SQLException e) {
                    throw new FoodItemException(
                            FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_ITEMS_FAILURE.getErrorMessage(),
                            FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_ITEMS_FAILURE.getErrorCode(), e);
                }
            } catch (SQLException e) {
                throw new FoodItemException(
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_CREATE_PREP_STAT_FAILURE.getErrorMessage(),
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_CREATE_PREP_STAT_FAILURE.getErrorCode(), e);
            }
        } catch (SQLException e) {
            throw new FoodItemException(
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorMessage(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorCode(), e);
        }
        return foodItemList;
    }
}

package cafe.lavilla.food.menu.core.dao.impl;

import cafe.lavilla.food.menu.core.constants.FoodMenuConstants;
import cafe.lavilla.food.menu.core.constants.SQLQueries;
import cafe.lavilla.food.menu.core.dao.SaladsDAO;
import cafe.lavilla.food.menu.core.exception.FoodItemException;
import cafe.lavilla.food.menu.core.imageconverter.ImageDecoder;
import cafe.lavilla.food.menu.core.model.FoodItem;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;

import static cafe.lavilla.food.menu.core.dbconnection.DBConnection.getDBConnection;

/**
 * Class that implements the methods of SaladsDAO interface and connects with the TABLE_SALADS table.
 */
public class SaladsDAOImpl implements SaladsDAO {
    @Override
    public FoodItem addSaladItem(FoodItem foodItem) throws FoodItemException {
        FoodItem addedFoodItem;
        Savepoint savepoint;
        String insertQuery = SQLQueries.INSERT_SALAD_ITEM_QUERY;
        String lastInsertedSaladIdQuery = SQLQueries.GET_LAST_INSERTED_SALAD_ID_QUERY;
        foodItem.setImgUrl(ImageDecoder.decodeImage(foodItem.getImgString(), foodItem.getName()));
        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint();
            try (PreparedStatement insertPrepStat = connection.prepareStatement(insertQuery);
                 PreparedStatement lastInsertedSaladIdPrepStat = connection
                         .prepareStatement(lastInsertedSaladIdQuery)) {
                insertPrepStat.setString(1, foodItem.getName());
                insertPrepStat.setString(2, foodItem.getDescription());
                insertPrepStat.setString(3, foodItem.getArabicDescription());
                insertPrepStat.setInt(4, foodItem.getPrice());
                insertPrepStat.setString(5, foodItem.getImgUrl());
                insertPrepStat.executeUpdate();
                try (ResultSet resultSet = lastInsertedSaladIdPrepStat.executeQuery()) {
                    resultSet.first();
                    addedFoodItem = getSaladItemById(connection, resultSet.getInt(1));
                }
                connection.commit();
            } catch (SQLException e) {
                connection.rollback(savepoint);
                throw new FoodItemException(
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_ADD_SALAD_ITEM_FAILURE.getErrorCode(),
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_ADD_SALAD_ITEM_FAILURE.getErrorMessage(), e);
            }
        } catch (SQLException e) {
            throw new FoodItemException(
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorCode(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorMessage(), e);
        }
        return addedFoodItem;
    }

    @Override
    public FoodItem updateSaladItem(FoodItem foodItem) throws FoodItemException {
        FoodItem updatedSaladItem;
        Savepoint savepoint;
        String updateSaladQuery = SQLQueries.UPDATE_SALAD_ITEM_QUERY;
        foodItem.setImgUrl(ImageDecoder.decodeImage(foodItem.getImgString(), foodItem.getName()));
        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint();
            try (PreparedStatement updatePrepStat = connection.prepareStatement(updateSaladQuery)) {
                updatePrepStat.setString(1, foodItem.getName());
                updatePrepStat.setString(2, foodItem.getArabicName());
                updatePrepStat.setString(3, foodItem.getDescription());
                updatePrepStat.setString(4, foodItem.getArabicDescription());
                updatePrepStat.setInt(5, foodItem.getPrice());
                updatePrepStat.setString(6, foodItem.getImgUrl());
                updatePrepStat.executeUpdate();
                updatedSaladItem = getSaladItemById(connection, foodItem.getId());
                connection.commit();
            } catch (SQLException e) {
                connection.rollback(savepoint);
                throw new FoodItemException(
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_UPDATE_SALAD_ITEM_FAILURE.getErrorCode(),
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_UPDATE_SALAD_ITEM_FAILURE.getErrorMessage(), e);
            }
        } catch (SQLException e) {
            throw new FoodItemException(
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorCode(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorMessage(), e);
        }
        return updatedSaladItem;
    }

    @Override
    public FoodItem deleteSaladItem(int saladId) throws FoodItemException {
        FoodItem deletedSaladItem;
        Savepoint savepoint;
        String deleteQuery = SQLQueries.DELETE_SALAD_ITEM_QUERY;
        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint();
            try (PreparedStatement deleteSaladItemPrepStat = connection.prepareStatement(deleteQuery)) {
                deletedSaladItem = getSaladItemById(connection, saladId);
                File file = new File(deletedSaladItem.getImgUrl());
                if (file.delete()) {
                    deleteSaladItemPrepStat.setInt(1, saladId);
                    deleteSaladItemPrepStat.executeUpdate();
                    connection.commit();
                } else {
                    throw new FoodItemException(
                            FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_DELETE_SALAD_IMAGE_FAILURE.getErrorCode(),
                            FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_DELETE_SALAD_IMAGE_FAILURE.getErrorMessage());
                }
            } catch (SQLException | FoodItemException e) {
                connection.rollback(savepoint);
                throw new FoodItemException(
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_DELETE_SALAD_ITEM_FAILURE.getErrorCode(),
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_DELETE_SALAD_ITEM_FAILURE.getErrorMessage(), e);
            }
        } catch (SQLException e) {
            throw new FoodItemException(
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorCode(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorMessage(), e);
        }
        return deletedSaladItem;
    }

    @Override
    public FoodItem getSaladItem(int saladId) throws FoodItemException {
        try (Connection connection = getDBConnection()) {
            return getSaladItemById(connection, saladId);
        } catch (SQLException e) {
            throw new FoodItemException(
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorCode(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorMessage(), e);
        }
    }

    private FoodItem getSaladItemById(Connection connection, int saladId) throws FoodItemException {
        FoodItem saladItem = new FoodItem();
        String getQuery = SQLQueries.GET_SALAD_ITEM_QUERY;
        try (PreparedStatement getSaladItemPrepStat = connection.prepareStatement(getQuery)) {
            getSaladItemPrepStat.setInt(1, saladId);
            try (ResultSet saladItemResult = getSaladItemPrepStat.executeQuery()) {
                saladItemResult.first();
                saladItem.setId(saladItemResult.getInt(1));
                saladItem.setName(saladItemResult.getString(2));
                saladItem.setArabicName(saladItemResult.getString(3));
                saladItem.setDescription(saladItemResult.getString(4));
                saladItem.setArabicDescription(saladItemResult.getString(5));
                saladItem.setPrice(saladItemResult.getInt(6));
                saladItem.setImgUrl(saladItemResult.getString(7));
            } catch (SQLException e) {
                throw new FoodItemException(
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_CREATE_RESULT_SET_FAILURE.getErrorCode(),
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_CREATE_RESULT_SET_FAILURE.getErrorMessage()
                        , e);
            }
        } catch (SQLException e) {
            throw new FoodItemException(
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_CREATE_PREP_STAT_FAILURE.getErrorCode(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_CREATE_PREP_STAT_FAILURE.getErrorMessage(), e);
        }
        return saladItem;
    }

    @Override
    public List<FoodItem> getAllSaladItems() throws FoodItemException {
        List<FoodItem> saladItemList = new ArrayList<>();
        String getQuery = SQLQueries.GET_SALAD_ITEMS_QUERY;
        try (Connection connection = getDBConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(getQuery)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        FoodItem saladItem = new FoodItem();
                        saladItem.setId(resultSet.getInt(1));
                        saladItem.setName(resultSet.getString(2));
                        saladItem.setDescription(resultSet.getString(3));
                        saladItem.setArabicDescription(resultSet.getString(4));
                        saladItem.setPrice(resultSet.getInt(5));
                        saladItem.setImgUrl(resultSet.getString(6));
                        saladItemList.add(saladItem);
                    }
                } catch (SQLException e) {
                    throw new FoodItemException(
                            FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_CREATE_RESULT_SET_FAILURE.getErrorCode(),
                            FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_CREATE_RESULT_SET_FAILURE.getErrorMessage()
                            , e);
                }
            } catch (SQLException e) {
                throw new FoodItemException(
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_CREATE_PREP_STAT_FAILURE.getErrorCode(),
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_CREATE_PREP_STAT_FAILURE.getErrorMessage(), e);
            }
        } catch (SQLException e) {
            throw new FoodItemException(
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_SALAD_ITEMS_FAILURE.getErrorCode(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_SALAD_ITEMS_FAILURE.getErrorMessage(), e);
        }
        return saladItemList;
    }
}

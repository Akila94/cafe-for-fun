package cafe.lavilla.items.menu.core.dao.impl;

import cafe.lavilla.items.menu.core.constants.FoodMenuConstants;
import cafe.lavilla.items.menu.core.constants.SQLQueries;
import cafe.lavilla.items.menu.core.dao.FoodItemDAO;
import cafe.lavilla.items.menu.core.exception.FoodItemException;
import cafe.lavilla.items.menu.core.model.FoodItem;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static cafe.lavilla.items.menu.core.dao.QueryFilters.*;
import static cafe.lavilla.items.menu.core.dbconnection.DBConnection.getDBConnection;
import static cafe.lavilla.items.menu.core.dao.QueryFilters.filterInsertQuery;

/**
 * Class to access the breakfast table of the database.
 */
public class FoodItemDAOImpl implements FoodItemDAO {
    //    Need to update the method
    @Override
    public FoodItem addItem(FoodItem foodItem) throws FoodItemException {
        FoodItem addedItem;
        Savepoint savepoint;

        String[] queries = filterInsertQuery(foodItem.getCategory());
        String insertQuery = queries[0];
        String lastInsertedIdQuery = queries[1];

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint();
            try (PreparedStatement insertPrepStat = connection.prepareStatement(insertQuery);
                 PreparedStatement lastInsertedIdPrepStat = connection.prepareStatement(lastInsertedIdQuery)) {
                insertPrepStat.setString(1, foodItem.getName());
                insertPrepStat.setString(2, foodItem.getDescription());
                insertPrepStat.setInt(3, foodItem.getPrice());
                insertPrepStat.setString(4, foodItem.getImgLocation());
                insertPrepStat.executeUpdate();
                try (ResultSet resultSet = lastInsertedIdPrepStat.executeQuery()) {
                    resultSet.first();
                    addedItem = getItemById(connection, foodItem.getCategory(), resultSet.getInt(1));
                    connection.commit();
                }
            } catch (SQLException | FoodItemException e) {
                connection.rollback(savepoint);
                throw new FoodItemException(
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_ADD_BREAKFAST_ITEM_FAILURE.getErrorCode(),
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_ADD_BREAKFAST_ITEM_FAILURE.getErrorMessage(), e);
            }
        } catch (SQLException e) {
            throw new FoodItemException(
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorCode(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorMessage(), e);
        }
        return addedItem;
    }

    @Override
    public FoodItem updateItem(FoodItem foodItem) throws FoodItemException {
        //    Need to update the method
        FoodItem updatedItem;
        Savepoint savepoint;
        String updateQuery = filterUpdateQuery(foodItem.getCategory());
        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint();
            try (PreparedStatement updatePrepStat = connection.prepareStatement(updateQuery)) {
                updatePrepStat.setString(1, foodItem.getName());
                updatePrepStat.setString(2, foodItem.getDescription());
                updatePrepStat.setInt(3, foodItem.getPrice());
                updatePrepStat.setString(4, foodItem.getImgLocation());
                updatePrepStat.executeUpdate();
                updatedItem = getItemById(connection, foodItem.getCategory(), foodItem.getId());
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
        return updatedItem;
    }

    @Override
    public FoodItem deleteItem(String category, int breakfastId) throws FoodItemException {
        FoodItem deletedItem;
        Savepoint savepoint;
        String deleteQuery = filterDeleteQuery(category);
        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint();
            try (PreparedStatement deletePrepStat = connection.prepareStatement(deleteQuery)) {
                deletedItem = getItemById(connection, category, breakfastId);
                File image = new File(deletedItem.getImgLocation());
                if (image.delete()) {
                    deletePrepStat.setInt(1, breakfastId);
                    deletePrepStat.executeUpdate();
                    connection.commit();
                } else {
                    throw new FoodItemException(
                            FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_DELETE_BREAKFAST_IMAGE_FAILURE.getErrorCode(),
                            FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_DELETE_BREAKFAST_IMAGE_FAILURE
                                    .getErrorMessage());
                }
            } catch (SQLException | FoodItemException e) {
                connection.rollback(savepoint);
                throw new FoodItemException(
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_DELETE_BREAKFAST_ITEM_FAILURE.getErrorCode(),
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_DELETE_BREAKFAST_ITEM_FAILURE.getErrorMessage()
                        , e);
            }
        } catch (SQLException e) {
            throw new FoodItemException(
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorCode(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorMessage(), e);
        }
        return deletedItem;
    }

    @Override
    public FoodItem getItem(String category, int breakfastId) throws FoodItemException {
        try (Connection connection = getDBConnection()) {
            return getItemById(connection, category, breakfastId);
        } catch (SQLException e) {
            throw new FoodItemException(
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorCode(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorMessage(), e);
        }
    }

    private FoodItem getItemById(Connection connection, String category, int breakfastId) throws
            FoodItemException {
        FoodItem breakfastItem = new FoodItem();
        String getItemByIdQuery = filterGetQuery(category);
        try (PreparedStatement getByIdPrepStat = connection.prepareStatement(getItemByIdQuery)) {
            getByIdPrepStat.setInt(1, breakfastId);
            try (ResultSet resultSet = getByIdPrepStat.executeQuery()) {
                resultSet.first();
                breakfastItem.setId(resultSet.getInt(1));
                breakfastItem.setName(resultSet.getString(2));
                breakfastItem.setDescription(resultSet.getString(3));
                breakfastItem.setPrice(resultSet.getInt(4));
                breakfastItem.setImgLocation("http://localhost:8080/project/images/" + resultSet.getString(2) +
                        ".jpeg");
            } catch (SQLException e) {
                throw new FoodItemException(
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_BREAKFAST_ITEM_FAILURE.getErrorCode(),
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_BREAKFAST_ITEM_FAILURE.getErrorMessage(), e);
            }
        } catch (SQLException e) {
            throw new FoodItemException(
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_CREATE_PREP_STAT_FAILURE.getErrorCode(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_CREATE_PREP_STAT_FAILURE.getErrorMessage(), e);
        }
        return breakfastItem;
    }

    @Override
    public List getAllItems() throws FoodItemException {
        List<List> allItems = new ArrayList<>();
        String getSaladsQuery = SQLQueries.GET_SALAD_ITEMS_QUERY;
        String getBreakfastsQuery = SQLQueries.GET_BREAKFAST_ITEMS_QUERY;
        String getHotDrinksQuery = SQLQueries.GET_HOT_DRINKS_QUERY;
        String getDessertsQuery = SQLQueries.GET_DESSERT_QUERY;
        String getFrenchToastsQuery = SQLQueries.GET_FRENCH_TOAST_QUERY;
        String getMainCoursesQuery = SQLQueries.GET_MAIN_COURSE_QUERY;
        String getPanCakesQuery = SQLQueries.GET_PAN_CAKES_QUERY;
        String getPastasQuery = SQLQueries.GET_PASTA_QUERY;
        String getQuenchersQuery = SQLQueries.GET_QUENCHERS_QUERY;
        String getStartersQuery = SQLQueries.GET_STARTERS_QUERY;
        String getWafflesQuery = SQLQueries.GET_WAFFLES_QUERY;

        try (Connection connection = getDBConnection()) {
            try (PreparedStatement getSaladsPrepStat = connection.prepareStatement(getSaladsQuery);
                 PreparedStatement getBreakfastsPrepStat = connection.prepareStatement(getBreakfastsQuery);
                 PreparedStatement getHotDrinksPrepStat = connection.prepareStatement(getHotDrinksQuery);
                 PreparedStatement getDessertsPrepStat = connection.prepareStatement(getDessertsQuery);
                 PreparedStatement getFrenchToastsPrepStat = connection.prepareStatement(getFrenchToastsQuery);
                 PreparedStatement getMainCoursePrepStat = connection.prepareStatement(getMainCoursesQuery);
                 PreparedStatement getPanCakesPrepStat = connection.prepareStatement(getPanCakesQuery);
                 PreparedStatement getPastasPrepStat = connection.prepareStatement(getPastasQuery);
                 PreparedStatement getQuenchersPrepStat = connection.prepareStatement(getQuenchersQuery);
                 PreparedStatement getStartersPrepStat = connection.prepareStatement(getStartersQuery);
                 PreparedStatement getWafflesPrepStat = connection.prepareStatement(getWafflesQuery)) {
                try (ResultSet saladsRes = getSaladsPrepStat.executeQuery();
                     ResultSet breakFastRes = getBreakfastsPrepStat.executeQuery();
                     ResultSet hotDrinksRes = getHotDrinksPrepStat.executeQuery();
                     ResultSet dessertsRes = getDessertsPrepStat.executeQuery();
                     ResultSet frenchToastsRes = getFrenchToastsPrepStat.executeQuery();
                     ResultSet mainCourseRes = getMainCoursePrepStat.executeQuery();
                     ResultSet panCakesRes = getPanCakesPrepStat.executeQuery();
                     ResultSet pastaRes = getPastasPrepStat.executeQuery();
                     ResultSet quenchersRes = getQuenchersPrepStat.executeQuery();
                     ResultSet startersRes = getStartersPrepStat.executeQuery();
                     ResultSet wafflesRes = getWafflesPrepStat.executeQuery()) {
                    allItems.add(setFoodItem(saladsRes));
                    allItems.add(setFoodItem(breakFastRes));
                    allItems.add(setFoodItem(hotDrinksRes));
                    allItems.add(setFoodItem(dessertsRes));
                    allItems.add(setFoodItem(frenchToastsRes));
                    allItems.add(setFoodItem(mainCourseRes));
                    allItems.add(setFoodItem(panCakesRes));
                    allItems.add(setFoodItem(pastaRes));
                    allItems.add(setFoodItem(quenchersRes));
                    allItems.add(setFoodItem(startersRes));
                    allItems.add(setFoodItem(wafflesRes));
                } catch (SQLException e) {
                    throw new FoodItemException(
                            FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_ITEMS_FAILURE.getErrorCode(),
                            FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_ITEMS_FAILURE.getErrorMessage(), e);
                }
            } catch (SQLException e) {
                throw new FoodItemException(
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_CREATE_PREP_STAT_FAILURE.getErrorCode(),
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_CREATE_PREP_STAT_FAILURE.getErrorMessage(), e);
            }
        } catch (SQLException e) {
            throw new FoodItemException(
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorCode(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorMessage(), e);
        }
        return allItems;
    }

    private List<FoodItem> setFoodItem(ResultSet resultSet) throws SQLException {
        List<FoodItem> foodItems = new ArrayList<>();
        FoodItem foodItem = new FoodItem();
        while (resultSet.next()) {
            foodItem.setId(resultSet.getInt(1));
            foodItem.setName(resultSet.getString(2));
            foodItem.setDescription(resultSet.getString(3));
            foodItem.setPrice(resultSet.getInt(4));
            foodItem.setImgLocation("http://localhost:8080/project/images/" + resultSet.getString(2) +
                    ".jpeg");
            foodItems.add(foodItem);
        }
        return foodItems;
    }

    public List<FoodItem> getItemsByCategory(String category) throws FoodItemException {
        List<FoodItem> foodItemList = new ArrayList<>();
        String getItemsQuery = filterGetAllQuery(category);
        try (Connection connection = getDBConnection()) {
            try (PreparedStatement getItemsPrepStat = connection.prepareStatement(getItemsQuery)) {
                try (ResultSet getItemsRes = getItemsPrepStat.executeQuery()) {
                    while (getItemsRes.next()) {
                        FoodItem foodItem = new FoodItem();
                        foodItem.setId(getItemsRes.getInt(1));
                        foodItem.setName(getItemsRes.getString(2));
                        foodItem.setDescription(getItemsRes.getString(3));
                        foodItem.setPrice(getItemsRes.getInt(4));
                        foodItem.setImgLocation(getItemsRes.getString(5));
                        foodItemList.add(foodItem);
                    }
                } catch (SQLException e) {
                    throw new FoodItemException(
                            FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_ITEMS_FAILURE.getErrorCode(),
                            FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_ITEMS_FAILURE.getErrorMessage(), e);
                }
            } catch (SQLException e) {
                throw new FoodItemException(
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_CREATE_PREP_STAT_FAILURE.getErrorCode(),
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_CREATE_PREP_STAT_FAILURE.getErrorMessage(), e);
            }
        } catch (SQLException e) {
            throw new FoodItemException(
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorCode(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorMessage(), e);
        }
        return foodItemList;
    }
}











package dao.impl;

import constants.FoodMenuConstants;
import constants.SQLQueries;
import dao.SaladsDAO;
import exception.FoodItemException;
import model.FoodItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static dbconnection.DBConnection.getDBConnection;


/**
 * Class that implements the methods of SaladsDAO interface and connects with the TABLE_SALADS table.
 */
public class SaladsDAOImpl implements SaladsDAO {
    @Override
    public FoodItem addSaladItem(FoodItem foodItem) throws FoodItemException {
        FoodItem addedFoodItem;
        String insertQuery = SQLQueries.INSERT_SALAD_ITEM_QUERY;
        try (Connection connection = getDBConnection()) {
            try (PreparedStatement insertPrepStat = connection.prepareStatement(insertQuery)) {
                insertPrepStat.setString(1, foodItem.getName());
                insertPrepStat.setString(2, foodItem.getDescription());
                insertPrepStat.setString(3, foodItem.getArabicDescription());
                insertPrepStat.setInt(4, foodItem.getPrice());
                insertPrepStat.setString(5, foodItem.getImgUrl());
                insertPrepStat.executeUpdate();
                addedFoodItem = getSaladItem(foodItem.getName());
            } catch (SQLException e) {
                throw new FoodItemException(
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_CREATE_PREP_STAT_FAILURE.getErrorCode(),
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_CREATE_PREP_STAT_FAILURE.getErrorMessage(), e);
            }
        } catch (SQLException e) {
            throw new FoodItemException(
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_ADD_SALAD_ITEM_FAILURE.getErrorCode(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_ADD_SALAD_ITEM_FAILURE.getErrorMessage(), e);
        }
        return addedFoodItem;
    }

    @Override
    public FoodItem updateSaladItem(FoodItem foodItem) throws FoodItemException {
        return null;
    }

    @Override
    public FoodItem deleteSaladItem(FoodItem foodItem) throws FoodItemException {
        return null;
    }

    @Override
    public FoodItem getSaladItem(String name) throws FoodItemException {
        return null;
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
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_SALAD_ITEM_FAILURE.getErrorCode(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_SALAD_ITEM_FAILURE.getErrorMessage(), e);
        }
        return saladItemList;
    }
}

package cafe.lavilla.items.menu.core.dao.impl;

import cafe.lavilla.items.menu.core.constants.FoodMenuConstants;
import cafe.lavilla.items.menu.core.constants.SQLQueries;
import cafe.lavilla.items.menu.core.dao.CategoryDAO;
import cafe.lavilla.items.menu.core.exception.FoodItemException;
import cafe.lavilla.items.menu.core.model.Category;
import cafe.lavilla.items.menu.core.model.FoodItem;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;

import static cafe.lavilla.items.menu.core.dbconnection.DBConnection.getDBConnection;

/**
 * Class to access the category table of the database.
 */
public class CategoryDAOImpl implements CategoryDAO {

    @Override
    public List<Category> getAllCategories() throws FoodItemException {

        List<Category> categoryList = new ArrayList<>();
        String getCategoryListQuery = SQLQueries.GET_CATEGORIES_QUERY;

        try (Connection connection = getDBConnection()) {
            try (PreparedStatement getCategoryListPrepStat = connection.prepareStatement(getCategoryListQuery)) {
                try (ResultSet categoryListRes = getCategoryListPrepStat.executeQuery()) {
                    while (categoryListRes.next()) {
                        Category category = new Category();
                        category.setCategoryId(categoryListRes.getInt(1));
                        category.setCategoryName(categoryListRes.getString(2));
                        categoryList.add(category);
                    }
                } catch (SQLException e) {
                    throw new FoodItemException(
                            FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CATEGORIES_FAILURE.getErrorMessage(),
                            FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CATEGORIES_FAILURE.getErrorCode(), e);
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
        return categoryList;
    }

    @Override
    public Category addCategory(Category category) throws FoodItemException {

        String addCategoryQuery = SQLQueries.INSERT_CATEGORY_QUERY;
        String lastIdQuery = SQLQueries.GET_LAST_INSERTED_CATEGORY_ID_QUERY;
        Category addedCategory;
        Savepoint savepoint;

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint();
            try (PreparedStatement addCategoryPrepStat = connection.prepareStatement(addCategoryQuery);
                 PreparedStatement lastIdPrepStat = connection.prepareStatement(lastIdQuery)) {
                addCategoryPrepStat.setString(1, category.getCategoryName());
                addCategoryPrepStat.executeUpdate();
                try (ResultSet lastIdRes = lastIdPrepStat.executeQuery()) {
                    lastIdRes.first();
                    addedCategory = getCategoryById(connection, lastIdRes.getInt(1));
                }
                connection.commit();
            } catch (SQLException | FoodItemException e) {
                connection.rollback(savepoint);
                throw new FoodItemException(
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_ADD_CATEGORY_FAILURE.getErrorMessage(),
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_ADD_CATEGORY_FAILURE.getErrorCode(), e);
            }
        } catch (SQLException e) {
            throw new FoodItemException(
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorMessage(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorCode(), e);
        }
        return addedCategory;
    }

    private Category getCategoryById(Connection connection, int categoryId) throws FoodItemException {

        String getCategoryQuery = SQLQueries.GET_CATEGORY_BY_ID_QUERY;
        Category category = new Category();

        try (PreparedStatement getCategoryPrepStat = connection.prepareStatement(getCategoryQuery)) {
            getCategoryPrepStat.setInt(1, categoryId);
            try (ResultSet categoryRes = getCategoryPrepStat.executeQuery()) {
                categoryRes.first();
                category.setCategoryId(categoryRes.getInt(1));
                category.setCategoryName(categoryRes.getString(2));
            }
        } catch (SQLException e) {
            throw new FoodItemException(
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CATEGORY_FAILURE.getErrorMessage(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CATEGORY_FAILURE.getErrorCode(), e);
        }
        return category;
    }

    @Override
    public Category updateCategory(Category category) throws FoodItemException {

        String updateCategoryQuery = SQLQueries.UPDATE_CATEGORY_QUERY;
        Category updatedCategory;
        Savepoint savepoint;

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint();
            try (PreparedStatement updateCategoryPrepStat = connection.prepareStatement(updateCategoryQuery)) {
                Category currentCategory = getCategoryById(connection, category.getCategoryId());
                updateCategoryPrepStat.setString(1, category.getCategoryName());
                updateCategoryPrepStat.setInt(2, category.getCategoryId());
                updateCategoryPrepStat.executeUpdate();

                File currentDir = new File(FoodMenuConstants.CommonConstants.IMAGE_DIRECTORY_PATH + currentCategory
                        .getCategoryName().toLowerCase());
                if (currentDir.exists()) {
                    File newDir = new File(FoodMenuConstants.CommonConstants.IMAGE_DIRECTORY_PATH + category
                            .getCategoryName().toLowerCase());
                    currentDir.renameTo(newDir);
                }
                updatedCategory = getCategoryById(connection, category.getCategoryId());
                connection.commit();
            } catch (SQLException | FoodItemException e) {
                connection.rollback(savepoint);
                throw new FoodItemException(
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_UPDATE_CATEGORY_FAILURE.getErrorMessage(),
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_UPDATE_CATEGORY_FAILURE.getErrorCode(), e);
            }
        } catch (SQLException e) {
            throw new FoodItemException(
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorMessage(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorCode(), e);
        }
        return updatedCategory;
    }

    @Override
    public List<FoodItem> deleteCategory(int categoryId) throws FoodItemException {
        //--reconsider the response
        String getDeletedItemsQuery = SQLQueries.GET_DELETED_ITEMS_QUERY;
        String deleteItemByCategoryQuery = SQLQueries.DELETE_ITEM_BY_CATEGORY_QUERY;
        String deleteCategoryQuery = SQLQueries.DELETE_CATEGORY_QUERY;
        Savepoint savepoint;
        List<FoodItem> deletedItems = new ArrayList<>();

        try (Connection connection = getDBConnection()) {
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint();
            try (PreparedStatement getItemsPrepStat = connection.prepareStatement(getDeletedItemsQuery);
                 PreparedStatement deleteItemsPrepStat = connection.prepareStatement(deleteItemByCategoryQuery);
                 PreparedStatement deleteCategoryPrepStat = connection.prepareStatement(deleteCategoryQuery)) {
                getItemsPrepStat.setInt(1, categoryId);
                Category currentCategory = getCategoryById(connection, categoryId);
                try (ResultSet itemsRes = getItemsPrepStat.executeQuery()) {
                    while (itemsRes.next()) {
                        FoodItem foodItem = new FoodItem();
                        foodItem.setItemId(itemsRes.getInt(1));
                        foodItem.setName(itemsRes.getString(2));
                        deletedItems.add(foodItem);
                    }
                }
                deleteItemsPrepStat.setInt(1, categoryId);
                deleteItemsPrepStat.executeUpdate();

                deleteCategoryPrepStat.setInt(1, categoryId);
                deleteCategoryPrepStat.executeUpdate();

                File currDir = new File(FoodMenuConstants.CommonConstants.IMAGE_DIRECTORY_PATH + currentCategory
                        .getCategoryName().toLowerCase());

                if (currDir.exists()) {
                    if (currDir.list().length == 0) {
                        currDir.delete();
                    } else {
                        String[] files = currDir.list();
                        for (String temp : files) {
                            File fileDelete = new File(currDir, temp);
                            fileDelete.delete();
                        }
                        currDir.delete();
                    }
                }
                connection.commit();
            } catch (SQLException e) {
                connection.rollback(savepoint);
                throw new FoodItemException(
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_DELETE_CATEGORY_FAILURE.getErrorCode(),
                        FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_DELETE_CATEGORY_FAILURE.getErrorMessage(), e);
            }
        } catch (SQLException e) {
            throw new FoodItemException(
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorCode(),
                    FoodMenuConstants.ErrorMessages.ERROR_MESSAGE_GET_CONNECTION_FAILURE.getErrorMessage(), e);
        }
        return deletedItems;
    }
}

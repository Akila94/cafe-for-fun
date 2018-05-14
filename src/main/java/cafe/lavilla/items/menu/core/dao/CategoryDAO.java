package cafe.lavilla.items.menu.core.dao;

import cafe.lavilla.items.menu.core.exception.FoodItemException;
import cafe.lavilla.items.menu.core.model.Category;
import cafe.lavilla.items.menu.core.model.FoodItem;

import java.util.List;

public interface CategoryDAO {
    public List<Category> getAllCategories() throws FoodItemException;
    public Category addCategory(Category category) throws FoodItemException;
    public Category updateCategory(Category category) throws FoodItemException;
    public List<FoodItem> deleteCategory(int categoryId) throws FoodItemException;
}

package cafe.lavilla.items.menu.core.dao;

import cafe.lavilla.items.menu.core.exception.FoodItemException;
import cafe.lavilla.items.menu.core.model.Category;
import cafe.lavilla.items.menu.core.model.FoodItem;

import java.util.List;

/**
 * Interface that contains the methods to operate on breakfast details.
 */
public interface FoodItemDAO {
    public FoodItem addItem(FoodItem foodItem) throws FoodItemException;
    public FoodItem updateItem(FoodItem foodItem) throws FoodItemException;
    public FoodItem deleteItem( int breakfastId) throws FoodItemException;
    public FoodItem getItem(int itemId) throws FoodItemException;
//    public List<FoodItem> getAllItems() throws FoodItemException;
    public List<FoodItem> getItemsByCategory(int categoryId) throws FoodItemException;
}

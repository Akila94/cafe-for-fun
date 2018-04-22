package cafe.lavilla.food.menu.core.dao;

import cafe.lavilla.food.menu.core.exception.FoodItemException;
import cafe.lavilla.food.menu.core.model.FoodItem;

import java.util.List;

/**
 * Interface that contains the methods to operate on salads details.
 */
public interface SaladsDAO {
    public FoodItem addSaladItem(FoodItem foodItem) throws FoodItemException;
    public FoodItem updateSaladItem(FoodItem foodItem) throws FoodItemException;
    public FoodItem deleteSaladItem(int saladId) throws FoodItemException;
    public FoodItem getSaladItem(int saladId) throws FoodItemException;
    public List<FoodItem> getAllSaladItems() throws FoodItemException;
}

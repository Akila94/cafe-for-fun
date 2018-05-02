package cafe.lavilla.food.menu.core.service;

import cafe.lavilla.food.menu.core.model.FoodItem;
import cafe.lavilla.food.menu.core.exception.FoodItemException;

import java.util.List;

/**
 * Interface that contains the methods to implement at the service impl.
 */
public interface FoodMenuCoreService {
    public List<FoodItem> getAllSaladItems() throws FoodItemException;
}

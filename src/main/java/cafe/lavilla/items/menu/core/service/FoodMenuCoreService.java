package cafe.lavilla.items.menu.core.service;

import cafe.lavilla.items.menu.core.exception.FoodItemException;
import cafe.lavilla.items.menu.core.model.FoodItem;

import java.util.List;

/**
 * Interface that contains the methods to implement at the service impl.
 */
public interface FoodMenuCoreService {
    public List<FoodItem> getAllSaladItems() throws FoodItemException;
}

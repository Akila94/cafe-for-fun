package service;

import exception.FoodItemException;
import model.FoodItem;

import java.util.List;

/**
 * Interface that contains the methods to implement at the service impl.
 */
public interface FoodMenuCoreService {
    public List<FoodItem> getAllSaladItems() throws FoodItemException;
}

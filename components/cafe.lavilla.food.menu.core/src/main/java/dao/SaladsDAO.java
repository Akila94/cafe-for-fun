package dao;

import exception.FoodItemException;
import model.FoodItem;

import java.util.List;

/**
 * Interface that contains the methods to operate on salads details.
 */
public interface SaladsDAO {
    public FoodItem addSaladItem(FoodItem foodItem) throws FoodItemException;
    public FoodItem updateSaladItem(FoodItem foodItem) throws FoodItemException;
    public FoodItem deleteSaladItem(FoodItem foodItem) throws FoodItemException;
    public FoodItem getSaladItem(String name) throws FoodItemException;
    public List<FoodItem> getAllSaladItems() throws FoodItemException;
}

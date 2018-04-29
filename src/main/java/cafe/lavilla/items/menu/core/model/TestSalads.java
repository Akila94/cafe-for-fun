package cafe.lavilla.items.menu.core.model;

import cafe.lavilla.items.menu.core.dao.impl.FoodItemDAOImpl;
import cafe.lavilla.items.menu.core.exception.FoodItemException;

import java.util.List;

/**
 * Created by shan.
 */
public class TestSalads {
    public static void main(String[] args) {
        FoodItemDAOImpl foodItemDAO = new FoodItemDAOImpl();
        try {
            List allItems = foodItemDAO.getAllItems();
            System.out.println(allItems.size());
            System.out.println();
            for (Object allItem : allItems) {
                List<FoodItem> foodItems = (List<FoodItem>) allItem;
                for (FoodItem foodItem : foodItems) {
                    System.out.println(foodItem.getName());
                    System.out.println();
                }
            }
        } catch (FoodItemException e) {
            e.printStackTrace();
        }
    }
}

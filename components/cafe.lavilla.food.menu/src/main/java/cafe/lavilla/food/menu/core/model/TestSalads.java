package cafe.lavilla.food.menu.core.model;

import cafe.lavilla.food.menu.core.dao.impl.SaladsDAOImpl;
import cafe.lavilla.food.menu.core.exception.FoodItemException;

/**
 * Created by shan.
 */
public class TestSalads {
    public static void main(String[] args) {
        SaladsDAOImpl saladsDAOImpl = new SaladsDAOImpl();
        try {
            FoodItem salad = saladsDAOImpl.getSaladItem(1);
            System.out.println(salad.getId());
            System.out.println(salad.getName());
            System.out.println(salad.getPrice());
        } catch (FoodItemException e) {
            e.printStackTrace();
        }
    }
}

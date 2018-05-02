package cafe.lavilla.food.menu.core.service;

import cafe.lavilla.food.menu.core.dao.SaladsDAO;
import cafe.lavilla.food.menu.core.dao.impl.SaladsDAOImpl;
import cafe.lavilla.food.menu.core.exception.FoodItemException;
import cafe.lavilla.food.menu.core.model.FoodItem;

import java.util.List;

/**
 * Class that implements the service methods.
 */
public class FoodMenuCoreServiceImpl implements FoodMenuCoreService {
    private SaladsDAO saladsDAO = new SaladsDAOImpl();

    @Override
    public List<FoodItem> getAllSaladItems() throws FoodItemException {
        return saladsDAO.getAllSaladItems();
    }
}

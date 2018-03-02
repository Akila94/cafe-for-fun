package service;

import dao.SaladsDAO;
import dao.impl.SaladsDAOImpl;
import exception.FoodItemException;
import model.FoodItem;

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

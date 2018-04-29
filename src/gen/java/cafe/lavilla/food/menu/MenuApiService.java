package cafe.lavilla.food.menu;

import cafe.lavilla.food.menu.*;
import cafe.lavilla.food.menu.dto.*;

import cafe.lavilla.food.menu.dto.CategoriesDTO;
import cafe.lavilla.food.menu.dto.ErrorDTO;
import cafe.lavilla.food.menu.dto.FoodDetailsDTO;

import java.util.List;

import java.io.InputStream;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import javax.ws.rs.core.Response;

public abstract class MenuApiService {
    public abstract Response deleteFoodItem(String category,Integer id);
    public abstract Response getCategories();
    public abstract Response getFoodItem(String category,Integer id);
    public abstract Response setFoodItem(FoodDetailsDTO body);
    public abstract Response updateFoodItem(Integer id,FoodDetailsDTO body);
}

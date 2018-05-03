package cafe.lavilla.items.menu;

import cafe.lavilla.items.menu.*;
import cafe.lavilla.items.menu.dto.*;

import cafe.lavilla.items.menu.dto.CategoriesDTO;
import cafe.lavilla.items.menu.dto.ErrorDTO;
import cafe.lavilla.items.menu.dto.GroupDTO;
import cafe.lavilla.items.menu.dto.FoodDetailsDTO;
import java.io.File;

import java.util.List;

import java.io.InputStream;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import javax.ws.rs.core.Response;

public abstract class MenuApiService {
    public abstract Response deleteFoodItem(String category,Integer id);
    public abstract Response getCategories();
    public abstract Response getCategory(String category);
    public abstract Response getFoodItem(String category,Integer id);
    public abstract Response menuImageNamePost(String name,InputStream imageInputStream,Attachment imageDetail);
    public abstract Response menuImageNamePut(String name,InputStream imageInputStream,Attachment imageDetail);
    public abstract Response setFoodItem(FoodDetailsDTO body);
    public abstract Response updateFoodItem(FoodDetailsDTO body);
}


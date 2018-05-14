package cafe.lavilla.items.menu;

import cafe.lavilla.items.menu.*;
import cafe.lavilla.items.menu.dto.*;

import cafe.lavilla.items.menu.dto.CategoryDTO;
import cafe.lavilla.items.menu.dto.ErrorDTO;
import cafe.lavilla.items.menu.dto.FoodDetailsDTO;
import cafe.lavilla.items.menu.dto.GroupDTO;
import cafe.lavilla.items.menu.dto.ImageDTO;
import java.io.File;
import cafe.lavilla.items.menu.dto.SuccessDTO;
import cafe.lavilla.items.menu.dto.CategoryDetailsDTO;
import cafe.lavilla.items.menu.dto.CategoryListDTO;

import java.util.List;

import java.io.InputStream;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import javax.ws.rs.core.Response;

public abstract class MenuApiService {
    public abstract Response deleteFoodItem(Integer id);
    public abstract Response getCategories();
    public abstract Response getFoodItem(Integer id);
    public abstract Response getItemsByCategory(Integer category);
    public abstract Response menuImageUploadTmpPost(InputStream imageInputStream,Attachment imageDetail);
    public abstract Response menuImageUploadTmpPut(InputStream imageInputStream,Attachment imageDetail);
    public abstract Response menuItemConfigurationPost(FoodDetailsDTO foodItem);
    public abstract Response menuItemsCategoriesDelete(CategoryDetailsDTO category);
    public abstract Response menuItemsCategoriesGet();
    public abstract Response menuItemsCategoriesPost(CategoryDetailsDTO category);
    public abstract Response menuItemsCategoriesPut(CategoryDetailsDTO category);
    public abstract Response setFoodItem(FoodDetailsDTO body);
    public abstract Response updateFoodItem(FoodDetailsDTO body);
}


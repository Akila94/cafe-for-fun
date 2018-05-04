package cafe.lavilla.items.menu;

import cafe.lavilla.items.menu.*;
import cafe.lavilla.items.menu.dto.*;

import cafe.lavilla.items.menu.dto.CategoryDTO;
import cafe.lavilla.items.menu.dto.ErrorDTO;
import cafe.lavilla.items.menu.dto.GroupDTO;
import cafe.lavilla.items.menu.dto.FoodDetailsDTO;
import cafe.lavilla.items.menu.dto.ImageDTO;
import java.io.File;
import cafe.lavilla.items.menu.dto.SuccessDTO;

import java.util.List;

import java.io.InputStream;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import javax.ws.rs.core.Response;

public abstract class MenuApiService {
    public abstract Response deleteFoodItem(String category,Integer id);
    public abstract Response getCategories();
    public abstract Response getCategory(String category);
    public abstract Response getFoodItem(String category,Integer id);
    public abstract Response menuImageUploadTmpPost(String name,InputStream imageInputStream,Attachment imageDetail);
    public abstract Response menuImageUploadTmpPut(String name,InputStream imageInputStream,Attachment imageDetail);
    public abstract Response setFoodItem(FoodDetailsDTO body);
    public abstract Response updateFoodItem(FoodDetailsDTO body);
}


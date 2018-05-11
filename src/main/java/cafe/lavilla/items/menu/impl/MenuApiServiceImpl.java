package cafe.lavilla.items.menu.impl;

import cafe.lavilla.items.menu.ApiResponseMessage;
import cafe.lavilla.items.menu.MenuApiService;
import cafe.lavilla.items.menu.core.dao.impl.FoodItemDAOImpl;
import cafe.lavilla.items.menu.core.exception.FoodItemException;
import cafe.lavilla.items.menu.core.imageconverter.ImageDecoder;
import cafe.lavilla.items.menu.core.model.Category;
import cafe.lavilla.items.menu.core.model.FoodItem;
import cafe.lavilla.items.menu.dto.CategoriesDTO;
import cafe.lavilla.items.menu.dto.CategoryDTO;
import cafe.lavilla.items.menu.dto.CategoryDetailsDTO;
import cafe.lavilla.items.menu.dto.ErrorDTO;
import cafe.lavilla.items.menu.dto.FoodDetailsDTO;
import cafe.lavilla.items.menu.dto.GroupDTO;
import cafe.lavilla.items.menu.dto.ImageDTO;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MenuApiServiceImpl extends MenuApiService {

    @Override
    public Response deleteFoodItem(String category, Integer id) {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response getCategories() {

        FoodItemDAOImpl foodItemDAO = new FoodItemDAOImpl();
        CategoryDTO categoryDTO = new CategoryDTO();
        CategoriesDTO categoriesDTO = new CategoriesDTO();
//        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        List<FoodItem> foodItemList;
        try {
            foodItemList = foodItemDAO.getItemsByCategory("Breakfast");
            List<FoodDetailsDTO> breakfastItems = new ArrayList<>();
            for (FoodItem foodItem : foodItemList) {
                breakfastItems.add(setFoodDetailsDTO(foodItem));
            }
            categoriesDTO.setBreakfast(breakfastItems);

            foodItemList = foodItemDAO.getItemsByCategory("Hot Drinks");
            List<FoodDetailsDTO> hotDrinks = new ArrayList<>();
            for (FoodItem foodItem : foodItemList) {
                hotDrinks.add(setFoodDetailsDTO(foodItem));
            }
            categoriesDTO.setHotDrinks(hotDrinks);

            foodItemList = foodItemDAO.getItemsByCategory("Desserts");
            List<FoodDetailsDTO> desserts = new ArrayList<>();
            for (FoodItem foodItem : foodItemList) {
                desserts.add(setFoodDetailsDTO(foodItem));
            }
            categoriesDTO.setDesserts(desserts);

            foodItemList = foodItemDAO.getItemsByCategory("French Toast");
            List<FoodDetailsDTO> frenchToasts = new ArrayList<>();
            for (FoodItem foodItem : foodItemList) {
                frenchToasts.add(setFoodDetailsDTO(foodItem));
            }
            categoriesDTO.setFrenchToast(frenchToasts);

            foodItemList = foodItemDAO.getItemsByCategory("Main Course");
            List<FoodDetailsDTO> mainCourse = new ArrayList<>();
            for (FoodItem foodItem : foodItemList) {
                mainCourse.add(setFoodDetailsDTO(foodItem));
            }
            categoriesDTO.setMainCource(mainCourse);

            foodItemList = foodItemDAO.getItemsByCategory("Pancakes");
            List<FoodDetailsDTO> pancakes = new ArrayList<>();
            for (FoodItem foodItem : foodItemList) {
                pancakes.add(setFoodDetailsDTO(foodItem));
            }
            categoriesDTO.setPancake(pancakes);

            foodItemList = foodItemDAO.getItemsByCategory("Pasta");
            List<FoodDetailsDTO> pastas = new ArrayList<>();
            for (FoodItem foodItem : foodItemList) {
                pastas.add(setFoodDetailsDTO(foodItem));
            }
            categoriesDTO.setPastas(pastas);

            foodItemList = foodItemDAO.getItemsByCategory("Quenchers");
            List<FoodDetailsDTO> quenchers = new ArrayList<>();
            for (FoodItem foodItem : foodItemList) {
                quenchers.add(setFoodDetailsDTO(foodItem));
            }
            categoriesDTO.setQuenchers(quenchers);

            foodItemList = foodItemDAO.getItemsByCategory("Salads");
            List<FoodDetailsDTO> salads = new ArrayList<>();
            for (FoodItem foodItem : foodItemList) {
                salads.add(setFoodDetailsDTO(foodItem));
            }
            categoriesDTO.setSalad(salads);

            foodItemList = foodItemDAO.getItemsByCategory("Starters");
            List<FoodDetailsDTO> starters = new ArrayList<>();
            for (FoodItem foodItem : foodItemList) {
                starters.add(setFoodDetailsDTO(foodItem));
            }
            categoriesDTO.setStarters(starters);

            foodItemList = foodItemDAO.getItemsByCategory("Waffles");
            List<FoodDetailsDTO> waffles = new ArrayList<>();
            for (FoodItem foodItem : foodItemList) {
                waffles.add(setFoodDetailsDTO(foodItem));
            }
            categoriesDTO.setWaffles(waffles);
            categoryDTO.setCategories(categoriesDTO);
//            categoryDTOList.add(categoryDTO);
            return Response.ok().entity(categoryDTO).header("Access-Control-Allow-Origin", "*").build();
        } catch (FoodItemException e) {
            ErrorDTO errorDTO = setErrorDTO(e);
            return Response.ok().entity(errorDTO).header("Access-Control-Allow-Origin", "*").build();
        }

    }

    @Override
    public Response getCategory(String category) {

        FoodItemDAOImpl foodItemDAO = new FoodItemDAOImpl();
        try {
            List<FoodItem> foodItemList = foodItemDAO.getItemsByCategory(category);
            GroupDTO groupDTO = new GroupDTO();
            for (FoodItem aFoodItemList : foodItemList) {
                FoodDetailsDTO foodDetailsDTO = new FoodDetailsDTO();
                foodDetailsDTO.setId(aFoodItemList.getId());
                foodDetailsDTO.setTitle(aFoodItemList.getName());
                foodDetailsDTO.setDescription(aFoodItemList.getDescription());
                foodDetailsDTO.setPrice(aFoodItemList.getPrice());
                foodDetailsDTO.setImageSource(aFoodItemList.getImgLocation());
                groupDTO.add(foodDetailsDTO);
            }
            return Response.ok().entity(groupDTO).header("Access-Control-Allow-Origin", "*").build();
        } catch (FoodItemException e) {
            ErrorDTO errorDTO = setErrorDTO(e);
            return Response.ok().entity(errorDTO).header("Access-Control-Allow-Origin", "*").build();
        }
    }

    private FoodDetailsDTO setFoodDetailsDTO(FoodItem foodItem) {

        FoodDetailsDTO foodDetailsDTO = new FoodDetailsDTO();
        foodDetailsDTO.setId(foodItem.getId());
        foodDetailsDTO.setTitle(foodItem.getName());
        foodDetailsDTO.setDescription(foodItem.getDescription());
        foodDetailsDTO.setPrice(foodItem.getPrice());
        foodDetailsDTO.setImageSource(foodItem.getImgLocation());
        return foodDetailsDTO;
    }

    @Override
    public Response getFoodItem(String category, Integer id) {

        FoodItemDAOImpl foodItemDAO = new FoodItemDAOImpl();
        FoodDetailsDTO foodDetailsDTO = new FoodDetailsDTO();
        try {
            FoodItem foodItem = foodItemDAO.getItem(category, id);
            foodDetailsDTO.setId(foodItem.getId());
            foodDetailsDTO.setTitle(foodItem.getName());
            foodDetailsDTO.setDescription(foodItem.getDescription());
            foodDetailsDTO.setPrice(foodItem.getPrice());
            foodDetailsDTO.setImageSource(foodItem.getImgLocation());
            return Response.ok().entity(foodDetailsDTO).header("Access-Control-Allow-Origin", "*").build();
        } catch (FoodItemException e) {
            ErrorDTO errorDTO = setErrorDTO(e);
            return Response.ok().entity(errorDTO).header("Access-Control-Allow-Origin", "*").build();
        }
    }

    @Override
    public Response menuImageUploadTmpPost(InputStream imageInputStream, Attachment imageDetail) {

        ImageDecoder imageDecoder = new ImageDecoder();
        ImageDTO imageDTO = new ImageDTO();
        try {
            List<String> imageDetails = imageDecoder.saveImage(imageInputStream, "tmp", 0);
            imageDTO.setImageUrl(imageDetails.get(0));
            imageDTO.setImageName(imageDetails.get(1));

            return Response.ok(imageDTO).header("Access-Control-Allow-Origin", "*").build();
        } catch (FoodItemException e) {
            ErrorDTO errorDTO = setErrorDTO(e);
            return Response.serverError().entity(errorDTO).header("Access-Control-Allow-Origin", "*").build();
        }
    }

    @Override
    public Response menuImageUploadTmpPut(InputStream imageInputStream, Attachment imageDetail) {

        return null;
    }

    @Override
    public Response menuItemConfigurationPost(FoodDetailsDTO foodDetails) {

        FoodItem foodItem = new FoodItem();
        FoodItem addedFoodItem;
        FoodItemDAOImpl foodItemDAO = new FoodItemDAOImpl();

        foodItem.setCategory(foodDetails.getCategory());
        foodItem.setName(foodDetails.getTitle());
        foodItem.setDescription(foodDetails.getDescription());
        foodItem.setPrice(foodDetails.getPrice());
        foodItem.setImgLocation(foodDetails.getImageSource());
        try {
            addedFoodItem = foodItemDAO.addItem(foodItem);
            FoodDetailsDTO foodDetailsDTO = new FoodDetailsDTO();
            foodDetailsDTO.setId(addedFoodItem.getId());
            foodDetailsDTO.setTitle(addedFoodItem.getName());
            foodDetailsDTO.setDescription(addedFoodItem.getDescription());
            foodDetailsDTO.setImageSource(addedFoodItem.getImgLocation());
            return Response.ok().entity(foodDetailsDTO).header("Access-Control-Allow-Origin", "*").build();
        } catch (FoodItemException e) {
            ErrorDTO errorDTO = setErrorDTO(e);
            return Response.serverError().entity(errorDTO).header("Access-Control-Allow-Origin", "*").build();
        }
    }

    @Override public Response menuItemsCategoriesDelete(CategoryDetailsDTO category) {
        return null;
    }

    @Override public Response menuItemsCategoriesGet() {

        FoodItemDAOImpl foodItemDAO = new FoodItemDAOImpl();

        try {
            List<Category> categoryList = foodItemDAO.getAllCategories();
            List<CategoryDetailsDTO> categoryDetailsDTOList = new ArrayList<>();
            for (Category aCategoryList : categoryList) {
                CategoryDetailsDTO categoryDetailsDTO = new CategoryDetailsDTO();
                categoryDetailsDTO.setCategoryId(aCategoryList.getCategoryId());
                categoryDetailsDTO.setCategoryName(aCategoryList.getCategoryName());
                categoryDetailsDTOList.add(categoryDetailsDTO);
            }
            return Response.serverError().entity(categoryDetailsDTOList).header("Access-Control-Allow-Origin", "*")
                    .build();
        } catch (FoodItemException e) {
            ErrorDTO errorDTO = setErrorDTO(e);
            return Response.serverError().entity(errorDTO).header("Access-Control-Allow-Origin", "*").build();
        }
    }

    @Override public Response menuItemsCategoriesPost(CategoryDetailsDTO category) {
        return null;
    }

    @Override public Response menuItemsCategoriesPut(CategoryDetailsDTO category) {
        return null;
    }

    @Override
    public Response setFoodItem(FoodDetailsDTO body) {

        return null;
    }

    @Override
    public Response updateFoodItem(FoodDetailsDTO body) {

        FoodItem foodItem = new FoodItem();
        FoodItem updatedFoodItem;
        FoodDetailsDTO foodDetailsDTO = new FoodDetailsDTO();
        FoodItemDAOImpl foodItemDAO = new FoodItemDAOImpl();

        foodItem.setCategory(body.getCategory());
        foodItem.setId(body.getId());
        foodItem.setName(body.getTitle());
        foodItem.setDescription(body.getDescription());
        foodItem.setImgLocation(body.getImageSource());

        try {
            updatedFoodItem = foodItemDAO.updateItem(foodItem);
            foodDetailsDTO.setId(updatedFoodItem.getId());
            foodDetailsDTO.setTitle(updatedFoodItem.getName());
            foodDetailsDTO.setDescription(updatedFoodItem.getDescription());
            foodDetailsDTO.setPrice(updatedFoodItem.getPrice());
            foodDetailsDTO.setImageSource(updatedFoodItem.getImgLocation());
            return Response.serverError().entity(foodDetailsDTO).header("Access-Control-Allow-Origin", "*").build();
        } catch (FoodItemException e) {
            ErrorDTO errorDTO = setErrorDTO(e);
            return Response.serverError().entity(errorDTO).header("Access-Control-Allow-Origin", "*").build();
        }
    }

    private ErrorDTO setErrorDTO(FoodItemException e) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setErrorCode(e.getErrorCode());
        errorDTO.setErrorMessage(e.getMessage());
        errorDTO.setErrorCause(e.getCause().getMessage());
        return errorDTO;
    }
}

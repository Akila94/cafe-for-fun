package cafe.lavilla.items.menu.impl;

import cafe.lavilla.items.menu.MenuApiService;
import cafe.lavilla.items.menu.core.dao.impl.CategoryDAOImpl;
import cafe.lavilla.items.menu.core.dao.impl.FoodItemDAOImpl;
import cafe.lavilla.items.menu.core.exception.FoodItemException;
import cafe.lavilla.items.menu.core.imageconverter.ImageDecoder;
import cafe.lavilla.items.menu.core.model.Category;
import cafe.lavilla.items.menu.core.model.FoodItem;
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

    /*###########Method to get all item details###########*/
    @Override
    public Response getCategories() {

//        FoodItemDAOImpl foodItemDAO = new FoodItemDAOImpl();
//        CategoryDTO categoryDTO = new CategoryDTO();
//        CategoriesDTO categoriesDTO = new CategoriesDTO();
////        List<CategoryDTO> categoryDTOList = new ArrayList<>();
//        List<FoodItem> foodItemList;
//        try {
//            foodItemList = foodItemDAO.getItemsByCategory("Breakfast");
//            List<FoodDetailsDTO> breakfastItems = new ArrayList<>();
//            for (FoodItem foodItem : foodItemList) {
//                breakfastItems.add(setFoodDetailsDTO(foodItem));
//            }
//            categoriesDTO.setBreakfast(breakfastItems);
//
//            foodItemList = foodItemDAO.getItemsByCategory("Hot Drinks");
//            List<FoodDetailsDTO> hotDrinks = new ArrayList<>();
//            for (FoodItem foodItem : foodItemList) {
//                hotDrinks.add(setFoodDetailsDTO(foodItem));
//            }
//            categoriesDTO.setHotDrinks(hotDrinks);
//
//            foodItemList = foodItemDAO.getItemsByCategory("Desserts");
//            List<FoodDetailsDTO> desserts = new ArrayList<>();
//            for (FoodItem foodItem : foodItemList) {
//                desserts.add(setFoodDetailsDTO(foodItem));
//            }
//            categoriesDTO.setDesserts(desserts);
//
//            foodItemList = foodItemDAO.getItemsByCategory("French Toast");
//            List<FoodDetailsDTO> frenchToasts = new ArrayList<>();
//            for (FoodItem foodItem : foodItemList) {
//                frenchToasts.add(setFoodDetailsDTO(foodItem));
//            }
//            categoriesDTO.setFrenchToast(frenchToasts);
//
//            foodItemList = foodItemDAO.getItemsByCategory("Main Course");
//            List<FoodDetailsDTO> mainCourse = new ArrayList<>();
//            for (FoodItem foodItem : foodItemList) {
//                mainCourse.add(setFoodDetailsDTO(foodItem));
//            }
//            categoriesDTO.setMainCource(mainCourse);
//
//            foodItemList = foodItemDAO.getItemsByCategory("Pancakes");
//            List<FoodDetailsDTO> pancakes = new ArrayList<>();
//            for (FoodItem foodItem : foodItemList) {
//                pancakes.add(setFoodDetailsDTO(foodItem));
//            }
//            categoriesDTO.setPancake(pancakes);
//
//            foodItemList = foodItemDAO.getItemsByCategory("Pasta");
//            List<FoodDetailsDTO> pastas = new ArrayList<>();
//            for (FoodItem foodItem : foodItemList) {
//                pastas.add(setFoodDetailsDTO(foodItem));
//            }
//            categoriesDTO.setPastas(pastas);
//
//            foodItemList = foodItemDAO.getItemsByCategory("Quenchers");
//            List<FoodDetailsDTO> quenchers = new ArrayList<>();
//            for (FoodItem foodItem : foodItemList) {
//                quenchers.add(setFoodDetailsDTO(foodItem));
//            }
//            categoriesDTO.setQuenchers(quenchers);
//
//            foodItemList = foodItemDAO.getItemsByCategory("Salads");
//            List<FoodDetailsDTO> salads = new ArrayList<>();
//            for (FoodItem foodItem : foodItemList) {
//                salads.add(setFoodDetailsDTO(foodItem));
//            }
//            categoriesDTO.setSalad(salads);
//
//            foodItemList = foodItemDAO.getItemsByCategory("Starters");
//            List<FoodDetailsDTO> starters = new ArrayList<>();
//            for (FoodItem foodItem : foodItemList) {
//                starters.add(setFoodDetailsDTO(foodItem));
//            }
//            categoriesDTO.setStarters(starters);
//
//            foodItemList = foodItemDAO.getItemsByCategory("Waffles");
//            List<FoodDetailsDTO> waffles = new ArrayList<>();
//            for (FoodItem foodItem : foodItemList) {
//                waffles.add(setFoodDetailsDTO(foodItem));
//            }
//            categoriesDTO.setWaffles(waffles);
//            categoryDTO.setCategories(categoriesDTO);
////            categoryDTOList.add(categoryDTO);
//            return Response.ok().entity(categoryDTO).header("Access-Control-Allow-Origin", "*").build();
//        } catch (FoodItemException e) {
//            ErrorDTO errorDTO = setErrorDTO(e);
//            return Response.ok().entity(errorDTO).header("Access-Control-Allow-Origin", "*").build();
//        }
        return null;

    }

    /*###########Methods to configure image details###########*/
    @Override
    public Response menuImageUploadTmpPost(InputStream imageInputStream, Attachment imageDetail) {

        ImageDecoder imageDecoder = new ImageDecoder();
        ImageDTO imageDTO = new ImageDTO();
        try {
            List<String> imageDetails = imageDecoder.saveImage(imageInputStream, "tmp", 0);
            imageDTO.setImageUrl(imageDetails.get(0));
            imageDTO.setImageName(imageDetails.get(1));

            return Response.ok(imageDTO).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        } catch (FoodItemException e) {
            ErrorDTO errorDTO = setErrorDTO(e);
            return Response.serverError().entity(errorDTO).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        }
    }

    @Override
    public Response menuImageUploadTmpPut(InputStream imageInputStream, Attachment imageDetail) {

        return null;
    }

    /*###########Methods to configure item details###########*/
    @Override
    public Response menuItemConfigurationPost(FoodDetailsDTO foodDetails) {

        FoodItem foodItem = new FoodItem();
        FoodItem addedFoodItem;
        FoodItemDAOImpl foodItemDAO = new FoodItemDAOImpl();

        foodItem.setCategoryId(foodDetails.getCategoryId());
        foodItem.setCategory(foodDetails.getCategory());
        foodItem.setName(foodDetails.getTitle());
        foodItem.setDescription(foodDetails.getDescription());
        foodItem.setPrice(foodDetails.getPrice());
        foodItem.setImgLocation(foodDetails.getImageSource());
        try {
            addedFoodItem = foodItemDAO.addItem(foodItem);
            FoodDetailsDTO foodDetailsDTO = new FoodDetailsDTO();
            foodDetailsDTO.setCategoryId(addedFoodItem.getCategoryId());
            foodDetailsDTO.setCategory(addedFoodItem.getCategory());
            foodDetailsDTO.setItemId(addedFoodItem.getItemId());
            foodDetailsDTO.setTitle(addedFoodItem.getName());
            foodDetailsDTO.setDescription(addedFoodItem.getDescription());
            foodDetailsDTO.setPrice(addedFoodItem.getPrice());
            foodDetailsDTO.setImageSource(addedFoodItem.getImgLocation());
            return Response.ok().entity(foodDetailsDTO).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        } catch (FoodItemException e) {
            ErrorDTO errorDTO = setErrorDTO(e);
            return Response.serverError().entity(errorDTO).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        }
    }

    @Override
    public Response updateFoodItem(FoodDetailsDTO body) {

        FoodItem foodItem = new FoodItem();
        FoodItem updatedFoodItem;
        FoodDetailsDTO foodDetailsDTO = new FoodDetailsDTO();
        FoodItemDAOImpl foodItemDAO = new FoodItemDAOImpl();

        foodItem.setCategoryId(body.getCategoryId());
        foodItem.setCategory(body.getCategory());
        foodItem.setItemId(body.getItemId());
        foodItem.setName(body.getTitle());
        foodItem.setDescription(body.getDescription());
        foodItem.setPrice(body.getPrice());
        foodItem.setImgLocation(body.getImageSource());

        try {
            updatedFoodItem = foodItemDAO.updateItem(foodItem);
            foodDetailsDTO.setCategoryId(updatedFoodItem.getCategoryId());
            foodDetailsDTO.setCategory(updatedFoodItem.getCategory());
            foodDetailsDTO.setItemId(updatedFoodItem.getItemId());
            foodDetailsDTO.setTitle(updatedFoodItem.getName());
            foodDetailsDTO.setDescription(updatedFoodItem.getDescription());
            foodDetailsDTO.setPrice(updatedFoodItem.getPrice());
            foodDetailsDTO.setImageSource(updatedFoodItem.getImgLocation());
            return Response.serverError().entity(foodDetailsDTO).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        } catch (FoodItemException e) {
            ErrorDTO errorDTO = setErrorDTO(e);
            return Response.serverError().entity(errorDTO).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        }
    }

    @Override
    public Response getFoodItem(Integer id) {

        FoodItemDAOImpl foodItemDAO = new FoodItemDAOImpl();
        FoodDetailsDTO foodDetailsDTO = new FoodDetailsDTO();
        try {
            FoodItem foodItem = foodItemDAO.getItem(id);
            foodDetailsDTO.setCategoryId(foodItem.getCategoryId());
            foodDetailsDTO.setCategory(foodItem.getCategory());
            foodDetailsDTO.setItemId(foodItem.getItemId());
            foodDetailsDTO.setTitle(foodItem.getName());
            foodDetailsDTO.setDescription(foodItem.getDescription());
            foodDetailsDTO.setPrice(foodItem.getPrice());
            foodDetailsDTO.setImageSource(foodItem.getImgLocation());
            return Response.ok().entity(foodDetailsDTO).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        } catch (FoodItemException e) {
            ErrorDTO errorDTO = setErrorDTO(e);
            return Response.ok().entity(errorDTO).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        }
    }

    @Override
    public Response getItemsByCategory(Integer categoryId) {

        FoodItemDAOImpl foodItemDAO = new FoodItemDAOImpl();
        try {
            List<FoodItem> foodItemList = foodItemDAO.getItemsByCategory(categoryId);
            GroupDTO groupDTO = new GroupDTO();
            for (FoodItem foodItem : foodItemList) {
                FoodDetailsDTO foodDetailsDTO = new FoodDetailsDTO();
                foodDetailsDTO.setCategoryId(foodItem.getCategoryId());
                foodDetailsDTO.setCategory(foodItem.getCategory());
                foodDetailsDTO.setItemId(foodItem.getItemId());
                foodDetailsDTO.setTitle(foodItem.getName());
                foodDetailsDTO.setDescription(foodItem.getDescription());
                foodDetailsDTO.setPrice(foodItem.getPrice());
                foodDetailsDTO.setImageSource(foodItem.getImgLocation());
                groupDTO.add(foodDetailsDTO);
            }
            return Response.ok().entity(groupDTO).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        } catch (FoodItemException e) {
            ErrorDTO errorDTO = setErrorDTO(e);
            return Response.ok().entity(errorDTO).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        }
    }

    @Override
    public Response deleteFoodItem(Integer id) {

        FoodItemDAOImpl foodItemDAO = new FoodItemDAOImpl();

        try {
            FoodItem foodItem = foodItemDAO.deleteItem(id);
            FoodDetailsDTO deletedItemDetails = new FoodDetailsDTO();
            deletedItemDetails.setItemId(foodItem.getItemId());
            deletedItemDetails.setTitle(foodItem.getName());
            deletedItemDetails.setDescription(foodItem.getDescription());
            return Response.ok().entity(deletedItemDetails).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        } catch (FoodItemException e) {
            ErrorDTO errorDTO = setErrorDTO(e);
            return Response.ok().entity(errorDTO).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        }
    }

    /*###########Methods to configure category details###########*/
    @Override
    public Response menuItemsCategoriesDelete(CategoryDetailsDTO category) {

        CategoryDAOImpl categoryDAO = new CategoryDAOImpl();

        try {
            List<FoodItem> items = categoryDAO.deleteCategory(category.getCategoryId());
            List<FoodDetailsDTO> deletedItems = new ArrayList<>();
            for (FoodItem item : items) {
                FoodDetailsDTO itemDTO = new FoodDetailsDTO();
                itemDTO.setItemId(item.getItemId());
                itemDTO.setTitle(item.getName());
                deletedItems.add(itemDTO);
            }
            return Response.ok().entity(deletedItems).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        } catch (FoodItemException e) {
            ErrorDTO errorDTO = setErrorDTO(e);
            return Response.serverError().entity(errorDTO).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        }
    }

    @Override public Response menuItemsCategoriesGet() {

        CategoryDAOImpl categoryDAO = new CategoryDAOImpl();

        try {
            List<Category> categoryList = categoryDAO.getAllCategories();
            List<CategoryDetailsDTO> categoryDetailsDTOList = new ArrayList<>();
            for (Category category : categoryList) {
                CategoryDetailsDTO categoryDetailsDTO = new CategoryDetailsDTO();
                categoryDetailsDTO.setCategoryId(category.getCategoryId());
                categoryDetailsDTO.setCategoryName(category.getCategoryName());
                categoryDetailsDTOList.add(categoryDetailsDTO);
            }
            return Response.serverError().entity(categoryDetailsDTOList).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        } catch (FoodItemException e) {
            ErrorDTO errorDTO = setErrorDTO(e);
            return Response.serverError().entity(errorDTO).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        }
    }

    @Override
    public Response menuItemsCategoriesPost(CategoryDetailsDTO categoryDetailsDTO) {

        CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
        Category category = new Category();
        category.setCategoryName(categoryDetailsDTO.getCategoryName());

        try {
            Category addedCategory = categoryDAO.addCategory(category);
            CategoryDetailsDTO addedCategoryDetails = new CategoryDetailsDTO();
            addedCategoryDetails.setCategoryId(addedCategory.getCategoryId());
            addedCategoryDetails.setCategoryName(addedCategory.getCategoryName());
            return Response.ok().entity(addedCategoryDetails).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        } catch (FoodItemException e) {
            ErrorDTO errorDTO = setErrorDTO(e);
            return Response.serverError().entity(errorDTO).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        }
    }

    @Override
    public Response menuItemsCategoriesPut(CategoryDetailsDTO categoryDetailsDTO) {

        CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
        Category updatingCategory = new Category();
        updatingCategory.setCategoryId(categoryDetailsDTO.getCategoryId());
        updatingCategory.setCategoryName(categoryDetailsDTO.getCategoryName());

        try {
            Category updatedCategory = categoryDAO.updateCategory(updatingCategory);
            CategoryDetailsDTO updatedCategoryDTO = new CategoryDetailsDTO();
            updatedCategoryDTO.setCategoryId(updatedCategory.getCategoryId());
            updatedCategoryDTO.setCategoryName(updatedCategory.getCategoryName());
            return Response.ok().entity(updatedCategoryDTO).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        } catch (FoodItemException e) {
            ErrorDTO errorDTO = setErrorDTO(e);
            return Response.serverError().entity(errorDTO).header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
        }
    }

    private ErrorDTO setErrorDTO(FoodItemException e) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setErrorCode(e.getErrorCode());
        errorDTO.setErrorMessage(e.getMessage());
        errorDTO.setErrorCause(e.getCause().getMessage());
        return errorDTO;
    }

    @Override
    public Response setFoodItem(FoodDetailsDTO body) {

        return null;
    }
}
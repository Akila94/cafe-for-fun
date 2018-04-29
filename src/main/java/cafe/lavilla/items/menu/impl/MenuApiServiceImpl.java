package cafe.lavilla.items.menu.impl;

import cafe.lavilla.food.menu.ApiResponseMessage;
import cafe.lavilla.food.menu.MenuApiService;
import cafe.lavilla.items.menu.core.dao.impl.FoodItemDAOImpl;
import cafe.lavilla.items.menu.core.exception.FoodItemException;
import cafe.lavilla.items.menu.core.model.FoodItem;
import cafe.lavilla.food.menu.dto.CategoriesDTO;
import cafe.lavilla.food.menu.dto.CategoryDTO;
import cafe.lavilla.food.menu.dto.FoodDetailsDTO;

import javax.ws.rs.core.Response;
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
//        FoodItemDAOImpl foodItemDAO = new FoodItemDAOImpl();
//        CategoriesDTO categoriesDTO = new CategoriesDTO();
//        List<CategoryDTO> categoryDTOS = new ArrayList<>();
//        CategoryDTO categoryDTO = new CategoryDTO();
//        try {
//            List allItems = foodItemDAO.getAllItems();
//            for (Object allItem : allItems) {
//                List<FoodItem> foodItems = (List<FoodItem>) allItem;
//                List<FoodDetailsDTO> foodDetailsDTOS = new ArrayList<>();
//                for (FoodItem foodItem : foodItems) {
//                    FoodDetailsDTO foodDetailsDTO = new FoodDetailsDTO();
//                    foodDetailsDTO.setId(foodItem.getId());
//                    foodDetailsDTO.setTitle(foodItem.getName());
//                    foodDetailsDTO.setDescription(foodItem.getDescription());
//                    foodDetailsDTO.setPrice(foodItem.getPrice());
//                    foodDetailsDTO.setImageSource(foodItem.getImgLocation());
//                    foodDetailsDTOS.add(foodDetailsDTO);
//                }
//                categoryDTO.setSalad(foodDetailsDTOS);
//                categoryDTOS.add(categoryDTO);
//            }
//            categoriesDTO.setCategories(categoryDTOS);
//        } catch (FoodItemException e) {
//            e.printStackTrace();
//        }

        FoodItemDAOImpl foodItemDAO = new FoodItemDAOImpl();
        CategoriesDTO categoriesDTO = new CategoriesDTO();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        CategoryDTO categoryDTO = new CategoryDTO();

        List<FoodItem> foodItemList;
        try {
            foodItemList = foodItemDAO.getItemsByCategory("Breakfast");
            List<FoodDetailsDTO> breakfastItems = new ArrayList<>();
            for (FoodItem foodItem : foodItemList) {
                breakfastItems.add(setFoodDetailsDTO(foodItem));
            }
            categoryDTO.setBreakfast(breakfastItems);

            foodItemList = foodItemDAO.getItemsByCategory("Hot Drinks");
            List<FoodDetailsDTO> hotDrinks = new ArrayList<>();
            for (FoodItem foodItem : foodItemList) {
                hotDrinks.add(setFoodDetailsDTO(foodItem));
            }
            categoryDTO.setHotDrinks(hotDrinks);

            foodItemList = foodItemDAO.getItemsByCategory("Desserts");
            List<FoodDetailsDTO> desserts = new ArrayList<>();
            for (FoodItem foodItem : foodItemList) {
                desserts.add(setFoodDetailsDTO(foodItem));
            }
            categoryDTO.setDesserts(desserts);

            foodItemList = foodItemDAO.getItemsByCategory("French Toast");
            List<FoodDetailsDTO> frenchToasts = new ArrayList<>();
            for (FoodItem foodItem : foodItemList) {
                frenchToasts.add(setFoodDetailsDTO(foodItem));
            }
            categoryDTO.setFrenchToast(frenchToasts);

            foodItemList = foodItemDAO.getItemsByCategory("Main Course");
            List<FoodDetailsDTO> mainCourse = new ArrayList<>();
            for (FoodItem foodItem : foodItemList) {
                mainCourse.add(setFoodDetailsDTO(foodItem));
            }
            categoryDTO.setMainCource(mainCourse);

            foodItemList = foodItemDAO.getItemsByCategory("Pancakes");
            List<FoodDetailsDTO> pancakes = new ArrayList<>();
            for (FoodItem foodItem : foodItemList) {
                pancakes.add(setFoodDetailsDTO(foodItem));
            }
            categoryDTO.setPancake(pancakes);

            foodItemList = foodItemDAO.getItemsByCategory("Pasta");
            List<FoodDetailsDTO> pastas = new ArrayList<>();
            for (FoodItem foodItem : foodItemList) {
                pastas.add(setFoodDetailsDTO(foodItem));
            }
            categoryDTO.setPastas(pastas);

            foodItemList = foodItemDAO.getItemsByCategory("Quenchers");
            List<FoodDetailsDTO> quenchers = new ArrayList<>();
            for (FoodItem foodItem : foodItemList) {
                quenchers.add(setFoodDetailsDTO(foodItem));
            }
            categoryDTO.setQuenchers(quenchers);

            foodItemList = foodItemDAO.getItemsByCategory("Salads");
            List<FoodDetailsDTO> salads = new ArrayList<>();
            for (FoodItem foodItem : foodItemList) {
                salads.add(setFoodDetailsDTO(foodItem));
            }
            categoryDTO.setSalad(salads);

            foodItemList = foodItemDAO.getItemsByCategory("Starters");
            List<FoodDetailsDTO> starters = new ArrayList<>();
            for (FoodItem foodItem : foodItemList) {
                starters.add(setFoodDetailsDTO(foodItem));
            }
            categoryDTO.setStarters(starters);

            foodItemList = foodItemDAO.getItemsByCategory("Waffles");
            List<FoodDetailsDTO> waffles = new ArrayList<>();
            for (FoodItem foodItem : foodItemList) {
                waffles.add(setFoodDetailsDTO(foodItem));
            }
            categoryDTO.setWaffles(waffles);

            categoryDTOList.add(categoryDTO);
            categoriesDTO.setCategories(categoryDTOList);
        } catch (FoodItemException e) {
            e.printStackTrace();
        }

        return Response.ok().entity(categoriesDTO).build();
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
        } catch (FoodItemException e) {
            e.printStackTrace();
        }
        return Response.ok().entity(foodDetailsDTO).header("Access-Control-Allow-Origin", "*").build();
    }

    @Override
    public Response setFoodItem(FoodDetailsDTO body) {
        FoodItem foodItem = new FoodItem();
        FoodItem addedFoodItem = null;
        foodItem.setCategory(body.getCategory());
        foodItem.setName(body.getTitle());
        foodItem.setDescription(body.getDescription());
        foodItem.setPrice(body.getPrice());
        FoodItemDAOImpl foodItemDAO = new FoodItemDAOImpl();
        try {
            addedFoodItem = foodItemDAO.addItem(foodItem);
        } catch (FoodItemException e) {
            e.printStackTrace();
        }
        FoodDetailsDTO foodDetailsDTO = new FoodDetailsDTO();
        foodDetailsDTO.setTitle(addedFoodItem.getName());
        foodDetailsDTO.setDescription(addedFoodItem.getDescription());
        return Response.ok().entity(foodDetailsDTO).build();
    }

    @Override
    public Response updateFoodItem(Integer id, FoodDetailsDTO body) {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}

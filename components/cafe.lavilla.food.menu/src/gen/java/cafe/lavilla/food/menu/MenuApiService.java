package cafe.lavilla.food.menu;

import cafe.lavilla.food.menu.*;
import cafe.lavilla.food.menu.dto.*;

import cafe.lavilla.food.menu.dto.FoodDetailsDTO;
import cafe.lavilla.food.menu.dto.CategoriesDTO;
import cafe.lavilla.food.menu.dto.ErrorDTO;

import java.util.List;

import java.io.InputStream;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import javax.ws.rs.core.Response;

public abstract class MenuApiService {
    public abstract Response deleteBreakfast(Integer breakfastId);
    public abstract Response deleteCoffeeAndTea(Integer coffeeAndTeaId);
    public abstract Response deleteDessert(Integer dessertId);
    public abstract Response deleteFrenchToast(Integer frenchToastId);
    public abstract Response deleteMainCourse(Integer mainCourseId);
    public abstract Response deletePancake(Integer pancakeId);
    public abstract Response deletePasta(Integer pastaId);
    public abstract Response deleteQuencher(Integer quencherId);
    public abstract Response deleteSalad(Integer saladId);
    public abstract Response deleteStarter(Integer starterId);
    public abstract Response deleteWaffle(Integer waffleId);
    public abstract Response getBreakfast(Integer breakfastId);
    public abstract Response getCategories();
    public abstract Response getCoffeeAndTea(Integer coffeeAndTeaId);
    public abstract Response getDesserts(Integer dessertId);
    public abstract Response getFrenchToast(Integer frenchToastId);
    public abstract Response getMainCourse(Integer mainCourseId);
    public abstract Response getPancake(Integer pancakeId);
    public abstract Response getPasta(Integer pastaId);
    public abstract Response getQuencher(Integer quencherId);
    public abstract Response getSalad(Integer saladId);
    public abstract Response getStarters(Integer starterId);
    public abstract Response getWaffle(Integer waffleId);
    public abstract Response setBreakfast(FoodDetailsDTO body);
    public abstract Response setCoffeeAndTea(FoodDetailsDTO body);
    public abstract Response setDesserts(FoodDetailsDTO body);
    public abstract Response setFrenchToast(FoodDetailsDTO body);
    public abstract Response setMainCourse(FoodDetailsDTO body);
    public abstract Response setPancake(FoodDetailsDTO body);
    public abstract Response setPasta(FoodDetailsDTO body);
    public abstract Response setQuencher(FoodDetailsDTO body);
    public abstract Response setSalad(FoodDetailsDTO body);
    public abstract Response setStarter(FoodDetailsDTO body);
    public abstract Response setWaffle(FoodDetailsDTO body);
    public abstract Response updateBreakfast(Integer breakfastId,FoodDetailsDTO body);
    public abstract Response updateCoffeeAndTea(Integer coffeeAndTeaId,FoodDetailsDTO body);
    public abstract Response updateDessert(Integer dessertId,FoodDetailsDTO body);
    public abstract Response updateFrenchToast(Integer frenchToastId,FoodDetailsDTO body);
    public abstract Response updateMainCourse(Integer mainCourseId,FoodDetailsDTO body);
    public abstract Response updatePancake(Integer pancakeId,FoodDetailsDTO body);
    public abstract Response updatePasta(Integer pastaId,FoodDetailsDTO body);
    public abstract Response updateQuencher(Integer quencherId,FoodDetailsDTO body);
    public abstract Response updateSalad(Integer saladId,FoodDetailsDTO body);
    public abstract Response updateStarter(Integer starterId,FoodDetailsDTO body);
    public abstract Response updateWaffle(Integer waffleId,FoodDetailsDTO body);
}


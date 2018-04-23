package cafe.lavilla.food.menu;

import cafe.lavilla.food.menu.dto.*;
import cafe.lavilla.food.menu.MenuApiService;
import cafe.lavilla.food.menu.factories.MenuApiServiceFactory;

import io.swagger.annotations.ApiParam;

import cafe.lavilla.food.menu.dto.FoodDetailsDTO;
import cafe.lavilla.food.menu.dto.CategoriesDTO;
import cafe.lavilla.food.menu.dto.ErrorDTO;

import java.util.List;

import java.io.InputStream;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/menu")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(value = "/menu", description = "the menu API")
public class MenuApi  {

   private final MenuApiService delegate = MenuApiServiceFactory.getMenuApi();

    @DELETE
    @Path("/breakfasts/{breakfast-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Deletes the given breakfast", notes = "This API is used to delete a given breakfast\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "breakfast deleted successfully"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "breakfast id not found"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "breakfast not found") })

    public Response deleteBreakfast(@ApiParam(value = "breakfast to be deleted",required=true ) @PathParam("breakfast-id")  Integer breakfastId)
    {
    return delegate.deleteBreakfast(breakfastId);
    }
    @DELETE
    @Path("/cofee-and-tea/{coffee-and-tea-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Deletes the given coffee and tea", notes = "This API is used to delete a given coffee and tea\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "coffee and tea deleted successfully"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "coffee and tea id not found"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "coffee and tea not found") })

    public Response deleteCoffeeAndTea(@ApiParam(value = "coffee and tea to be deleted",required=true ) @PathParam("coffee-and-tea-id")  Integer coffeeAndTeaId)
    {
    return delegate.deleteCoffeeAndTea(coffeeAndTeaId);
    }
    @DELETE
    @Path("/desserts/{dessert-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Deletes the given dessert", notes = "This API is used to delete a given dessert\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "dessert deleted successfully"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "dessert id not found"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "dessert not found") })

    public Response deleteDessert(@ApiParam(value = "dessert to be deleted",required=true ) @PathParam("dessert-id")  Integer dessertId)
    {
    return delegate.deleteDessert(dessertId);
    }
    @DELETE
    @Path("/french-toasts/{french-toast-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Deletes the given french toast", notes = "This API is used to delete a given french toast\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "french toast deleted successfully"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "french toast id not found"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "french toast not found") })

    public Response deleteFrenchToast(@ApiParam(value = "french toast to be deleted",required=true ) @PathParam("french-toast-id")  Integer frenchToastId)
    {
    return delegate.deleteFrenchToast(frenchToastId);
    }
    @DELETE
    @Path("/main-course/{main-course-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Deletes the given main course", notes = "This API is used to delete a given main course\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "main course deleted successfully"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "main course id not found"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "main course not found") })

    public Response deleteMainCourse(@ApiParam(value = "main course to be deleted",required=true ) @PathParam("main-course-id")  Integer mainCourseId)
    {
    return delegate.deleteMainCourse(mainCourseId);
    }
    @DELETE
    @Path("/pancakes/{pancake-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Deletes the given pancake", notes = "This API is used to delete a given pancake\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "pancake deleted successfully"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "pancake id not found"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "pancake not found") })

    public Response deletePancake(@ApiParam(value = "pancake to be deleted",required=true ) @PathParam("pancake-id")  Integer pancakeId)
    {
    return delegate.deletePancake(pancakeId);
    }
    @DELETE
    @Path("/pastas/{pasta-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Deletes the given pasta", notes = "This API is used to delete a given pasta\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "pasta deleted successfully"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "pasta id not found"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "pasta not found") })

    public Response deletePasta(@ApiParam(value = "pasta to be deleted",required=true ) @PathParam("pasta-id")  Integer pastaId)
    {
    return delegate.deletePasta(pastaId);
    }
    @DELETE
    @Path("/quenchers/{quencher-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Deletes the given quencher", notes = "This API is used to delete a given quencher\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "quencher deleted successfully"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "quencher id not found"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "quencher not found") })

    public Response deleteQuencher(@ApiParam(value = "quencher to be deleted",required=true ) @PathParam("quencher-id")  Integer quencherId)
    {
    return delegate.deleteQuencher(quencherId);
    }
    @DELETE
    @Path("/salads/{salad-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Deletes the given salad", notes = "This API is used to delete a given salad\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Salad deleted successfully"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Salad id not found"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Salad not found") })

    public Response deleteSalad(@ApiParam(value = "Salad to be deleted",required=true ) @PathParam("salad-id")  Integer saladId)
    {
    return delegate.deleteSalad(saladId);
    }
    @DELETE
    @Path("/starters/{starter-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Deletes the given starter", notes = "This API is used to delete a given starter\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "starter deleted successfully"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "starter id not found"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "starter not found") })

    public Response deleteStarter(@ApiParam(value = "starter to be deleted",required=true ) @PathParam("starter-id")  Integer starterId)
    {
    return delegate.deleteStarter(starterId);
    }
    @DELETE
    @Path("/waffles/{waffle-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Deletes the given waffle", notes = "This API is used to delete a given waffle\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "waffle deleted successfully"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "waffle id not found"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "waffle not found") })

    public Response deleteWaffle(@ApiParam(value = "waffle to be deleted",required=true ) @PathParam("waffle-id")  Integer waffleId)
    {
    return delegate.deleteWaffle(waffleId);
    }
    @GET
    @Path("/breakfasts/{breakfast-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get the given breakfast", notes = "This API is used to get a given breakfast\n", response = FoodDetailsDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successfully obtained the given breakfast"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid breakfast-id supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Supplied breakfast not found") })

    public Response getBreakfast(@ApiParam(value = "breakfast to get",required=true ) @PathParam("breakfast-id")  Integer breakfastId)
    {
    return delegate.getBreakfast(breakfastId);
    }
    @GET
    @Path("/categories")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Gets all food categories", notes = "This API is used to get all food categories\n", response = CategoriesDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request") })

    public Response getCategories()
    {
    return delegate.getCategories();
    }
    @GET
    @Path("/cofee-and-tea/{coffee-and-tea-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get the given coffee and tea", notes = "This API is used to get a given coffee and tea\n", response = FoodDetailsDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successfully obtained the given coffee and tea"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid coffee-and-tea-id supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Supplied coffee and tea not found") })

    public Response getCoffeeAndTea(@ApiParam(value = "coffee and tea to get",required=true ) @PathParam("coffee-and-tea-id")  Integer coffeeAndTeaId)
    {
    return delegate.getCoffeeAndTea(coffeeAndTeaId);
    }
    @GET
    @Path("/desserts/{dessert-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get the given dessert", notes = "This API is used to get a given dessert\n", response = FoodDetailsDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successfully obtained the given dessert"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid dessert-id supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Supplied dessert not found") })

    public Response getDesserts(@ApiParam(value = "dessert to get",required=true ) @PathParam("dessert-id")  Integer dessertId)
    {
    return delegate.getDesserts(dessertId);
    }
    @GET
    @Path("/french-toasts/{french-toast-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get the given french toast", notes = "This API is used to get a given french-toast\n", response = FoodDetailsDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successfully obtained the given french toast"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid french-toast-id supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Supplied french toast not found") })

    public Response getFrenchToast(@ApiParam(value = "french toast to get",required=true ) @PathParam("french-toast-id")  Integer frenchToastId)
    {
    return delegate.getFrenchToast(frenchToastId);
    }
    @GET
    @Path("/main-course/{main-course-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get the given main course", notes = "This API is used to get a given main course\n", response = FoodDetailsDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successfully obtained the given main course"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid main-course-id supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Supplied main course not found") })

    public Response getMainCourse(@ApiParam(value = "main course to get",required=true ) @PathParam("main-course-id")  Integer mainCourseId)
    {
    return delegate.getMainCourse(mainCourseId);
    }
    @GET
    @Path("/pancakes/{pancake-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get the given pancake", notes = "This API is used to get a given pancake\n", response = FoodDetailsDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successfully obtained the given pancake"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid pancake-id supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Supplied pancake not found") })

    public Response getPancake(@ApiParam(value = "pancake to get",required=true ) @PathParam("pancake-id")  Integer pancakeId)
    {
    return delegate.getPancake(pancakeId);
    }
    @GET
    @Path("/pastas/{pasta-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get the given pasta", notes = "This API is used to get a given pasta\n", response = FoodDetailsDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successfully obtained the given pasta"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid pasta-id supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Supplied pasta not found") })

    public Response getPasta(@ApiParam(value = "pasta to get",required=true ) @PathParam("pasta-id")  Integer pastaId)
    {
    return delegate.getPasta(pastaId);
    }
    @GET
    @Path("/quenchers/{quencher-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get the given quencher", notes = "This API is used to get a given quencher\n", response = FoodDetailsDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successfully obtained the given quencher"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid quencher-id supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Supplied quencher not found") })

    public Response getQuencher(@ApiParam(value = "quencher to get",required=true ) @PathParam("quencher-id")  Integer quencherId)
    {
    return delegate.getQuencher(quencherId);
    }
    @GET
    @Path("/salads/{salad-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get the given salad", notes = "This API is used to get a given salad\n", response = FoodDetailsDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successfully obtained the given salad"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid salad-id supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Supplied salad not found") })

    public Response getSalad(@ApiParam(value = "Salad to get",required=true ) @PathParam("salad-id")  Integer saladId)
    {
    return delegate.getSalad(saladId);
    }
    @GET
    @Path("/starters/{starter-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get the given starter", notes = "This API is used to get a given starter\n", response = FoodDetailsDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successfully obtained the given starter"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid starter-id supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Supplied starter not found") })

    public Response getStarters(@ApiParam(value = "starter to get",required=true ) @PathParam("starter-id")  Integer starterId)
    {
    return delegate.getStarters(starterId);
    }
    @GET
    @Path("/waffles/{waffle-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get the given waffle", notes = "This API is used to get a given waffle\n", response = FoodDetailsDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successfully obtained the given waffle"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid waffle-id supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Supplied waffle not found") })

    public Response getWaffle(@ApiParam(value = "waffle to get",required=true ) @PathParam("waffle-id")  Integer waffleId)
    {
    return delegate.getWaffle(waffleId);
    }
    @POST
    @Path("/breakfast")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Adds breakfast", notes = "This API is used to add a breakfast.\n", response = FoodDetailsDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request") })

    public Response setBreakfast(@ApiParam(value = "Adding breakfast"  ) FoodDetailsDTO body)
    {
    return delegate.setBreakfast(body);
    }
    @POST
    @Path("/coffee-and-tea")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Adds coffee and tea", notes = "This API is used to add a coffee and tea.\n", response = FoodDetailsDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request") })

    public Response setCoffeeAndTea(@ApiParam(value = "Adding coffee and tea"  ) FoodDetailsDTO body)
    {
    return delegate.setCoffeeAndTea(body);
    }
    @POST
    @Path("/dessert")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Adds desserts", notes = "This API is used to add a desserts.\n", response = FoodDetailsDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request") })

    public Response setDesserts(@ApiParam(value = "Adding desserts"  ) FoodDetailsDTO body)
    {
    return delegate.setDesserts(body);
    }
    @POST
    @Path("/french-toast")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Adds french toasts", notes = "This API is used to add a french toasts.\n", response = FoodDetailsDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request") })

    public Response setFrenchToast(@ApiParam(value = "Adding french toasts"  ) FoodDetailsDTO body)
    {
    return delegate.setFrenchToast(body);
    }
    @POST
    @Path("/main-course")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Adds main courses", notes = "This API is used to add a main course.\n", response = FoodDetailsDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request") })

    public Response setMainCourse(@ApiParam(value = "Adding main courses"  ) FoodDetailsDTO body)
    {
    return delegate.setMainCourse(body);
    }
    @POST
    @Path("/pancakes")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Adds pancakes", notes = "This API is used to add a pancake.\n", response = FoodDetailsDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request") })

    public Response setPancake(@ApiParam(value = "Adding pancake"  ) FoodDetailsDTO body)
    {
    return delegate.setPancake(body);
    }
    @POST
    @Path("/pastas")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Adds pastas", notes = "This API is used to add a pasta.\n", response = FoodDetailsDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request") })

    public Response setPasta(@ApiParam(value = "Adding pasta"  ) FoodDetailsDTO body)
    {
    return delegate.setPasta(body);
    }
    @POST
    @Path("/quenchers")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Adds quenchers", notes = "This API is used to add a quencher.\n", response = FoodDetailsDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request") })

    public Response setQuencher(@ApiParam(value = "Adding quencher"  ) FoodDetailsDTO body)
    {
    return delegate.setQuencher(body);
    }
    @POST
    @Path("/salad")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Adds salad", notes = "This API is used to add a salad.\n", response = FoodDetailsDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request") })

    public Response setSalad(@ApiParam(value = "Adding salad"  ) FoodDetailsDTO body)
    {
    return delegate.setSalad(body);
    }
    @POST
    @Path("/starters")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Adds starters", notes = "This API is used to add a starter.\n", response = FoodDetailsDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request") })

    public Response setStarter(@ApiParam(value = "Adding starter"  ) FoodDetailsDTO body)
    {
    return delegate.setStarter(body);
    }
    @POST
    @Path("/waffles")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Adds waffles", notes = "This API is used to add a waffle.\n", response = FoodDetailsDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request") })

    public Response setWaffle(@ApiParam(value = "Adding waffle"  ) FoodDetailsDTO body)
    {
    return delegate.setWaffle(body);
    }
    @PUT
    @Path("/breakfasts/{breakfast-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Updates the given breakfast.", notes = "This API is used to update a given breakfast\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Updated breakfast successfully"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid breakfast supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "breakfast not found") })

    public Response updateBreakfast(@ApiParam(value = "breakfast to be updated.",required=true ) @PathParam("breakfast-id")  Integer breakfastId,
    @ApiParam(value = "Update given breakfast." ,required=true ) FoodDetailsDTO body)
    {
    return delegate.updateBreakfast(breakfastId,body);
    }
    @PUT
    @Path("/cofee-and-tea/{coffee-and-tea-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Updates the given coffee and tea.", notes = "This API is used to update a given coffee and tea\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Updated coffee and tea successfully"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid coffee and tea supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "coffee and tea not found") })

    public Response updateCoffeeAndTea(@ApiParam(value = "Coffee and tea to be updated.",required=true ) @PathParam("coffee-and-tea-id")  Integer coffeeAndTeaId,
    @ApiParam(value = "Update given coffee and tea." ,required=true ) FoodDetailsDTO body)
    {
    return delegate.updateCoffeeAndTea(coffeeAndTeaId,body);
    }
    @PUT
    @Path("/desserts/{dessert-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Updates the given dessert.", notes = "This API is used to update a given dessert\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Updated dessert successfully"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid dessert supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Dessert not found") })

    public Response updateDessert(@ApiParam(value = "dessert to be updated.",required=true ) @PathParam("dessert-id")  Integer dessertId,
    @ApiParam(value = "Update given dessert." ,required=true ) FoodDetailsDTO body)
    {
    return delegate.updateDessert(dessertId,body);
    }
    @PUT
    @Path("/french-toasts/{french-toast-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Updates the given french toast.", notes = "This API is used to update a given french toast\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Updated french toast successfully"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid french toast supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "french toast not found") })

    public Response updateFrenchToast(@ApiParam(value = "french toast to be updated.",required=true ) @PathParam("french-toast-id")  Integer frenchToastId,
    @ApiParam(value = "Update given french toast." ,required=true ) FoodDetailsDTO body)
    {
    return delegate.updateFrenchToast(frenchToastId,body);
    }
    @PUT
    @Path("/main-course/{main-course-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Updates the given main course.", notes = "This API is used to update a given main course\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Updated main course successfully"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid main course supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "main course not found") })

    public Response updateMainCourse(@ApiParam(value = "main course to be updated.",required=true ) @PathParam("main-course-id")  Integer mainCourseId,
    @ApiParam(value = "Update given main course." ,required=true ) FoodDetailsDTO body)
    {
    return delegate.updateMainCourse(mainCourseId,body);
    }
    @PUT
    @Path("/pancakes/{pancake-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Updates the given pancake.", notes = "This API is used to update a given pancake\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Updated pancake successfully"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid pancake supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "pancake not found") })

    public Response updatePancake(@ApiParam(value = "pancake to be updated.",required=true ) @PathParam("pancake-id")  Integer pancakeId,
    @ApiParam(value = "Update given pancake." ,required=true ) FoodDetailsDTO body)
    {
    return delegate.updatePancake(pancakeId,body);
    }
    @PUT
    @Path("/pastas/{pasta-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Updates the given pasta.", notes = "This API is used to update a given pasta\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Updated pasta successfully"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid pasta supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "pasta not found") })

    public Response updatePasta(@ApiParam(value = "pasta to be updated.",required=true ) @PathParam("pasta-id")  Integer pastaId,
    @ApiParam(value = "Update given pasta." ,required=true ) FoodDetailsDTO body)
    {
    return delegate.updatePasta(pastaId,body);
    }
    @PUT
    @Path("/quenchers/{quencher-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Updates the given quencher.", notes = "This API is used to update a given quencher\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Updated quencher successfully"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid quencher supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "quencher not found") })

    public Response updateQuencher(@ApiParam(value = "quencher to be updated.",required=true ) @PathParam("quencher-id")  Integer quencherId,
    @ApiParam(value = "Update given quencher." ,required=true ) FoodDetailsDTO body)
    {
    return delegate.updateQuencher(quencherId,body);
    }
    @PUT
    @Path("/salads/{salad-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Updates the given salad.", notes = "This API is used to update a given salad\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Updated salad successfully"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid Salad supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Salad not found") })

    public Response updateSalad(@ApiParam(value = "Salad to be updated.",required=true ) @PathParam("salad-id")  Integer saladId,
    @ApiParam(value = "Update given Salad." ,required=true ) FoodDetailsDTO body)
    {
    return delegate.updateSalad(saladId,body);
    }
    @PUT
    @Path("/starters/{starter-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Updates the given starter.", notes = "This API is used to update a given starter\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Updated starter successfully"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid starter supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "starter not found") })

    public Response updateStarter(@ApiParam(value = "starter to be updated.",required=true ) @PathParam("starter-id")  Integer starterId,
    @ApiParam(value = "Update given starter." ,required=true ) FoodDetailsDTO body)
    {
    return delegate.updateStarter(starterId,body);
    }
    @PUT
    @Path("/waffles/{waffle-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Updates the given waffle.", notes = "This API is used to update a given waffle\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Updated waffle successfully"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid waffle supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "waffle not found") })

    public Response updateWaffle(@ApiParam(value = "waffle to be updated.",required=true ) @PathParam("waffle-id")  Integer waffleId,
    @ApiParam(value = "Update given waffle." ,required=true ) FoodDetailsDTO body)
    {
    return delegate.updateWaffle(waffleId,body);
    }
}


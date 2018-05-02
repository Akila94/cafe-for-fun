package cafe.lavilla.items.menu;

import cafe.lavilla.items.menu.dto.*;
import cafe.lavilla.items.menu.MenuApiService;
import cafe.lavilla.items.menu.factories.MenuApiServiceFactory;

import io.swagger.annotations.ApiParam;

import cafe.lavilla.items.menu.dto.CategoriesDTO;
import cafe.lavilla.items.menu.dto.ErrorDTO;
import cafe.lavilla.items.menu.dto.GroupDTO;
import cafe.lavilla.items.menu.dto.FoodDetailsDTO;

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
    @Path("/{category}/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Deletes the given food item of the given category", notes = "This API is used to delete a given food item of given category\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Food item deleted successfully"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Food item not found") })

    public Response deleteFoodItem(@ApiParam(value = "Category of the food item",required=true ) @PathParam("category")  String category,
    @ApiParam(value = "Id of the food item to be deleted",required=true ) @PathParam("id")  Integer id)
    {
    return delegate.deleteFoodItem(category,id);
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
    @Path("/{category}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Gets all the foods of the provided category", notes = "This API is used to get all the food items of the given category\n", response = GroupDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successfully obtained food item of given category"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Provided category not found") })

    public Response getCategory(@ApiParam(value = "Food category that is needed",required=true ) @PathParam("category")  String category)
    {
    return delegate.getCategory(category);
    }
    @GET
    @Path("/{category}/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get the food item of a given id and a category", notes = "This API is used to get a food item for the given id and category\n", response = FoodDetailsDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successfully obtained the given food item"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid food id supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Supplied food item not found") })

    public Response getFoodItem(@ApiParam(value = "Category of the food",required=true ) @PathParam("category")  String category,
    @ApiParam(value = "Id of the food item to get",required=true ) @PathParam("id")  Integer id)
    {
    return delegate.getFoodItem(category,id);
    }
    @POST
    @Path("/category")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Adds a food item of a given category", notes = "This API is used to add a food item of a given category\n", response = FoodDetailsDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request") })

    public Response setFoodItem(@ApiParam(value = "Adding food item"  ) FoodDetailsDTO body)
    {
    return delegate.setFoodItem(body);
    }
    @PUT
    @Path("/category")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Updates the food item of a given id and a category.", notes = "This API is used to update a given food item of a given category\n", response = void.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Updated food item successfully"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid food item supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Food item not found") })

    public Response updateFoodItem(@ApiParam(value = "Details of the food item to be updated." ,required=true ) FoodDetailsDTO body)
    {
    return delegate.updateFoodItem(body);
    }
}


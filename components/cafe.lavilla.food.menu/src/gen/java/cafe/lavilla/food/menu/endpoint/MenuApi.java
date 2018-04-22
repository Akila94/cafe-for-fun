package cafe.lavilla.food.menu.endpoint;

import cafe.lavilla.food.menu.endpoint.dto.*;
import cafe.lavilla.food.menu.endpoint.MenuApiService;
import cafe.lavilla.food.menu.endpoint.factories.MenuApiServiceFactory;

import io.swagger.annotations.ApiParam;

import cafe.lavilla.food.menu.endpoint.dto.SaladDTO;
import cafe.lavilla.food.menu.endpoint.dto.ErrorDTO;

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
    @GET
    @Path("/salads/{salad-id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get the given salad", notes = "This API is used to get a given salad\n", response = SaladDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successfully obtained the given salad"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid salad-id supplied"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Supplied salad not found") })

    public Response getSalad(@ApiParam(value = "Salad to get",required=true ) @PathParam("salad-id")  Integer saladId)
    {
    return delegate.getSalad(saladId);
    }
    @POST
    @Path("/salad")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Adds salad", notes = "This API is used to add a salad.\n", response = SaladDTO.class)
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK"),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Bad Request") })

    public Response setSalad(@ApiParam(value = "Adding salad"  ) SaladDTO salad)
    {
    return delegate.setSalad(salad);
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
    @ApiParam(value = "Update given Salad." ,required=true ) SaladDTO body)
    {
    return delegate.updateSalad(saladId,body);
    }
}


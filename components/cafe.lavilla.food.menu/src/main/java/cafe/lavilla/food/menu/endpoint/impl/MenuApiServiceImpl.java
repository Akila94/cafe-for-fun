package cafe.lavilla.food.menu.endpoint.impl;

import cafe.lavilla.food.menu.core.dao.impl.SaladsDAOImpl;
import cafe.lavilla.food.menu.core.exception.FoodItemException;
import cafe.lavilla.food.menu.core.model.FoodItem;
import cafe.lavilla.food.menu.endpoint.ApiResponseMessage;
import cafe.lavilla.food.menu.endpoint.MenuApiService;
import cafe.lavilla.food.menu.endpoint.dto.SaladDTO;

import javax.ws.rs.core.Response;

public class MenuApiServiceImpl extends MenuApiService {
    @Override
    public Response deleteSalad(Integer saladId) {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response getSalad(Integer saladId) {
        // do some magic!
        SaladsDAOImpl saladsDAO = new SaladsDAOImpl();
        SaladDTO saladDTO = new SaladDTO();
        try {
            FoodItem saladItem = saladsDAO.getSaladItem(1);
            saladDTO.setId(saladItem.getId());
            saladDTO.setName(saladItem.getName());
        } catch (FoodItemException e) {
            e.printStackTrace();
        }
        return Response.ok().entity(saladDTO).build();
    }

    @Override
    public Response setSalad(SaladDTO salad) {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response updateSalad(Integer saladId, SaladDTO body) {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}

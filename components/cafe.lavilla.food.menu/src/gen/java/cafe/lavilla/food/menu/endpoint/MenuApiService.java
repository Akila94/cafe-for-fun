package cafe.lavilla.food.menu.endpoint;

import cafe.lavilla.food.menu.endpoint.*;
import cafe.lavilla.food.menu.endpoint.dto.*;

import cafe.lavilla.food.menu.endpoint.dto.SaladDTO;
import cafe.lavilla.food.menu.endpoint.dto.ErrorDTO;

import java.util.List;

import java.io.InputStream;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import javax.ws.rs.core.Response;

public abstract class MenuApiService {
    public abstract Response deleteSalad(Integer saladId);
    public abstract Response getSalad(Integer saladId);
    public abstract Response setSalad(SaladDTO salad);
    public abstract Response updateSalad(Integer saladId,SaladDTO body);
}


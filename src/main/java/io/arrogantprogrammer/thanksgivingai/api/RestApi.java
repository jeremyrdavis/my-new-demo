package io.arrogantprogrammer.thanksgivingai.api;

import io.arrogantprogrammer.thanksgivingai.MenuService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/thanksgivingai")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RestApi {

    @Inject
    MenuService menuService;

    @POST
    @Path("/menu")
    public ThanksgivingMenu createMenu(CreateMenuCommand createMenuCommand) {
        ThanksgivingMenu thanksgivingMenu = menuService.createMenu(createMenuCommand);
        return thanksgivingMenu;
    }
}

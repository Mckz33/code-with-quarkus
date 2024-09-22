package org.acme.controllers;
import org.acme.models.User;
import org.acme.services.UserService;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @POST
    @Transactional
    public Response createUser( User user ) {
        return Response.ok(userService.createUser(user)).build();
    }

    @GET
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page, 
                            @QueryParam("pageSize") @DefaultValue("10") Integer pageSize) {
        var users = userService.findAll(page, pageSize);
        return Response.ok(users).build();

    }
    
}

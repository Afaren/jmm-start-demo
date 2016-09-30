package com.tw.rs.resource;

import io.swagger.annotations.Api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by afaren on 9/29/16.
 */
@Path("/users")

public class Demo {
    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(
            @PathParam("param") int userId) {

        Map<String, Object> map = new HashMap<>();
        map.put("id", userId);

        return Response.status(Response.Status.OK).entity(map).build();
    }
}

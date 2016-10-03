package com.tw.rs.resource;

import com.tw.rs.bean.User;
import com.tw.rs.util.ReadUserData;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

        User user = new ReadUserData().getUserById(userId);

        if (null != user) {
            return Response.status(Response.Status.OK).entity(user).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {

        List<User> users = new ReadUserData().getAllUsers();

        if (0 != users.size()) {
            return Response.status(Response.Status.OK).entity(users).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }


}

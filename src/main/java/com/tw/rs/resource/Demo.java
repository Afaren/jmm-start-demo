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

        User user = getUserFromDB(userId);

        if (null != user) {
            return Response.status(Response.Status.OK).entity(user).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    private User getUserFromDB(int userId) {
        ReadUserData data = new ReadUserData();
        User user = null;
        try {
            user = data.getUserById(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }
}

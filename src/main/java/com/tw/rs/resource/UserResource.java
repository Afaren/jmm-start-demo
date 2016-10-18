package com.tw.rs.resource;

import com.tw.rs.bean.User;
import com.tw.rs.mapper.UserMapper;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by afaren on 9/29/16.
 */
@Path("/users")

public class UserResource {

    @Inject
    private UserMapper userMapper;

    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(
            @PathParam("param") int userId) {

        User user = userMapper.getUserById(userId);

        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("id", user.getId());
        map.put("name", user.getName());
        map.put("gender", user.getGender());

        return Response.status(Response.Status.OK).entity(map).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {

        List<User> users = userMapper.getAllUsers();

        if (null == users) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }


        List<Map> result = users
                .stream()
                .map(user -> {

                    Map<String, Object> map = new HashMap<>();
                    map.put("id", user.getId());
                    map.put("name", user.getName());
                    map.put("gender", user.getGender());

                    return map;
                })
                .collect(Collectors.toList());

        return Response.status(Response.Status.OK).entity(result).build();
    }

}

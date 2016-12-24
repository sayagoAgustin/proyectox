package com.proyectox.client;


import com.proyectox.model.Users;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/login")
public interface ServicesInterface {

    @GET
    @Path("/dologin")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    String doLogin(@QueryParam("username") String uname, @QueryParam("password") String pwd);

}

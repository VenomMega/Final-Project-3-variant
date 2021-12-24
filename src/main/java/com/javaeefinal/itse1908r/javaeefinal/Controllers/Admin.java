package com.javaeefinal.itse1908r.javaeefinal.Controllers;

import com.javaeefinal.itse1908r.javaeefinal.Models.ERole;
import com.javaeefinal.itse1908r.javaeefinal.Models.User;
import com.javaeefinal.itse1908r.javaeefinal.JMS.Message;
import com.javaeefinal.itse1908r.javaeefinal.Services.BuildingService;
import com.javaeefinal.itse1908r.javaeefinal.Services.UserService;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.List;


@Path("/admin")
@RolesAllowed({"ADMIN"})
public class Admin implements ExceptionMapper {
    @EJB
    BuildingService buildingService;

    @EJB
    UserService userService;

    @EJB
    private Message message;

    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    @Context
    HttpHeaders httpHeaders;


    @DELETE
    @Path("/deleteBuilding/{Id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBuilding(
            @DefaultValue("0")
            @PathParam("Id") int Id){
        String build = buildingService.getBuildingById(Id).getName();
        buildingService.deleteBuildingById(Id);
        return Response.ok().entity("Building " + build + " was removed").build();
    }

    @DELETE
    @Path("/deleteUser/{Id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(
            @DefaultValue("0")
            @PathParam("Id") int id){
        String userLogin = userService.getUserById((long) id).getLogin();
        userService.deleteUserById(id);
        return Response.ok().entity("User " + userLogin + " was removed").build();
    }

    @POST
    @Path("/sendMessage")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response sendMessage(String text) throws JMSException {

        message.sendMessage(text);
        return  Response.ok()
                .entity("Message " + text + " was sent to all user")
                .build();
    }

    @GET
    @Path("/receiveAllMessage")
    @Produces("application/json")
    public Response getAllMessage() throws JMSException {
        List<String> receiveAllMessage = message.receiveAll();
        return  Response.ok()
                .entity("Message " + receiveAllMessage + " from admin")
                .build();
    }

    @PUT
    @Path("/updatePassowrd/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateUserPassword(@DefaultValue("0")
                                           @PathParam("id") int id, String newPassword){
        User user = userService.getUserById((long) id);
        if (user.getRole().getName() == ERole.Admin){
            return Response.serverError().entity("You can not change admin's role").build();
        } else {
            userService.updatePasswordById(id, newPassword);
            return Response.ok().entity("Password has been changed").build();
        }
    }


    @PUT
    @Path("/updatePasswordByLogin/{login}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateUserPasswordByLogin(@PathParam("login") String login, String newPassword){
        User user = userService.getUserByLogin(login);
//        boolean test = user.getRole().getName().equals("Admin");
        if (user.getRole().getName() == ERole.Admin){
            return Response.serverError().entity("You can not change admin's role").build();
        } else {
            userService.updatePasswordByLogin(login,newPassword);
            return Response.ok().entity("Password has been changed").build();
        }

    }



    @Override
    public Response toResponse(Throwable throwable) {
        return Response.status(500)
                .entity("ATTENTION! ERROR HANDLER IS FOUND A NEW ERROR")
                .build();
    }


}

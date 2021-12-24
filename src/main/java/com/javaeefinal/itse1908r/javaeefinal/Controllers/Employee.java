package com.javaeefinal.itse1908r.javaeefinal.Controllers;

import com.javaeefinal.itse1908r.javaeefinal.Services.BuildingService;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.ExceptionMapper;


@Path("/moder")
@RolesAllowed({"Admin", "Employee"})
public class Employee implements ExceptionMapper {
    @EJB
    BuildingService buildingService;

    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    @Context
    HttpHeaders httpHeaders;



    @PUT
    @Path("/updateBuildingRating/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response updateRating(@DefaultValue("0")
                                     @PathParam("id")int id,Double rating){
        Double buidingRating = buildingService.getBuildingById(id).getRating();
        buildingService.updateRatingById(id, rating);
        return Response.ok().entity("Building rating successfully updated from " + buidingRating + " to " + rating).build();
    }

    @PUT
    @Path("/updateBuildingDescription/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response updateDescription(@DefaultValue("0")
                                 @PathParam("id")int id,String description){
        buildingService.updateDescriptionById(id, description);
        return Response.ok().build();
    }

    @PUT
    @Path("/updateBuildingAddress/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response updateAddress(@DefaultValue("0")
                                      @PathParam("id")int id,String address){
        buildingService.updateAddressById(id, address);
        return Response.ok().build();
    }

    @PUT
    @Path("/updateBuildingName/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response updateName(@DefaultValue("0")
                                      @PathParam("id")int id,String name){
        buildingService.updateNameById(id, name);
        return Response.ok().build();
    }

    @PUT
    @Path("/updateBuildingName/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response updateUserLogin(@DefaultValue("0")
                               @PathParam("id")int id,String name){
        buildingService.updateNameById(id, name);
        return Response.ok().build();
    }


    @Override
    public Response toResponse(Throwable throwable) {
        return Response.status(500)
                .entity("ATTENTION! ERROR HANDLER IS FOUND A NEW ERROR")
                .build();
    }
}

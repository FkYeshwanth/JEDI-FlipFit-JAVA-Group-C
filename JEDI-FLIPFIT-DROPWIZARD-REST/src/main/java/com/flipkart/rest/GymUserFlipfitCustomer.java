package com.flipkart.rest;

import com.codahale.metrics.annotation.Timed;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.exception.UserAlreadyExistsException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.UserFlipFitServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1")
@Produces(MediaType.APPLICATION_JSON)
public class GymUserFlipfitCustomer {
    UserFlipFitServiceImpl userBusiness = new UserFlipFitServiceImpl();

    @GET
    @Path("/")
    @Timed
    public Response menu() {
        String menu = "1. Register as Customer\n2. Register as GymOwner\n3. Login";
        return Response.ok(menu).build();
    }

    @POST
    @Path("/customerRegistration")
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerCustomer(Customer customer) {
        try {
            userBusiness.registerCustomer(customer);
            return Response.ok("Customer registered successfully!").build();
        } catch (UserAlreadyExistsException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/gymOwnerRegistration")
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerGymOwner(GymOwner gymOwner) {
        try {
            userBusiness.registerGymOwner(gymOwner);
            return Response.ok("Gym Owner registered successfully!").build();
        } catch (UserAlreadyExistsException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authorizeUser(User user) {
        try {
            userBusiness.authenticateUser(user);
            return Response.ok("Authenticated the user successfully!").build();
        } catch (UserNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/logout")
    public Response LogOut(User user) {
        userBusiness.logout(user);
        return Response.ok("Logged out the user successfully!").build();
    }
}

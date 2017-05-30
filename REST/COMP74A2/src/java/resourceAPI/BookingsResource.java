/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resourceAPI;

import Model.Bookings;
import Model.Clients;
import Model.DataModel;
import Model.Hotels;
import com.google.gson.Gson;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Ray
 */
@Path("bookings")
public class BookingsResource {
    
    /**
     * Variables
     */
    @EJB DataModel model;
    Response.ResponseBuilder responseBuilder;
    Gson gson = new Gson();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BookingsResource
     */
    public BookingsResource() {
    }

    /**
     * Retrieves representation of an instance of resourceAPI.BookingsResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllBookings() {
        
        List<Bookings> bookings = model.getBookings();
       
        if(bookings == null)
        {
            responseBuilder = Response.status(Response.Status.NOT_FOUND);
        }
        else
        {
            responseBuilder = Response.status(Response.Status.OK);
        }
        
        return responseBuilder.entity(gson.toJson(bookings)).build();
    }
    
    @GET
    @Path("clients/{id}/hotels")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findClientsHotels(@PathParam("id") Integer id) {
        
        List<Hotels> bookings = model.getHotelByClientId(id);
        
        if(bookings.isEmpty())
        {
            responseBuilder = Response.status(Response.Status.NOT_FOUND);
        }
        else
        {
            responseBuilder = Response.status(Response.Status.OK);
        }
        
        return responseBuilder.entity(gson.toJson(bookings)).build();
    }
    
    @GET
    @Path("hotels/{id}/clients")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findHotelsClients(@PathParam("id") Integer id) {
        
        List<Clients> bookings = model.getClientByHotelId(id);
        
        if(bookings.isEmpty())
        {
            responseBuilder = Response.status(Response.Status.NOT_FOUND);
        }
        else
        {
            responseBuilder = Response.status(Response.Status.OK);
        }
        
        return responseBuilder.entity(gson.toJson(bookings)).build();
    }
    
    @GET
    @Path("clients/hotels/{month}/{day}/{year}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findClientsByHotelDate(@PathParam("month") String month, 
                                           @PathParam("day") String day, 
                                           @PathParam("year") String year) {
        
        List<Clients> bookings = model.getClientsByHotelDate(month, day, year);
        
        if(bookings.isEmpty())
        {
            responseBuilder = Response.status(Response.Status.NOT_FOUND);
        }
        else
        {
            responseBuilder = Response.status(Response.Status.OK);
        }
        
        return responseBuilder.entity(gson.toJson(bookings)).build();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") Integer id) {
        
        Bookings bookings = model.getBookingById(id);
              
        if(bookings == null)
        {
            responseBuilder = Response.status(Response.Status.NOT_FOUND);
        }
        else
        {
            responseBuilder = Response.status(Response.Status.OK);
        }
        
        return responseBuilder.entity(gson.toJson(bookings)).build();
    }
    
    @POST
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Integer id, String entity) {
        
        return Response.status(200).entity(model.updateBookingPost(id, entity)).build();
    
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNoId(String entity) {
        
        return Response.status(201).entity(model.createBookingPost(entity)).build();
    
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(@PathParam("id") Integer id, String entity) {
        
        return Response.status(201).entity(model.createBookings(id, entity)).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Integer id) { 
        
        if(model.deleteBooking(id))
        {
            responseBuilder = Response.status(Response.Status.OK);
        }
        else
        {
            responseBuilder = Response.status(Response.Status.NOT_FOUND);
        }
        
        return responseBuilder.build();  
    }
}

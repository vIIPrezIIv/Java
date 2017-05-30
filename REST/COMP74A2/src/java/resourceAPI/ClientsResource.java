/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resourceAPI;

import Model.Clients;
import Model.DataModel;
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
@Path("clients")
public class ClientsResource {
    
    /**
     * Variables
     */
    @EJB DataModel model;
    Response.ResponseBuilder responseBuilder;
    Gson gson = new Gson();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ClientsResource
     */
    public ClientsResource() {
    }

    /**
     * Retrieves representation of an instance of resourceAPI.ClientsResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllClients() {
        
        List<Clients> client = model.getClients();
       
        if(client == null)
        {
            responseBuilder = Response.status(Response.Status.NOT_FOUND);
        }
        else
        {
            responseBuilder = Response.status(Response.Status.OK);
        }
        
        return responseBuilder.entity(gson.toJson(client)).build();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") Integer id) {
        
        Clients client = model.getClientById(id);
              
        if(client == null)
        {
            responseBuilder = Response.status(Response.Status.NOT_FOUND);
        }
        else
        {
            responseBuilder = Response.status(Response.Status.OK);
        }
        
        return responseBuilder.entity(gson.toJson(client)).build();
    }
    
    @POST
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Integer id, String entity) {
        
        return Response.status(200).entity(gson.toJson(model.updateClientPost(id, entity))).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createNoId(String entity) {
        
        return Response.status(201).entity(gson.toJson(model.createClientPost(entity))).build();
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(@PathParam("id") Integer id, String entity) {
        
        return Response.status(201).entity(gson.toJson(model.createClients(id, entity))).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Integer id) { 
        
        if(model.deleteClient(id))
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

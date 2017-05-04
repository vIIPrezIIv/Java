/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp74a2client;

import Client.RESTBookings;
import Client.RESTClients;
import Client.RESTHotels;
import Model.Bookings;
import Model.Clients;
import Model.Hotels;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Ray
 */
public class COMP74A2Client {

    /**
     * @param args the command line arguments
     */
    RESTHotels hotels = new RESTHotels();
    RESTBookings bookings = new RESTBookings();
    RESTClients clients = new RESTClients();
    Clients newClient = new Clients(1, "Sam");
    Clients newClientTwo = new Clients(2, "Dawn");
    Clients newClientThree = new Clients(3, "Jack");
    Clients newClientFour = new Clients(4, "James");
    Hotels newHotel = new Hotels(1, "The Mass", "Orlando, FL");
    Hotels newHotelTwo = new Hotels(2, "The Honk", "New York, NY");
    Hotels newHotelThree = new Hotels(3, "The Moist", "New Jersey, NJ");
    Hotels newHotelFour = new Hotels(4, "007", "MI6, England");
    Bookings newBooking = new Bookings(5, 100005, "01", "01", "2001", "02-01-2000", "02-03-2000", "4", "Ray", 3, 1, "Toronto", "Montreal");
    Bookings newBookingTwo = new Bookings(2, 100006, "01", "02", "2001", "02-01-2000", "02-03-2000", "23", "Sam", 4, 4, "Edmonton", "Ottawa");        
    Bookings newBookingThree = new Bookings(3, 100007, "01", "01", "2001", "02-03-2000", "02-06-2000", "78", "Jack", 2, 6, "Detroit", "Calgary");
    Bookings newBookingFour = new Bookings(8, 100008, "01", "01", "2001", "02-04-2000", "02-07-2000", "234", "James", 3, 7, "Las Vegas", "New York");
        
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException, ParseException {
        
        /**
         * Initializes the class
         */
        COMP74A2Client testClient = new COMP74A2Client();
        
        /**
         * Runs the Clients Class
         */
        System.out.println("Clients Class" + "\n");
        testClient.runClients();
        System.out.println("\n");
        
        /**
         * Runs the Hotels Class
         */
        System.out.println("Hotels Class" + "\n");
        testClient.runHotels(); 
        System.out.println("\n");
        
        /**
         * Runs the Bookings Class
         */
        System.out.println("Bookings Class" + "\n");
        testClient.runBookings(); 
    }
    
    public void runBookings()
    {
        /**
         * GET
         */
        try
        {
            Response bookingRes = bookings.find(Response.class, "3");
            Bookings bookingResOne = null;
            
            if(bookingRes.getStatus() == 200)
            {
                bookingResOne = bookingRes.readEntity(Bookings.class);
            }
            
            System.out.println("GET " + bookingResOne + "  - Response Code:" + bookingRes.getStatus());
        }
        
        catch(Exception e)
        {
            System.out.println("Error:" + e);
        }
        
        /**
         * GET, to show 404 error
         */
        try
        {
            Response bookingRes = bookings.find(Response.class, "60");
            Bookings bookingResOne = null;
            
            if(bookingRes.getStatus() == 200)
            {
                bookingResOne = bookingRes.readEntity(Bookings.class);
            }
            
            System.out.println("GET " + bookingResOne + "  - Response Code:" + bookingRes.getStatus());
        }
        
        catch(Exception e)
        {
            System.out.println("Error:" + e);
        }

        /**
         * GET, all
         */
        try
        {
            GenericType<List<Bookings>> bookingsType = new GenericType<List<Bookings>>() {};
            Response allBookingRes = bookings.findAllBookings(Response.class);
            List<Bookings> listBookings = null;
            
            if(allBookingRes.getStatus() == 200)
            {
                listBookings = (List<Bookings>) allBookingRes.readEntity(bookingsType);
                
                for(int ctr = 0; ctr < listBookings.size(); ctr++)
                {
                    System.out.println("GET, all " + listBookings.get(ctr) + "  - Response Code:" + allBookingRes.getStatus());
                }
            }
            else
            {
                System.out.println("Empty List - Response Code:" + allBookingRes.getStatus());
            }
        }
        
        catch(Exception e)
        {
            System.out.println("Error:" + e);
        }
        
        /**
         * GET, Clients from Hotels
         */
        try
        {
            GenericType<List<Clients>> clientType = new GenericType<List<Clients>>() {};
            Response hotelsClientsRes = bookings.findHotelsClients(Response.class, "2");
            List<Clients> clientHotels = null;
            
            if(hotelsClientsRes.getStatus() == 200)
            {
                clientHotels = (List<Clients>) hotelsClientsRes.readEntity(clientType);
                
                for(int ctr = 0; ctr < clientHotels.size(); ctr++)
                {
                    System.out.println("GET, Clients from Hotels " + clientHotels.get(ctr) + "  - Response Code:" + hotelsClientsRes.getStatus());
                }
            }
            else
            {
                System.out.println("Empty List - Response Code:" + hotelsClientsRes.getStatus());
            }
        }
        
        catch(Exception e)
        {
            System.out.println("Error:" + e);
        }
        
        /**
         * GET, Hotels from Clients
         */
        try
        {
            GenericType<List<Hotels>> hotelType = new GenericType<List<Hotels>>() {};
            Response clientsHotelsRes = bookings.findClientsHotels(Response.class, "1");
            List<Hotels> hotelsClients = null;
            
            if(clientsHotelsRes.getStatus() == 200)
            {
               hotelsClients = (List<Hotels>) clientsHotelsRes.readEntity(hotelType);
               
               for(int ctr = 0; ctr < hotelsClients.size(); ctr++)
               {
                   System.out.println("GET, Hotels from Clients " + hotelsClients.get(ctr) + "  - Response Code:" + clientsHotelsRes.getStatus());
               }
            }
            else
            {
                System.out.println("Empty List - Response Code:" + clientsHotelsRes.getStatus());
            }
        }

        catch(Exception e)
        {
            System.out.println("Error:" + e);
        }
        
        /**
         * GET, Clients who stayed at Hotels on certain dates
         */
        try
        {
            GenericType<List<Clients>> clientDateType = new GenericType<List<Clients>>() {};
            Response clientsByDateRes = bookings.findClientsByHotelDate(Response.class, "01", "01", "2000");
            List<Clients> clientDates = null;
            
            if(clientsByDateRes.getStatus() == 200)
            {
                clientDates = (List<Clients>) clientsByDateRes.readEntity(clientDateType);
                
                for(int ctr = 0; ctr < clientDates.size(); ctr++)
                {
                    System.out.println("GET, Clients who stayed at Hotels on certain Dates " + clientDates.get(ctr) + "  - Response Code:" + clientsByDateRes.getStatus());
                }
            }
            else
            {
                System.out.println("Empty List - Response Code:" + clientsByDateRes.getStatus());
            }
        }
        
        catch(Exception e)
        {
            System.out.println("Error:" + e);
        }
                
        /**
         * POST
         */
        System.out.println("POST - Response Code:" + bookings.createNoId(newBooking).getStatus());
        
        /**
         * POST, with ID
         */
        System.out.println("POST, with ID - Response Code:" + bookings.update(newBookingTwo, "2").getStatus());
        
        /**
         * PUT, edit
         */
        System.out.println("PUT, edit - Response Code:" + bookings.edit(newBookingThree, "3").getStatus());
        
        /**
         * PUT, create
         */
        System.out.println("PUT, create - Response Code:" + bookings.edit(newBookingFour, "8").getStatus());
        
        /**
         * DELETE
         */
        System.out.println("DELETE - Response Code:" + bookings.remove("2").getStatus());
    }
    
    public void runHotels()
    {
         /**
         * GET
         */
        try
        {
            Response hotelRes = hotels.find(Response.class, "1");
            Hotels hotelResOne = null;
            
            if(hotelRes.getStatus() == 200)
            {
                hotelResOne = hotelRes.readEntity(Hotels.class);
            }
            
            System.out.println("GET " + hotelResOne + "  - Response Code:" + hotelRes.getStatus());
        }

        catch(Exception e)
        {
            System.out.println("Error:" + e);
        }
        
        /**
         * GET, all
         */
        try
        {
            GenericType<List<Hotels>> hotelType = new GenericType<List<Hotels>>() {};
            Response allHotelsRes = hotels.findAllHotels(Response.class);
            List<Hotels> listHotels = null;

            if(allHotelsRes.getStatus() == 200)
            {
                listHotels = (List<Hotels>) allHotelsRes.readEntity(hotelType);
                
                for(int ctr = 0; ctr < listHotels.size(); ctr++)
                {
                    System.out.println("GET, all " + listHotels.get(ctr) + "  - Response Code:" + allHotelsRes.getStatus());
                }
            }
            else
            {
                System.out.println("Empty List - Response Code:" + allHotelsRes.getStatus());
            }
        }
   
        catch(Exception e)
        {
            System.out.println("Error:" + e);
        }
        
        /**
         * POST
         */
        System.out.println("POST - Response Code:" + hotels.createNoId(newHotel).getStatus());
        
        /**
         * POST, with ID
         */
        System.out.println("POST, with ID - Response Code:" + hotels.update(newHotelTwo, "2").getStatus());
        
        /**
         * PUT, edit
         */
        System.out.println("PUT, edit - Response Code:" + hotels.edit(newHotelThree, "3").getStatus());
        
        /**
         * PUT, create
         */
        System.out.println("PUT, create - Response Code:" + hotels.edit(newHotelFour, "8").getStatus());
        
        /**
         * DELETE
         */
        System.out.println("DELETE - Response Code:" + hotels.remove("1").getStatus());
    }
    
    public void runClients()
    {
         /**
         * GET
         */
        try
        {
            Response clientRes = clients.find(Response.class, "1");
            Clients clientResOne = null;
            
            if(clientRes.getStatus() == 200)
            {
                clientResOne = clientRes.readEntity(Clients.class);
            }
            
            System.out.println("GET " + clientResOne + "  - Response Code:" + clientRes.getStatus()); 
        }

        catch(Exception e)
        {
            System.out.println("Error:" + e);
        }
        
        /**
         * GET, all
         */
        try
        {
            GenericType<List<Clients>> clientType = new GenericType<List<Clients>>() {};
            Response allClientsRes = clients.findAllClients(Response.class);
            List<Clients> listClients = null;

            if(allClientsRes.getStatus() == 200)
            {
                listClients = (List<Clients>) allClientsRes.readEntity(clientType);
                
                for(int ctr = 0; ctr < listClients.size(); ctr++)
                {
                    System.out.println("GET, all " + listClients.get(ctr) + "  - Response Code:" + allClientsRes.getStatus());
                }
            }
            else
            {
                System.out.println("Empty List - Response Code:" + allClientsRes.getStatus());
            }
        }

        catch(Exception e)
        {
            System.out.println("Error:" + e);
        }
        
        /**
         * POST
         */
        System.out.println("POST - Response Code:" + clients.createNoId(newClient).getStatus());
        
        /**
         * POST, with ID
         */
        System.out.println("POST, with ID - Response Code:" + clients.update(newClientTwo, "2").getStatus());
        
        /**
         * PUT, edit
         */
        System.out.println("PUT, edit - Response Code:" + clients.edit(newClientThree, "3").getStatus());
        
        /**
         * PUT, create
         */
        System.out.println("PUT, create - Response Code:" + clients.edit(newClientFour, "8").getStatus());
        
        /**
         * DELETE
         */
        System.out.println("DELETE - Response Code:" + clients.remove("2").getStatus());   
    }
}

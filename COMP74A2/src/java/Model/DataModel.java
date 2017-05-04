/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Singleton;



/**
 *
 * @author Ray
 */
@Singleton
public class DataModel {

    /**
     * Variables
     */
    private List<Clients> clients = new ArrayList<>();
    private List<Bookings> bookings = new ArrayList<>();
    private List<Hotels> hotels = new ArrayList<>();
    private Gson gson = new Gson();
    private boolean deleteBool = false;
    
    /**
     * Constructor, adds clients, bookings and hotels
     * @throws ParseException 
     */
    public DataModel() throws ParseException
    {  
        clients.add(new Clients(1, "Ray"));
        clients.add(new Clients(2, "John"));
        clients.add(new Clients(3, "Joe"));
        bookings.add(new Bookings(1, 100001, "01", "01", "2001", "02-01-2000", "02-03-2000", "12", "Ray", 1, 1, "Montreal", "Jamacia"));
        bookings.add(new Bookings(2, 100002, "01", "01", "2000", "02-01-2000", "02-03-2000", "14", "John", 2, 2, "Toronto", "London"));
        bookings.add(new Bookings(3, 100003, "01", "01", "2000", "02-02-2000", "02-03-2000", "17", "Joe", 2, 3, "Vacnouver", "Moscow"));
        bookings.add(new Bookings(4, 100004, "01", "01", "2000", "02-01-2000", "02-03-2000", "18", "Ray", 2, 1, "Calgary", "Chicago"));
        hotels.add(new Hotels(1, "The Grace", "Hollywood, LA"));
        hotels.add(new Hotels(2, "The Mars", "New York, NY"));
    }
    
    /**
     * getClientById, gets the client by the id
     * @param Id
     * @return 
     */
    public Clients getClientById(int Id)
    {
        return this.clients.stream().filter(Clients -> Clients.getId() == Id).findAny().orElse(null);
    }
    
    /**
     * geetHotelById, gets the hotel by the id
     * @param Id
     * @return 
     */
    public Hotels getHotelById(int Id)
    {
        return this.hotels.stream().filter(Hotels -> Hotels.getId() == Id).findAny().orElse(null);
    }
    
    /**
     * getBookingById, gets the booking by id
     * @param Id
     * @return 
     */
    public Bookings getBookingById(int Id)
    {
        return this.bookings.stream().filter(Bookings -> Bookings.getId() == Id).findAny().orElse(null);
    }
    
    /**
     * getHotelByClientId, gets the hotels a single client has stayed at
     * @param id
     * @return 
     */
    public List<Hotels> getHotelByClientId(int id)
    {   
        List<Integer> idList = new ArrayList<>();
        List<Hotels> hotelList = new ArrayList<>();
        List<Bookings> bookingList = this.bookings.stream().filter(Bookings -> Bookings.getClientId() == id).collect(Collectors.toList());
        
        for (int i = 0; i < bookingList.size(); i++) 
            {
                idList.add(bookingList.get(i).getHotelId());
            }
        
        for (int i = 0; i < idList.size(); i++) 
            {
                int finalId = idList.get(i);
                hotelList.add(this.hotels.stream().filter(Hotels -> Hotels.getId() == finalId).findAny().orElse(null));
            }
        
        return hotelList;
    }
    
    /**
     * getClientByHotelId, gets the clients that have stayed at a certain hotel
     * @param id
     * @return 
     */
    public List<Clients> getClientByHotelId(int id)
    {
        List<Integer> idList = new ArrayList<>();
        List<Clients> clientList = new ArrayList<>();
        List<Bookings> bookingList = this.bookings.stream().filter(Bookings -> Bookings.getHotelId() == id).collect(Collectors.toList());
        
        for (int i = 0; i < bookingList.size(); i++) 
            {
                idList.add(bookingList.get(i).getClientId());
            }
        
        for (int i = 0; i < idList.size(); i++) 
            {
                int finalId = idList.get(i);
                clientList.add(this.clients.stream().filter(Clients -> Clients.getId() == finalId).findAny().orElse(null));
            }
        
        return clientList;
    }
    
    /**
     * getClientsByHotelDate, returns the Clients that have stayed at a hotel based on date
     * @param month
     * @param day
     * @param year
     * @return 
     */
    public List<Clients> getClientsByHotelDate(String month, String day, String year) 
    {
        List<Integer> idList = new ArrayList<>();
        List<Clients> clientList = new ArrayList<>();
        List<Bookings> bookingList = this.bookings.stream().filter(Bookings -> Bookings.getBookingMonth().equals(month))
                                                           .filter(Bookings -> Bookings.getBookingDay().equals(day))
                                                           .filter(Bookings -> Bookings.getBookingYear().equals(year))
                                                           .collect(Collectors.toList());
        
        for (int i = 0; i < bookingList.size(); i++) 
            {
                idList.add(bookingList.get(i).getClientId());
            }
        
        for (int i = 0; i < idList.size(); i++) 
            {
                int finalId = idList.get(i);
                clientList.add(this.clients.stream().filter(Clients -> Clients.getId() == finalId).findAny().orElse(null));
            }
        
        return clientList;
    }      
    
    /**
     * createHotels, handles the PUT request for creation or updating
     * @param id
     * @param entity 
     */
    public Hotels createHotels(int id, String entity) 
    {
        Type hotelType = new TypeToken<Hotels>(){}.getType();
        Hotels hotel = gson.fromJson(entity, hotelType);
        
        if(getHotelById(id) != null && getHotelById(hotel.getId()) != null)
        {
            for (int i = 0; i < hotels.size(); i++) 
            {
                if (hotels.get(i).getId() == id) 
                {
                   hotel.setId(hotels.get(i).getId());
                   this.hotels.set(i, hotel);
                }
            }
        }
        else
        {   
            hotel.setId(this.hotels.size() + 1);
            
            this.hotels.add(hotel);  
        }
        
        return hotel;
    }
    
    /**
     * createHotelPost, handles the creation for POST
     * @param entity 
     */
    public Hotels createHotelPost(String entity)
    {
        Type hotelType = new TypeToken<Hotels>(){}.getType();
        Hotels hotel = gson.fromJson(entity, hotelType);
        
        if(hotel.getId() > this.hotels.size())
        {
            hotel.setId(this.hotels.size() + 1);
        }
        
        if(getHotelById(hotel.getId()) != null)
        {
            hotel.setId(this.hotels.size() + 1);
        }
        
        this.hotels.add(hotel);
        
        return hotel;
    }
    
    /**
     * updateHotelPost, handles the updating for POST
     * @param id
     * @param entity 
     */
    public Hotels updateHotelPost(int id, String entity)
    {
        Type hotelType = new TypeToken<Hotels>(){}.getType();
        Hotels hotel = gson.fromJson(entity, hotelType);
 
        if(getHotelById(id) != null && getHotelById(hotel.getId()) != null)
        {
            for (int i = 0; i < hotels.size(); i++) 
            {
                if (hotels.get(i).getId() == id) 
                {
                   hotel.setId(hotels.get(i).getId());
                   this.hotels.set(i, hotel);
                }
            }
        }
        
        return hotel;
    }
    
    /**
     * deleteHotel, deletes a hotel
     * @param id 
     */
    public boolean deleteHotel(int id)
    { 
        deleteBool = false;
        
        for (int i = 0; i < hotels.size(); i++) 
            {
                if (hotels.get(i).getId()== id) 
                {
                   this.hotels.remove(i);
                   deleteBool = true;
                }
            }
        
        cleanupDeleteHotel(id);
        
        return deleteBool;
    }
    
    /**
     * createClients, handles create and updating for PUT
     * @param id
     * @param entity 
     */
    public Clients createClients(int id, String entity) 
    {
        Type clientType = new TypeToken<Clients>(){}.getType();
        Clients client = gson.fromJson(entity, clientType);
        
        if(getClientById(id) != null && getClientById(client.getId()) != null)
        {
            for (int i = 0; i < clients.size(); i++) 
            {
                if (clients.get(i).getId() == id) 
                {
                   client.setId(clients.get(i).getId());
                   this.clients.set(i, client);
                }
            }
        }
        else
        {   
            client.setId(this.clients.size() + 1);
            
            this.clients.add(client);  
        }
        
        return client;
    }
    
    /**
     * createClientPost, handles creation for POST
     * @param entity 
     */
    public Clients createClientPost(String entity)
    {
        Type clientType = new TypeToken<Clients>(){}.getType();
        Clients client = gson.fromJson(entity, clientType);
        
        if(client.getId() > this.clients.size())
        {
            client.setId(this.clients.size() + 1);
        }
        
        if(getClientById(client.getId()) != null)
        {
            client.setId(this.clients.size() + 1);
        }
        
        this.clients.add(client);
        
        return client;
    }
    
    /**
     * updateClientPost, handles updating for POST
     * @param id
     * @param entity 
     */
    public Clients updateClientPost(int id, String entity)
    {
        Type clientType = new TypeToken<Clients>(){}.getType();
        Clients client = gson.fromJson(entity, clientType);
 
        if(getClientById(id) != null && getClientById(client.getId()) != null)
        {
            for (int i = 0; i < clients.size(); i++) 
            {
                if (clients.get(i).getId() == id) 
                {
                   client.setId(clients.get(i).getId());
                   this.clients.set(i, client);
                }
            }
        }
        
        return client;
    }
    
    /**
     * deleteClient, deletes a client
     * @param id 
     */
    public boolean deleteClient(int id)
    {
        deleteBool = false;
        
        for (int i = 0; i < clients.size(); i++) 
            {
                if (clients.get(i).getId() == id) 
                {
                   this.clients.remove(i);
                   deleteBool = true;
                }
            }
        
        cleanupDeleteClient(id);
        
        return deleteBool;
    }
    
    /**
     * cleanupDeleteClient, deletes bookings if client is deleted
     * @param id 
     */
    public void cleanupDeleteClient(int id)
    {
        for (int i = 0; i < bookings.size(); i++) 
            {
                if (bookings.get(i).getClientId() == id) 
                {
                   this.bookings.remove(i);
                }
            }
    }
    
    /**
     * cleanupDeleteHotel, deletes bookings if hotel is deleted
     * @param id 
     */
    public void cleanupDeleteHotel(int id)
    {
        for (int i = 0; i < bookings.size(); i++) 
            {
                if (bookings.get(i).getHotelId() == id) 
                {
                   this.bookings.remove(i);
                }
            }
    }
    
    /**
     * getBookings, returns all the bookings
     * @return 
     */
    public List<Bookings> getBookings()
    {
        return this.bookings;
    }
    
    /**
     * getHotels, returns all hotels
     * @return 
     */
    public List<Hotels> getHotels()
    {
        return this.hotels;
    }
    
    /**
     * getClients, returns all clients
     * @return 
     */
    public List<Clients> getClients()
    {
        return this.clients;
    }

    /**
     * deleteBooking, deletes a booking
     * @param id 
     */
    public boolean deleteBooking(int id) 
    {
        deleteBool = false;
        
        for (int i = 0; i < bookings.size(); i++) 
            {
                if (bookings.get(i).getId()== id) 
                {
                   this.bookings.remove(i);
                   deleteBool = true;
                }
            }
        
        return deleteBool;
    }
    
    /**
     * createBookings, handles create and updating for PUT
     * @param id
     * @param entity 
     */
    public Bookings createBookings(int id, String entity) 
    {
        Type bookingType = new TypeToken<Bookings>(){}.getType();
        Bookings booking = gson.fromJson(entity, bookingType);
        
        if(getBookingById(id) != null && getBookingById(booking.getId()) != null)
        {
            for (int i = 0; i < bookings.size(); i++) 
            {
                if (bookings.get(i).getId() == id) 
                {
                   booking.setId(bookings.get(i).getId());
                   this.bookings.set(i, booking);
                }
            }
        }
        else
        {   
            booking.setId(this.bookings.size() + 1);
            
            this.bookings.add(booking);  
        }
        
        return booking;
    }
    
    /**
     * createBookingPost, handles creation for POST
     * @param entity 
     */
    public Bookings createBookingPost(String entity)
    {
        Type bookingType = new TypeToken<Bookings>(){}.getType();
        Bookings booking = gson.fromJson(entity, bookingType);
        
        if(booking.getId() > this.bookings.size())
        {
            booking.setId(this.bookings.size() + 1);
        }
        
        if(getBookingById(booking.getId()) != null)
        {
            booking.setId(this.bookings.size() + 1);
        }
        
        this.bookings.add(booking);
        
        return booking;
    }
    
    /**
     * updateBookingPost, handles updating for POST
     * @param id
     * @param entity 
     */
    public Bookings updateBookingPost(int id, String entity)
    {
        Type bookingType = new TypeToken<Bookings>(){}.getType();
        Bookings booking = gson.fromJson(entity, bookingType);
 
        if(getBookingById(id) != null && getBookingById(booking.getId()) != null)
        {
            for (int i = 0; i < bookings.size(); i++) 
            {
                if (bookings.get(i).getId() == id) 
                {
                   booking.setId(bookings.get(i).getId());
                   this.bookings.set(i, booking);
                }
            }
        }
        
        return booking;
    }
}

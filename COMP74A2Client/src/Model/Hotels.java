/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Ray
 */
public class Hotels implements Serializable{

    /**
     * Variables
     */
    int id;
    String name;
    String hotelLocation;
    
    /**
     * Default Constructor
     */
    public Hotels()
    {
        
    }
    
    /**
     * Constructor
     * @param id
     * @param name
     * @param hotelLocation 
     */
    public Hotels(int id, String name, String hotelLocation)
    {
        this.id = id;
        this.name = name;
        this.hotelLocation = hotelLocation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public String getHotelLocation()
    {
        return this.hotelLocation;
    }
    
    @Override
    public String toString()
    {
        return id + " " + name + " " + hotelLocation;
    }
}

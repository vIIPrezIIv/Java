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
public class Clients implements Serializable{
    
    /**
     * Variables
     */
    int id;
    String name;
    
    /**
     * Default Constructor
     */
    public Clients()
    {
        
    }
    
    /**
     * Constructor
     * @param id
     * @param name
     */
    public Clients(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
    
    public int getId()
    {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName()
    {
        return this.name;
    } 
    
    @Override
    public String toString()
    {
        return id + " " + name;
    }
}

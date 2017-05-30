/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.beans.*;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SingleSite", propOrder = {
    "name"
})
@XmlRootElement(name = "SingleSite", namespace = "AssignmentOne")

/**
 *
 * @author Ray
 */
public class Sites implements Serializable {
    
    /**
     * Constructor for Sites Class
     */
    public Sites() {
 
    }
    
    private String name;
    
    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Set the value of name
     *
     * @param newName new value of name
     */
    public void setName(String newName)
    {
        this.name = newName;
    }
    
    /**
     * toString for name
     * @return 
     */
    @Override
    public String toString() {
        return this.name;
    }
}

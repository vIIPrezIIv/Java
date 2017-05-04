/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SingleEmployee", propOrder = {
    "name", "startTime", "endTime"
})
@XmlRootElement(name = "SingleEmployee", namespace = "AssignmentOne")

/**
 *
 * @author Ray
 */
public class Employee implements Serializable {
    
    /**
     * Constructor for Employee Class
     */
    public Employee() {

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
     *
     * 
     */
    @Override
    public String toString() {
        return this.name;
    }
    
    private String startTime;
    /**
     * Get the value of startTime
     *
     * @return the value of startTime
     */
    public String getStartTime()
    {
        return startTime;
    }
    /**
     * Set the value of startTime
     *
     * @param newStartTime new value of startTime
     */
    public void setStartTime(String newStartTime)
    {
        this.startTime = newStartTime;
    }
    
    private String endTime;
    /**
     * Get the value of endTime
     *
     * @return the value of endTime
     */
    public String getEndTime()
    {
        return endTime;
    }
    /**
     * Set the value of endTime
     *
     * @param newEndTime new value of endTime
     */
    public void setEndTime(String newEndTime)
    {
        this.endTime = newEndTime;
    }
    
    
}

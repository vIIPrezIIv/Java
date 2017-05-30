/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.beans.*;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SingleScheduledEvent", namespace = "AssignmentOne")
/**
 *
 * @author Ray
 */
public class EventSch {
    
   private String name;
   private String eventName;
   
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
     * Get the value of eventName
     *
     * @return the value of eventName
     */
   public String getEventName()
    {
        return eventName;
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
     * Set the value of eventName
     *
     * @param newEventName new value of eventName
     */
    public void setEventName(String newEventName)
    {
        this.eventName = newEventName;
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

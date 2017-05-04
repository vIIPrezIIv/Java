/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//@XmlRootElement
//@XmlType(propOrder={"eventSites"})
//@XmlAccessorType(XmlAccessType.FIELD)

/**
 *
 * @author Ray
 */
public class EventSites /*implements Serializable*/ extends ArrayList<Sites> {
    
    //@XmlElementWrapper(name="eventSites")
    /**
     * get for EventSites
     * @return 
     */
    @XmlElement(name="site") 
    public ArrayList<Sites> getList()
    {
        return this;
    }
    
    /*private ArrayList<Sites> eventSites;
    
    public EventSites() {
        eventSites = new ArrayList<>();
    }
    
    public ArrayList<Sites> getEventSites() {
        return eventSites;
    }
    
    public void setEventSites(ArrayList<Sites> newEventSites) {
        this.eventSites = newEventSites;
    }*/
    
}

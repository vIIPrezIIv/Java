/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Ray
 */
public class EventScheduleBean extends ArrayList<EventSch> {
    
    /**
     * get for EventScheduleBean
     * @return 
     */
    @XmlElement(name="selectedEvent") 
    public ArrayList<EventSch> getList()
    {
        return this;
    }
    
    
}

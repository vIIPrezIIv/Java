/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.beans.*;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SingleEvent", namespace = "AssignmentOne")

/**
 *
 * @author Ray
 */
public class Event {
    
    /**
     * Variables for Event Class
     */
    private String eventName;
    private String eventTime;
    private String eventSite;
    private String eventEquip;
    private String endEventTime;

    /**
     * Get the value of eventName
     *
     * @return the value of eventName
     */
    public String getEventName() {
        return eventName;
    }
    /**
     * Get the value of eventTime
     *
     * @return the value of eventTime
     */
    public String getEventTime() {
        return eventTime;
    }
    /**
     * Get the value of endEventTime
     *
     * @return the value of endEventTime
     */
    public String getEndEventTime() {
        return endEventTime;
    }
    /**
     * Get the value of eventSite
     *
     * @return the value of eventSite
     */
    public String getEventSite() {
        return eventSite;
    }
    /**
     * Get the value of eventEquip
     *
     * @return the value of eventEquip
     */
    public String getEventEquip() {
        return eventEquip;
    }

    /**
     * Set the value of eventName
     *
     * @param newEventName new value of eventName
     */
    public void setEventName(String newEventName) {
        this.eventName = newEventName;
    }
    /**
     * Set the value of eventTime
     *
     * @param newEventTime new value of eventTime
     */
    public void setEventTime(String newEventTime) {
        this.eventTime = newEventTime;
    }
    /**
     * Set the value of endEventTime
     *
     * @param newEndEventTime new value of eventEndEventTime
     */
    public void setEndEventTime(String newEndEventTime) {
        this.endEventTime = newEndEventTime;
    }
    /**
     * Set the value of EventEquip
     *
     * @param newEventEquip new value of eventEquip
     */
    public void setEventEquip(String newEventEquip) {
        this.eventEquip = newEventEquip;
    }
    /**
     * Set the value of eventSite
     *
     * @param newEventSite new value of eventSite
     */
    public void setEventSite(String newEventSite) {
        this.eventSite = newEventSite;
    }
    /**
     * toString for eventName
     *
     * 
     */
    @Override
    public String toString() {
        return this.eventName;
    }
    
    
    
}

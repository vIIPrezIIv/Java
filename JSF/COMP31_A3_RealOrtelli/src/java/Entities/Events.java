/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ray
 */
@Entity
@Table(name = "events")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Events.findAll", query = "SELECT e FROM Events e"),
    @NamedQuery(name = "Events.findByEventId", query = "SELECT e FROM Events e WHERE e.eventId = :eventId"),
    @NamedQuery(name = "Events.findByEventName", query = "SELECT e FROM Events e WHERE e.eventName = :eventName"),
    @NamedQuery(name = "Events.findByEventStartTime", query = "SELECT e FROM Events e WHERE e.eventStartTime = :eventStartTime"),
    @NamedQuery(name = "Events.findByEventEndTime", query = "SELECT e FROM Events e WHERE e.eventEndTime = :eventEndTime"),
    @NamedQuery(name = "Events.findByLocation", query = "SELECT e FROM Events e WHERE e.location = :location"),
    @NamedQuery(name = "Events.findByEquipment", query = "SELECT e FROM Events e WHERE e.equipment = :equipment"),
    @NamedQuery(name = "Events.findByEventDay", query = "SELECT e FROM Events e WHERE e.eventDay = :eventDay"),
    @NamedQuery(name = "Events.findByEventMonth", query = "SELECT e FROM Events e WHERE e.eventMonth = :eventMonth")})
public class Events implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "eventId")
    private Integer eventId;
    @Size(max = 25)
    @Column(name = "eventName")
    private String eventName;
    @Column(name = "eventStartTime")
    @Temporal(TemporalType.TIME)
    private Date eventStartTime;
    @Column(name = "eventEndTime")
    @Temporal(TemporalType.TIME)
    private Date eventEndTime;
    @Size(max = 25)
    @Column(name = "location")
    private String location;
    @Size(max = 25)
    @Column(name = "equipment")
    private String equipment;
    @Column(name = "eventDay")
    @Temporal(TemporalType.DATE)
    private Date eventDay;
    @Column(name = "eventMonth")
    @Temporal(TemporalType.DATE)
    private Date eventMonth;

    public Events() {
    }

    public Events(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(Date eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public Date getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(Date eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public Date getEventDay() {
        return eventDay;
    }

    public void setEventDay(Date eventDay) {
        this.eventDay = eventDay;
    }

    public Date getEventMonth() {
        return eventMonth;
    }

    public void setEventMonth(Date eventMonth) {
        this.eventMonth = eventMonth;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Events)) {
            return false;
        }
        Events other = (Events) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Events[ eventId=" + eventId + " ]";
    }
    
}

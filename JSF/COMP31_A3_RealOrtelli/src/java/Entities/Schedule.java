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
@Table(name = "schedule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedule.findAll", query = "SELECT s FROM Schedule s"),
    @NamedQuery(name = "Schedule.findByScheduleId", query = "SELECT s FROM Schedule s WHERE s.scheduleId = :scheduleId"),
    @NamedQuery(name = "Schedule.findByEmployeeName", query = "SELECT s FROM Schedule s WHERE s.employeeName = :employeeName"),
    @NamedQuery(name = "Schedule.findByStartTime", query = "SELECT s FROM Schedule s WHERE s.startTime = :startTime"),
    @NamedQuery(name = "Schedule.findByEndTime", query = "SELECT s FROM Schedule s WHERE s.endTime = :endTime"),
    @NamedQuery(name = "Schedule.findByScheduledDay", query = "SELECT s FROM Schedule s WHERE s.scheduledDay = :scheduledDay"),
    @NamedQuery(name = "Schedule.findByScheduledMonth", query = "SELECT s FROM Schedule s WHERE s.scheduledMonth = :scheduledMonth"),
    @NamedQuery(name = "Schedule.findByEventId", query = "SELECT s FROM Schedule s WHERE s.eventId = :eventId")})
public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "scheduleId")
    private Integer scheduleId;
    @Size(max = 25)
    @Column(name = "employeeName")
    private String employeeName;
    @Column(name = "startTime")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Column(name = "endTime")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @Column(name = "scheduledDay")
    @Temporal(TemporalType.DATE)
    private Date scheduledDay;
    @Column(name = "scheduledMonth")
    @Temporal(TemporalType.DATE)
    private Date scheduledMonth;
    @Column(name = "eventId")
    private Integer eventId;

    public Schedule() {
    }

    public Schedule(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getScheduledDay() {
        return scheduledDay;
    }

    public void setScheduledDay(Date scheduledDay) {
        this.scheduledDay = scheduledDay;
    }

    public Date getScheduledMonth() {
        return scheduledMonth;
    }

    public void setScheduledMonth(Date scheduledMonth) {
        this.scheduledMonth = scheduledMonth;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scheduleId != null ? scheduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Schedule)) {
            return false;
        }
        Schedule other = (Schedule) object;
        if ((this.scheduleId == null && other.scheduleId != null) || (this.scheduleId != null && !this.scheduleId.equals(other.scheduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Schedule[ scheduleId=" + scheduleId + " ]";
    }
    
}

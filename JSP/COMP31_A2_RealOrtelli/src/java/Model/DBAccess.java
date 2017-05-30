/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Ray
 */
public class DBAccess {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    /**
     * Initializes the database connection
     */
    public DBAccess()
    {
        emf = Persistence.createEntityManagerFactory("COMP31_A2_Real_OrtelliPU");
        em = emf.createEntityManager();
    }
    
    /**
     * Returns the EntityManager
     * @return 
     */
    public EntityManager getEntityManager()
    {
        return em;
    }
    
    /**
     * Returns eventId from providing eventName
     * @param eventName
     * @return 
     */
    public Events getEventId(String eventName)
    {
        Query query = em.createNamedQuery("Events.findByEventIdByName").setParameter("eventName", eventName);
        return (Events) query.getSingleResult();
        //int result = (int)query.getSingleResult();
        //return result;
    }
    
    /**
     * Returns employeeId from providing employeeName
     * @param employeeName
     * @return 
     */
    public int getEmployeeId(String employeeName)
    {
        Query query = em.createNamedQuery("Employee.findByEmployeeIdByName").setParameter("employeeName", employeeName);
        int result = (int)query.getSingleResult();
        return result;
    }
    
    /**
     * Returns events based on the provided day
     * @param day
     * @return 
     */
    public List<Events> getEventBasedOnDay(Date day)
    {
        Query query = em.createNamedQuery("Events.findByEventDay").setParameter("eventDay", day);
        List<Events> resultList = query.getResultList();
        return resultList; 
    }

    /**
     * Returns a list of employees
     * @return 
     */
    public List<Employee> getEmployeeList()
    {
        Query query = em.createNamedQuery("Employee.findAll");
        List<Employee> resultList = query.getResultList();
        return resultList;     
    }
    
    /**
     * Returns a list of users
     * @return 
     */
    public List<Users> getUserList()
    {
        Query query = em.createNamedQuery("Users.findAll");
        List<Users> resultList = query.getResultList();
        return resultList; 
    }
    
    /**
     * Returns a list of events
     * @return 
     */
    public List<Events> getEventList()
    {
        Query query = em.createNamedQuery("Events.findAll");
        List<Events> resultList = query.getResultList();
        return resultList; 
    }
    
    /**
     * Returns the schedule
     * @return 
     */
    public List<Schedule> getScheduleList()
    {
        Query query = em.createNamedQuery("Schedule.findAll");
        List<Schedule> resultList = query.getResultList();
        return resultList; 
    }
    
    /**
     * Returns a list of the equipment
     * @return 
     */
    public List<Equipment> getEquipmentList()
    {
        Query query = em.createNamedQuery("Equipment.findAll");
        List<Equipment> resultList = query.getResultList();
        return resultList; 
    }
    
    /**
     * Returns a list of locations
     * @return 
     */
    public List<Locations> getLocationList()
    {
        Query query = em.createNamedQuery("Locations.findAll");
        List<Locations> resultList = query.getResultList();
        return resultList; 
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entities.Employee;
import Entities.Equipment;
import Entities.Events;
import Entities.Locations;
import Entities.Schedule;
import Entities.Users;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ray
 */

@ManagedBean(name = "Controller")
@SessionScoped

public class Controller implements Serializable{
    
    /**
     * EJB facades
     */
    @EJB UsersFacade users;
    @EJB LocationsFacade locations;
    @EJB EquipmentFacade equipment;
    @EJB EventsFacade events;
    @EJB EmployeeFacade employees;
    @EJB ScheduleFacade schedules;
    
    /**
     * Variables
     */
    private String currentPage;
    private List<Users> userList;
    private List<Locations> locationList;
    private List<Equipment> equipmentList;
    private List<Events> eventList;
    private List<Events> eventDayList;
    private List<Employee> employeeList;
    private List<Schedule> scheduleList;
    private int permissionId;
    private String currentLogin;
    private String addEventDay;
    private String addEventMonth;
    
    /**
     * Constructor
     */
    public Controller()
    {
        permissionId = -1;
    }
    
    /**
     * gets the current login
     * @return 
     */
    public String getCurrentLogin()
    {
        return currentLogin;
    }
    
    /**
     * Sets the current login
     * @param newLogin 
     */
    public void setCurrentLogin(String newLogin)
    {
        this.currentLogin = newLogin;
    }
    
    /**
     * Gets the current permission
     * @return 
     */
    public int getPermission()
    {
        return permissionId;
    }
    
    /**
     * Sets the permission
     * @param newPermission 
     */
    public void setPermission(int newPermission)
    {
        this.permissionId = newPermission;
    }
    
    /**
     * Gets the current page
     * @return 
     */
    public String getCurrentPage() 
    {
        return currentPage;
    }
    
    /**
     * Sets the current page
     * @param currentPage 
     */
    public void setCurrentPage(String currentPage) 
    {
        this.currentPage = currentPage;
    }
    
    /**
     * Directs to login page
     * @return 
     */
    public String goToLogin()
    {
        currentPage = "login";
        return currentPage;
    }
    
    /**
     * Validates user credentials for login, then forwards the user to calendar.xhtml if successful.
     * If unsuccessful user gets redirected the invalid.xhtml
     * @param userName
     * @param password
     * @throws IOException 
     */
    public void validateLogin(String userName, String password) throws IOException
    {
        userList = getUserList();
            
            for(int ctr = 0; ctr < userList.size(); ctr++)
            {  
               if(userName.equals(userList.get(ctr).getLoginName()) && password.equals(userList.get(ctr).getPassword()))
               {
                   setCurrentLogin(userName);

                   switch(userName)
                   {
                       case "manager":
                           setPermission(userList.get(ctr).getUserId());
                           break;
                       case "event planner":
                           setPermission(userList.get(ctr).getUserId());
                           break;
                       default:
                           break;
                   }
                   
                   setCurrentPage("calendar");

                   FacesContext.getCurrentInstance().getExternalContext().redirect("calendar.xhtml");
                   
                   return;
               }
            }
            
        FacesContext.getCurrentInstance().getExternalContext().redirect("invalid.xhtml");
        
    }
    
    /**
     * Gets the User list
     * @return 
     */
    public List<Users> getUserList()
    {
        userList = users.findAll();
        return userList; 
    }
    
    /**
     * Gets the Employee list
     * @return 
     */
    public List<Employee> getEmployeeList()
    {
        employeeList = employees.findAll();
        return employeeList; 
    }
    
    /**
     * Gets the Locations list
     * @return 
     */
    public List<Locations> getLocationList()
    {
        locationList = locations.findAll();
        return locationList;
    }
    
    /**
     * Gets the Schedule list
     * @return 
     */
    public List<Schedule> getScheduleList()
    {
        scheduleList = schedules.findAll();
        return scheduleList;
    }
    
    /**
     * Gets the Event list
     * @return 
     */
    public List<Events> getEventList()
    {
        eventList = events.findAll();
        return eventList;
    }
    
    /**
     * Gets the Equipment list
     * @return 
     */
    public List<Equipment> getEquipmentList()
    {
        equipmentList = equipment.findAll();
        return equipmentList; 
    }
    
    /**
     * Gets the Event list based on days
     * @return 
     */
    public List<Events> getEventDayList()
    {
        return eventDayList; 
    }
    
    /**
     * Creates the shift for the Schedule
     * @param employeeName
     * @param shiftStartTime
     * @param shiftEndTime
     * @param eventId
     * @throws ParseException 
     */
    public void createShift(String employeeName, String shiftStartTime, String shiftEndTime, int eventId) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd");
        SimpleDateFormat sdf3 = new SimpleDateFormat("MM");

        Date newStartTime = (Date)sdf.parse(shiftStartTime);
        Date newEndTime = (Date)sdf.parse(shiftEndTime);
        Date newDay = (Date)sdf2.parse(addEventDay);
        Date newMonth = (Date)sdf3.parse(addEventMonth);
        
        Schedule schedule = new Schedule();
        
        schedule.setEmployeeName(employeeName);
        schedule.setStartTime(newStartTime);
        schedule.setEndTime(newEndTime);
        schedule.setScheduledDay(newDay);
        schedule.setScheduledMonth(newMonth);
        schedule.setEventId(eventId);
        
        schedules.create(schedule);
    }
    
    /**
     * Creates an Event for the Events
     * @param eventName
     * @param eventStartTime
     * @param eventEndTime
     * @param eventLocation
     * @param eventEquipment
     * @throws ParseException 
     */
    public void createEvent(String eventName, String eventStartTime, String eventEndTime, String eventLocation, String eventEquipment) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd");
        SimpleDateFormat sdf3 = new SimpleDateFormat("MM");

        Date newEventStartTime = (Date)sdf.parse(eventStartTime);
        Date newEventEndTime = (Date)sdf.parse(eventEndTime);
        Date newEventDay = (Date)sdf2.parse(addEventDay);
        Date newMonth = (Date)sdf3.parse(addEventMonth);
        
        Events event = new Events();

        event.setEventName(eventName);
        event.setEventStartTime(newEventStartTime);
        event.setEventEndTime(newEventEndTime);
        event.setEquipment(eventEquipment);
        event.setLocation(eventLocation);
        event.setEventDay(newEventDay);
        event.setEventMonth(newMonth);

        events.create(event);
    }
    
    /**
     * Edits a existing Event from Events
     * @param eventId
     * @param eventStartTime
     * @param eventEndTime
     * @param eventLocation
     * @param eventEquipment
     * @throws ParseException 
     */
    public void editEvent(int eventId, String eventStartTime, String eventEndTime, String eventLocation, String eventEquipment) throws ParseException
    {       
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd");

        Date newEventStartTime = (Date)sdf.parse(eventStartTime);
        Date newEventEndTime = (Date)sdf.parse(eventEndTime);
        Date newEventDay = (Date)sdf2.parse(addEventDay);
        
        Events event = events.getEventById(eventId);
  
        event.setEventStartTime(newEventStartTime);
        event.setEventEndTime(newEventEndTime);
        event.setEquipment(eventEquipment);
        event.setLocation(eventLocation);
        event.setEventDay(newEventDay);

        events.edit(event);
    }
    
    /**
     * Deletes an existing Event from Events
     * @param eventId 
     */
    public void cancelEvent(int eventId)
    {
        Events event = new Events();
        
        event.setEventId(eventId);
        
        events.remove(event);
    }
    
    /**
     * Retrieves a list of Events based on the day
     * @param day
     * @return
     * @throws ParseException 
     */
    public List<Events> getEventOnDay(String day) throws ParseException
    {
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd");
        
        Date newEventDay = (Date)sdf2.parse(day);
        
        eventDayList = events.getEventBasedOnDay(newEventDay);
        return eventDayList;
    }
    
    /**
     * Directs to the error page
     * @return 
     */
    public String goToError()
    {
        currentPage = "error";
        return currentPage;
    }
    
    /**
     * Directs to cancelEvent page
     * @return 
     */
    public String goToCancelEvent()
    {
        currentPage = "cancelEvent";
        return currentPage;
    }
    
    /**
     * Directs tot he calendar page
     * @return 
     */
    public String goToCalendar()
    {
        currentPage = "calendar";
        return currentPage;
    }
    
    /**
     * Moves to the editEvent page and sets the addEventDay and addEventMonth
     * @param day
     * @param month
     * @return 
     */
    public String moveToEditEvent(String day, String month)
    {
        this.addEventMonth = month;
        this.addEventDay = day;
        
        currentPage = "editEvent";
        return currentPage;
    }
    
    /**
     * Directs tot he schedule page
     * @return 
     */
    public String goToSchedule()
    {
        currentPage = "schedule";
        return currentPage;
    }
    
    /**
     * Directs to the printSchedule page
     * @return 
     */
    public String goToPrintSchedule()
    {
        currentPage = "printSchedule";
        return currentPage;
    }
    
    /**
     * Directs to the flyier page
     * @return 
     */
    public String goToPrintFlyer()
    {
        currentPage = "flyier";
        return currentPage;
    }
    
    /**
     * Logout the user and directs to the login page
     * @return 
     */
    public String goToLogout()
    {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        currentPage = "login";
        return currentPage;
    }
    /**
     * Moves to the addEvent page and sets the addEventDay and addEventMonth
     * @param day
     * @param month
     * @return 
     */
    public String moveToAddEvent(String day, String month)
    {
        this.addEventMonth = month;
        this.addEventDay = day;
        
        currentPage = "addEvent";
        return currentPage;
    }
    
    /**
     * Gets addEventDay
     * @return 
     */
    public String getAddEventDay()
    {
        return addEventDay;
    }
    
    /**
     * Gets addEventMonth
     * @return 
     */
    public String getAddEventMonth()
    {
        return addEventMonth;
    }
    
    /**
     * Moves to the addShift page and sets addEventDay and addEventMonth
     * @param day
     * @param month
     * @return 
     */
    public String moveToShift(String day, String month)
    {
        this.addEventMonth = month;
        this.addEventDay = day;
        
        currentPage = "addShift";
        return currentPage;
    }
    
    /**
     * Directs to the events page
     * @return 
     */
    public String goToEvents()
    {
        currentPage = "events";
        return currentPage;
    }
    
    /**
     * Directs to the invalid page
     * @return 
     */
    public String goToInvalid()
    {
        currentPage = "invalid";
        return currentPage;
    }
    
    /**
     * Sets the list of Users
     * @param newUserList 
     */
    public void setUserList(List<Users> newUserList) 
    {
        this.userList = newUserList;
    }
    
}

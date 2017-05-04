/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.DBAccess;
import Model.Events;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ray
 */
@WebServlet(name = "EventManager", urlPatterns = {"/EventManager"})
public class EventManager extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        
        /**
         * Receives parameter for switch statement from 
         * ()
         */
        String eventFunction = request.getParameter("eventFunction");
        
        /**
         * Grabs sessionBean DBAccess
         */
        HttpSession session = request.getSession();
            
        DBAccess db = (DBAccess) session.getAttribute("access");
        
        /**
         * Case 1: Create Event, receives parameters from eventDetails.jsp
         * and creates the event and a list of events, then redirects to availableEvents.jsp
         * 
         * Case 2: View Events, creates a list of events and then redirects to availableEvents.jsp
         * 
         * Default: redirects to error.jsp if an error occurs
         */
        switch(eventFunction)
        {
            case "1":
                String eventName = request.getParameter("eventName");
                String eventStartTime = request.getParameter("eventTime");
                String eventEndTime = request.getParameter("endEventTime");
                String eventEquip = request.getParameter("eventEquip");
                String eventLocation = request.getParameter("eventSite");
                String eventDay = request.getParameter("day");
                
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd");

                Date newEventStartTime = (Date)sdf.parse(eventStartTime);
                Date newEventEndTime = (Date)sdf.parse(eventEndTime);
                Date newEventDay = (Date)sdf2.parse(eventDay);
                
                db.getEntityManager().getTransaction().begin();

                Events event = new Events();

                event.setEventName(eventName);
                event.setEventStartTime(newEventStartTime);
                event.setEventEndTime(newEventEndTime);
                event.setEquipment(eventEquip);
                event.setLocation(eventLocation);
                event.setEventDay(newEventDay);

                db.getEntityManager().persist(event); 
                
                if(db.getEntityManager().getTransaction().isActive())
                {
                    db.getEntityManager().getTransaction().commit();
                }
                else
                {
                    db.getEntityManager().getTransaction().rollback();
                }
                
                List<Events> eventList = db.getEventList();
                
                request.setAttribute("processList", eventList);
                request.getRequestDispatcher("./avaliableEvents.jsp").forward(request, response);
                
            case "2":
                String selectedDay = request.getParameter("dayForEvent");
                
                SimpleDateFormat sdf3 = new SimpleDateFormat("dd");
                SimpleDateFormat sdf4 = new SimpleDateFormat("HH:mm");
                
                Date newSelectedDay = (Date)sdf3.parse(selectedDay);
                
                List<Events> viewEvents = db.getEventBasedOnDay(newSelectedDay);
                
                request.setAttribute("processList", viewEvents);
                request.getRequestDispatcher("./avaliableEvents.jsp").forward(request, response);
                
            default:
                request.getRequestDispatcher("./error.jsp").forward(request, response);    
        }
 
        

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(EventManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(EventManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

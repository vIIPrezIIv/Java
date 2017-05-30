/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.DBAccess;
import Model.Events;
import Model.Schedule;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
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
@WebServlet(name = "ScheduleManager", urlPatterns = {"/ScheduleManager"})
public class ScheduleManager extends HttpServlet {

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
         * Receives parameter from corresponding JSP pages for switch
         * ()
         */
        String function = request.getParameter("function");
        
        /**
         * Grabs sessionBean for DBAccess
         */
        HttpSession session = request.getSession();

        DBAccess db = (DBAccess) session.getAttribute("access");
        
        /**
         * Case 1: Creates the Schedule, taking in parameters from shift.jsp
         * then loads the schedule and redirects to schedule.jsp
         * 
         * Case 2: Views the schedule and redirects to schedule.jsp
         * 
         * Default: Loads error.jsp if no case is triggered
         *
         */
        switch(function)
        {
            case "1":
                String startTime = request.getParameter("startTime");
                String endTime = request.getParameter("endTime");
                String emp = request.getParameter("employee");
                String day = request.getParameter("day");

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

                Date newStartTime = (Date)sdf.parse(startTime);
                Date newEndTime = (Date)sdf.parse(endTime);
                
                db.getEntityManager().getTransaction().begin();

                Schedule schedule = new Schedule();

                schedule.setEmployeeName(emp);
                schedule.setStartTime(newStartTime);
                schedule.setEndTime(newEndTime);
                schedule.setScheduledDay(day);

                db.getEntityManager().persist(schedule); 

                if(db.getEntityManager().getTransaction().isActive())
                {
                    db.getEntityManager().getTransaction().commit();
                }
                else
                {
                    db.getEntityManager().getTransaction().rollback();
                }

                List<Schedule> scheduleList = db.getScheduleList();

                request.setAttribute("schList", scheduleList);
                request.getRequestDispatcher("./schedule.jsp").forward(request, response);
                
            case "2":
                List<Schedule> viewSchedule = db.getScheduleList();

                request.setAttribute("schList", viewSchedule);
                request.getRequestDispatcher("./schedule.jsp").forward(request, response);
            
            /*case "3":
                String selectedEmployee = request.getParameter("selectedEmployee");
                String selectedEvent = request.getParameter("selectedEvent");
                Events event = (Events) request.getParameter("selectedEvent");
                //int newSelectedEvent = Integer.parseInt(selectedEvent);
                int newSelectedEmployee = Integer.parseInt(selectedEmployee);
                
                db.getEntityManager().getTransaction().begin();
                
                
                
                Schedule updateSchedule = new Schedule();
                Events event_2 = db.getEventId(selectedEvent);
                updateSchedule.setEventId(event_2);
                
                
                
                
                db.getEntityManager().merge(updateSchedule); 

                if(db.getEntityManager().getTransaction().isActive())
                {
                    db.getEntityManager().getTransaction().commit();
                }
                else
                {
                    db.getEntityManager().getTransaction().rollback();
                }*/
                
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
            Logger.getLogger(ScheduleManager.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ScheduleManager.class.getName()).log(Level.SEVERE, null, ex);
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

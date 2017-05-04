/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Model.Employee;
import Model.Event;
import Model.EventSch;
import Model.EventScheduleBean;
import Model.ScheduleList;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXB;

/**
 *
 * @author Ray
 */
@WebServlet(name = "EventSchedule", urlPatterns = {"/EventSchedule"})
public class EventSchedule extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
             /**
             * Grabs parameters from shiftEvents.jsp.
             * Variable declarations
             */
            String selectedEvent = request.getParameter("selEvent");
            String emp = request.getParameter("employee");
            
            EventScheduleBean list = new EventScheduleBean();
            EventSch empEvent = new EventSch();
            
            File newFile = new File("eventSchedule.xml");
            
            /**
             * Creates the XML file if not made
             */
            if(!newFile.exists())
            {
                JAXB.marshal(list, newFile);
            }
            
            /**
             * Takes the input for the XML file and adds it to the new data
             */
            File infile = new File("eventSchedule.xml");
            list =  JAXB.unmarshal(infile, EventScheduleBean.class);

            empEvent.setName(emp);
            empEvent.setEventName(selectedEvent);
            list.add(empEvent);
            
            /**
             * Rewrites the XML file
             */
            File file = new File("eventSchedule.xml");
            JAXB.marshal(list, file);
            
            /**
             * Requests sent to the JSP page
             */
            request.getRequestDispatcher("./ProcessEventSchedule").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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

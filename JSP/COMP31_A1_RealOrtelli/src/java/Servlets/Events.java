/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Model.EmployeeList;
import Model.Event;
import Model.EventList;
import static com.sun.org.apache.xerces.internal.util.FeatureState.is;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXB;
import java.util.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;


/**
 *
 * @author Ray
 */
@WebServlet(name = "Events", urlPatterns = {"/Events"})
public class Events extends HttpServlet {

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
        //try (PrintWriter out = response.getWriter()) {
        
            /**
             * Grabs parameters from eventDetails.jsp.
             * Variable declarations
             */
            String eventName = request.getParameter("eventName");
            String eventTime = request.getParameter("eventTime");
            String endEventTime = request.getParameter("endEventTime");
            String eventEquip = request.getParameter("eventEquip");
            String eventSite = request.getParameter("eventSite");
            
            EventList list = new EventList();
            
            File newFile = new File("eventList.xml");
            
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
            File infile = new File("eventList.xml");
            list =  JAXB.unmarshal(infile, EventList.class);
            
            Event event = new Event();
            event.setEventName(eventName);
            event.setEventTime(eventTime);
            event.setEndEventTime(endEventTime);
            event.setEventEquip(eventEquip);
            event.setEventSite(eventSite);
            list.add(event);

            /**
             * Rewrites the XML file
             */
            File file = new File("eventList.xml");
            JAXB.marshal(list, file);
            
            /**
             * Requests sent to the JSP page
             */
            request.setAttribute("eventList", list);
            request.getRequestDispatcher("./ProcessEvents").forward(request, response);
        //}
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

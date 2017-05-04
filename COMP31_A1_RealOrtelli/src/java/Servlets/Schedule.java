/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Model.Employee;
import Model.ScheduleList;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "Schedule", urlPatterns = {"/Schedule"})
public class Schedule extends HttpServlet {

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
             * Grabs parameters from shift.jsp.
             * Variable declarations
             */
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            String emp = request.getParameter("employee");
            
            ScheduleList list = new ScheduleList();
            Employee employee = new Employee();
            
            File newFile = new File("schedule.xml");
            
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
            File infile = new File("schedule.xml");
            list =  JAXB.unmarshal(infile, ScheduleList.class);
          
            employee.setName(emp);
            employee.setStartTime(startTime);
            employee.setEndTime(endTime);
            list.add(employee);
            
            /**
             * Rewrites the XML file
             */
            File file = new File("schedule.xml");
            JAXB.marshal(list, file);
            
            /**
            * Requests sent to the JSP page
            */
            request.getRequestDispatcher("./ProcessSchedule").forward(request, response);
            
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

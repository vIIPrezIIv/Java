/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Model.Employee;
import Model.EmployeeList;
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
@WebServlet(name = "SelectedDay", urlPatterns = {"/SelectedDay"})
public class SelectedDay extends HttpServlet {

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
             * Grabs parameters from calendar.jsp.
             * Variable declarations
             */
            String day = request.getParameter("day");
            String month = request.getParameter("month");
            String user = request.getParameter("user");
            String message = month + "-" + day;
            EmployeeList list = new EmployeeList();
            
            File newFile = new File("employeeList.xml");
            
            /**
             * Creates and populates the XML files if not made
             */
            if(!newFile.exists())
            {
                String[] insertEmp = {"Real Ortelli", "Mike Oag", "Graham Berry", "Skyler Something Irish"};
                
                for(int ctr = 0; ctr < 4; ctr++)
                {
                   Employee emp = new Employee();
                   emp.setName(insertEmp[ctr]);
                   list.add(emp);
                }
                
                JAXB.marshal(list, newFile);
            }
            
            /**
             * Takes the input for the XML file and adds it to the new data
             */
            File infile = new File("employeeList.xml");
            list =  JAXB.unmarshal(infile, EmployeeList.class);
            
            /**
            * Requests sent to the JSP page
            */
            request.setAttribute("user", user);
            request.setAttribute("empList", list);
            request.setAttribute("dayAttribute", message);
            request.getRequestDispatcher("./shift.jsp").forward(request, response);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Model.EmployeeList;
import Model.Equip;
import Model.EquipmentList;
import Model.EventSites;
import Model.Sites;
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
@WebServlet(name = "Days", urlPatterns = {"/Days"})
public class Days extends HttpServlet {

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
            String message = " ";
            
            message = day + ", " + month;
            
            EventSites list = new EventSites();
            EquipmentList list2 = new EquipmentList();
            
            File newFile = new File("eventSites.xml");
            File newFile2 = new File("equipmentList.xml");
            
            /**
             * Creates and populates XML file if not made
             */
            if(!newFile.exists())
            {
                String[] insertSite = {"Location A", "Location B", "Location C", "Location D"};
                
                for(int ctr = 0; ctr < 4; ctr++)
                {
                   Sites site = new Sites();
                   site.setName(insertSite[ctr]);
                   list.add(site);
                }
                
                JAXB.marshal(list, newFile);
            }
            
            /**
             * Creates and populates XML file if not made
             */
            if(!newFile2.exists())
            {
                String[] insertEquip = {"Tractor", "Generator", "Fence", "Speakers", "Tables"};
                
                for(int ctr = 0; ctr < 5; ctr++)
                {
                   Equip equip = new Equip();
                   equip.setName(insertEquip[ctr]);
                   list2.add(equip);
                }
                
                JAXB.marshal(list2, newFile2);
            }
            
            /**
             * Loads the XML files into their respected ArrayLists
             */
            File infile1 = new File("eventSites.xml");
            list =  JAXB.unmarshal(infile1, EventSites.class);
            
            File infile2 = new File("equipmentList.xml");
            list2 =  JAXB.unmarshal(infile2, EquipmentList.class);
            
            /**
             * Requests sent to the JSP page
             */
            request.setAttribute("siteList", list);
            request.setAttribute("equipList", list2);
            request.setAttribute("dayAttribute", message);
            request.getRequestDispatcher("./eventDetails.jsp").forward(request, response);
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

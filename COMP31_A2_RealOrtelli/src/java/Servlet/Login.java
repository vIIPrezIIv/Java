/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.DBAccess;
import Model.Permissions;
import Model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
        
            /**
             * Grabs parameters from login.jsp.
             * Variable declarations
             */
            String user = request.getParameter("user");
            String pwd = request.getParameter("pwd");
            String message = " ";
            
            /**
             * Declare sessionBeans for DBAccess and Permissions class
             */
            HttpSession session = request.getSession();
            
            Permissions validUsers = new Permissions();
            session.setAttribute("permission", validUsers);
                
            Permissions permission = (Permissions) session.getAttribute("permission");
            
            DBAccess db = (DBAccess) session.getAttribute("access");
            
            /**
             * Makes a list and iterates through it to find valid login, then goes to calender.jsp.
             * If it fails it goes to a invalid.jsp
             */
            List<Users> userList = db.getUserList();
            
            for(int ctr = 0; ctr < userList.size(); ctr++)
            {  
               if(user.equals(userList.get(ctr).getLoginName()) && pwd.equals(userList.get(ctr).getPassword()))
               {
                   message = user;

                   switch(user)
                   {
                       case "manager":
                           request.setAttribute("manager", user);
                           request.setAttribute("hourAttribute", message);
                           permission.setPermission(userList.get(ctr).getUserId());
                           break;
                       case "event planner":
                           request.setAttribute("eventPlanner", user);
                           request.setAttribute("eventAttribute", message);
                           permission.setPermission(userList.get(ctr).getUserId());
                           break;
                       default:
                           break;
                   }

                   request.getRequestDispatcher("calendar.jsp").forward(request, response);
               }
            }
            
            request.getRequestDispatcher("invalid.jsp").forward(request, response);
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

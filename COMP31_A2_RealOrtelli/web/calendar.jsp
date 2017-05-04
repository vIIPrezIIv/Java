<%-- 
    Document   : calendar
    Created on : 31-Oct-2016, 1:24:39 PM
    Author     : Ray
--%>

<%@page import="Model.Permissions"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calendar</title>
    </head>
    <body>
        <%
            String userName = request.getParameter("user");
            session.setAttribute("loggedUser", userName);
           
            String name = (String)session.getAttribute("loggedUser");
            
            HttpSession sessionB = request.getSession();
            
            Permissions permission = (Permissions) sessionB.getAttribute("permission");
            
            out.println("<h1>");
            out.println(name + " Logged On");
            out.println("</h1>");
        %>
        <h2>Calendar</h2>
        <%
            if(permission.getPermission() == 1)
            {
                out.println("<form action='Shift' method='POST'>");
            }
            else
            {
                out.println("<form action='AddEvent' method='POST'>"); 
            }
        %>
            <label>Input Day (Ex: 1-31)</label>
            <input type="number" name="day" min="1" max="31" required value="12"/>
            </br>
            <label>Input Month</label>
            <input type="month" name="month" required value="2016-11"/>
            </br>
            <%
                    if(permission.getPermission() == 1)    
                    {
                        out.println("<input type='submit' value='Go To Shift'/>");
                    }

                    if(permission.getPermission() == 2)    
                    {
                        out.println("<input type='submit' value='Add Event'/>");
                    }
                    
                out.println("</form>");
            %> 
        </br>    
        <form action="EventManager" method="POST">
            <input type="hidden" name="eventFunction" value="2">
            <label>Input Event Day (Ex: 1-31)</label>
            <input type="number" name="dayForEvent" min="1" max="31" required value="12"/>
            </br>
            <input type="submit" value="Go To Available Events"/>
        </form>
        </br>
        <%
                if(permission.getPermission() == 1)
                {
                    out.println("<form action='ScheduleManager' method='POST'>");
                    out.println("<input type='hidden' name='function' value='2'>");
                    out.println("<input type='submit' value='View Schedule'/>");
                    out.println("</form>");
                } 
        %>
    </body>
</html>


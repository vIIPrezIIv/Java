<%-- 
    Document   : calendar
    Created on : 8-Oct-2016, 2:45:20 PM
    Author     : Ray
--%>

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
            
            out.println("<h1>");
            out.println(name + " Logged On");
            out.println("</h1>");
        %>
        <h2>Calendar</h2>
        <%
            if(name == null)
            {
                
            }
            else
            {
                if(name.equals("manager"))
                {
                    out.println("<form action='SelectedDay' method='POST'>");
                }
                else
                {
                    out.println("<form action='Days' method='POST'>"); 
                }
               
            }
        %>
            <label>Input Day (Ex: 1-31)</label>
            <input type="number" name="day" min="1" max="31" required value="12"/>
            </br>
            <label>Input Month (Ex: December)</label>
            <input type="month" name="month" required value="December"/>
            </br>
            <%
                if(name == null)
                {
                                     
                }
                else
                {
                    if(name.equals("manager"))
                    {
                        out.println("<input type='submit' value='Go To Shift'/>");
                    }
                    
                    if(name.equals("event planner"))
                    {
                        out.println("<input type='submit' value='Add Event Details'/>");
                    }
                }
                out.println("</form>");
            %> 
        <form action="ProcessEvents" method="POST">
            <input type="submit" value="Go To Available Events"/>
        </form>
    </body>
</html>

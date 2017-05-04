<%-- 
    Document   : shiftEvent
    Created on : 9-Oct-2016, 3:26:34 PM
    Author     : Ray
--%>

<%@page import="java.util.List"%>
<%@page import="Model.Employee"%>
<%@page import="Model.EmployeeList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Event Shift</title>
    </head>
    <body>
    <form action="EventSchedule">
        <input type="hidden" name="selEvent" value="<%= request.getParameter("selectedEvent") %>">
        <select name="employee">
                <% 
                    
                if(request.getAttribute("empList") == null)
                {
                    out.println("request is null");
                }
                
                EmployeeList list = (EmployeeList) request.getAttribute("empList");
                List<Employee> emps = list.getList();
                
                if(emps == null)
                {
                    out.println("Emps is null");
                }

                for(int ctr = 0; ctr < emps.size(); ctr++)
                {
                    out.println("<option>");
                    out.println(emps.get(ctr).toString());
                    out.println("</option>");
                }
                
                %>
        </select>
        <p>
            Selected Event: <%= request.getAttribute("selectedEvent") %>
        </p>
        <input type="submit" value="Submit"/> 
    </form>       
    </body>
</html>

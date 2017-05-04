<%-- 
    Document   : selectedDay
    Created on : 27-Sep-2016, 12:58:31 PM
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
        <title>Shift</title>
    </head>
    <body>
        <h1>
            <%= request.getAttribute("dayAttribute") %>
        </h1>
        <form action="Schedule" method="POST">
            <label>Start Time (Ex: 3:30)</label>
            <input type="time" name="startTime" required value="3:45"/>
            </br>
            <label>End Time (Ex: 3:30)</label>
            <input type="time" name="endTime" required value="4:00"/>
            </br>
            <label>Employee List</label>
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
            </br>
            <input type="submit" value="Submit"/> 
        </form>
    </body>
</html>

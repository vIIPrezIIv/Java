<%-- 
    Document   : schedule
    Created on : 5-Oct-2016, 3:54:56 PM
    Author     : Ray
--%>

<%@page import="java.util.List"%>
<%@page import="Model.Employee"%>
<%@page import="Model.ScheduleList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Schedule</title>
    </head>
    <body>
        <%
            String name = (String)session.getAttribute("loggedUser"); 
        %> 
        <select>
            <%
                if(request.getAttribute("schList") == null)
                {
                    out.println("request is null");
                }
                
                ScheduleList list = (ScheduleList) request.getAttribute("schList");
                
                if(list == null)
                {
                    out.println("sch is null");
                }
                
                for(int ctr = 0; ctr < list.size(); ctr++)
                {
                    out.println("<option>");
                    out.println(list.get(ctr).getName());
                    out.println(" : ");
                    out.println(list.get(ctr).getStartTime());
                    out.println(" : ");
                    out.println(list.get(ctr).getEndTime());
                    out.println("</option>");
                }
                
            %>
        </select>
        <form action="calendar.jsp" method="POST">
            <input type="hidden" name="user" value="<%= name %>">
            <input type="submit" value="Add Another Shift"/> 
        </form>
        </br>
        <form action="print.jsp" method="POST">
            <input type="submit" value="Print"/>
        </form>
        </br>
        <form action="login.jsp" method="post">
            <input type="submit" value="Logout"/> 
        </form>
    </body>
</html>

<%-- 
    Document   : schedule
    Created on : 18-Nov-2016, 6:44:58 PM
    Author     : Ray
--%>

<%@page import="java.util.List"%>
<%@page import="Model.Schedule"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Schedule</title>
    </head>
    <body>
        <%
            String name = (String)session.getAttribute("loggedUser");
            
            List<Schedule> event = (List<Schedule>) request.getAttribute("schList");
            
            SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
            sdf.setTimeZone(TimeZone.getTimeZone("EST"));

            int ctr = 0;
        %> 
        <select>
            <c:forEach var="schedule" items="${schList}">
                <% 
                    Date eventStartTimeConvert = (Date) event.get(ctr).getStartTime();
                    Date eventEndTimeConvert = (Date) event.get(ctr).getEndTime();
                    
                    String formattedStartTime = sdf.format(eventStartTimeConvert);
                    String formattedEndTime = sdf.format(eventEndTimeConvert);
                    
                    ctr = ctr + 1;
                %>
                <option>
                    ${schedule.employeeName} :
                    <%= formattedStartTime %> :
                    <%= formattedEndTime %> :
                    ${schedule.scheduledDay} Day :
                </option>
            </c:forEach>   
        </select>
        </br></br>
        <form action="calendar.jsp" method="POST">
            <input type="hidden" name="user" value="<%= name %>">
            <input type="submit" value="Add Shift"/> 
        </form>
        </br>
        <form action="print.jsp" method="POST">
            <input type="submit" value="Print"/>
        </form>
        </br>
        <form action="Logout" method="post">
            <input type="submit" value="Logout"/> 
        </form>
    </body>
</html>

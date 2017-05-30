<%-- 
    Document   : avaliableEvents
    Created on : 9-Oct-2016, 11:41:31 AM
    Author     : Ray
--%>

<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Vector"%>
<%@page import="Model.Events"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Model.Permissions"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Events</title>
    </head>
    <body>
        <%
            HttpSession sessionB = request.getSession();
            
            Permissions permission = (Permissions) sessionB.getAttribute("permission");
            
            List<Events> event = (List<Events>) request.getAttribute("processList");
            
            SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd");
            sdf.setTimeZone(TimeZone.getTimeZone("EST"));

            int ctr = 0;
        %>    
        <h1>Events</h1>
        <form action="EventEmployees" method="POST">
        <select name="selectedEvent">
            <c:forEach begin="0" end="${processList.size()}" var="event" items="${processList}">
                <% 
                    Date eventStartTimeConvert = (Date) event.get(ctr).getEventStartTime();
                    Date eventEndTimeConvert = (Date) event.get(ctr).getEventEndTime();
                    Date eventDayConvert = (Date) event.get(ctr).getEventDay();
                    
                    String formattedStartTime = sdf.format(eventStartTimeConvert);
                    String formattedEndTime = sdf.format(eventEndTimeConvert);
                    String formattedDay = sdf2.format(eventDayConvert);
                    
                    ctr = ctr + 1;
                %>
                <option>
                    ${event.eventName} :
                    <%= formattedStartTime %> :
                    <%= formattedEndTime %> :
                    ${event.location} :
                    ${event.equipment} :
                    <%= formattedDay %> Day : 
                </option>
            </c:forEach>    
        </select>
        </br></br>
        </form>
        <%        
                if(permission.getPermission() == 2)
                {
                    out.println("<form action='flyier.jsp' method='POST'>");
                    out.println("<input type='submit' value='Print Flyier'/>"); 
                    out.println("</form>");
                }
        %>
        </br>
        <form action="Logout" method="post">
            <input type="submit" value="Logout"/> 
        </form>
    </body>
</html>

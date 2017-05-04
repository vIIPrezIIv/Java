<%-- 
    Document   : eventDetails
    Created on : 19-Nov-2016, 12:14:20 PM
    Author     : Ray
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Event Details</title>
    </head>
    <body>
        <form action="EventManager" method="POST">
            <input type="hidden" name="eventFunction" value="1">
            <input type="hidden" name="day" value="<%= request.getParameter("day") %>">
            <label>Event Name</label>
            <input type="text" name="eventName" required value="Super"/>
            </br>
            <label>Event Start Time</label>
            <input type="time" name="eventTime" required value="12:30"/>
            </br>
            <label>Event End Time</label>
            <input type="time" name="endEventTime" required value="01:00"/>
            </br>
            <label>Event Location</label>
            <select name="eventSite">
                <c:forEach var="location" items="${siteList}">
                    <option>
                        ${location.locationName}
                    </option>
                </c:forEach>  
            </select>    
            </br>
            <label>Event Equipment</label>
            <select name="eventEquip">
                <c:forEach var="equip" items="${equipList}">
                    <option>
                        ${equip.equipmentName}
                    </option>
                </c:forEach>    
            </select>
            </br>
            <input type="submit" value="Create Event"/> 
         </form>    
    </body>
</html>

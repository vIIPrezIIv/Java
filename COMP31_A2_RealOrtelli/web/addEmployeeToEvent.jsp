<%-- 
    Document   : addEmployeeToEvent
    Created on : 19-Nov-2016, 4:02:10 PM
    Author     : Ray
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Employee To Event</title>
    </head>
    <body>  
        <form action="ScheduleManager" method="POST">
            <select name="selectedEmployee">
                <c:forEach var="event" items="${eventList}">
                    <option>
                        ${event.eventName}
                    </option>
                </c:forEach>    
            </select>
            </br>
            <select name="selectedEvent">
                <c:forEach var="employee" items="${employeeList}">
                    <option>
                        ${employee.employeeName}
                    </option>
                </c:forEach>    
            </select>
            <input type='submit' value='Schedule To Event'/>
        </form>
    </body>
</html>

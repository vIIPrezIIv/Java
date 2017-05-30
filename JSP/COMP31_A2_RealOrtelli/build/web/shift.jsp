<%-- 
    Document   : shift
    Created on : 18-Nov-2016, 6:28:16 PM
    Author     : Ray
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <%
                String day = (String)request.getAttribute("day");
            %>
        <form action="ScheduleManager" method="POST">
            <input type="hidden" name="day" value="<%= day %>">
            <input type="hidden" name="function" value="1">
            <label>Start Time</label>
            <input type="time" name="startTime" required value="03:45">
            </br>
            <label>End Time</label>
            <input type="time" name="endTime" required value="04:45"/>
            </br>
            <label>Employee List</label>
            <select name="employee">
                <c:forEach var="employee" items="${empList}">
                    <option>
                        ${employee.employeeName}
                    </option>
                </c:forEach>
            </select>
            </br>
            <input type="submit" value="Submit"/> 
        </form>
    </body>
</html>

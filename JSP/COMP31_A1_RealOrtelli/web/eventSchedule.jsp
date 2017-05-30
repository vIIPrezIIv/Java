<%-- 
    Document   : eventSchedule
    Created on : 9-Oct-2016, 4:27:20 PM
    Author     : Ray
--%>

<%@page import="Model.EventScheduleBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Event Schedule</title>
    </head>
    <body>
        <h1>Event Schedule</h1>
        <table>
            <%
                if(request.getAttribute("eventSchedule") == null)
                {
                    out.println("request is null");
                }
                EventScheduleBean list = (EventScheduleBean) request.getAttribute("eventSchedule");
                
                if(list == null)
                {
                    out.println("eventSchedule is null");
                }
                
                out.println("<tr>");
                out.println("<th>");
                out.println("<tr>");
                out.println("Events");
                out.println("</th>");
                out.println("</tr>");
                
                for(int ctr = 0; ctr < list.size(); ctr++)
                {
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(list.get(ctr).getName());
                    out.println(" : ");
                    out.println(list.get(ctr).getEventName());
                    out.println("</td>");
                    out.println("</tr>");
                }
                
            %>    
        </table>    
        <form action="print.jsp" method="post">
            <input type="submit" value="Print"/> 
        </form>
        </br>
        <form action="login.jsp" method="post">
            <input type="submit" value="Logout"/> 
        </form>
    </body>
</html>

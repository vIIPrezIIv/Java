<%-- 
    Document   : avaliableEvents
    Created on : 9-Oct-2016, 11:41:31 AM
    Author     : Ray
--%>

<%@page import="java.util.List"%>
<%@page import="Servlets.Events"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.EventList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Events</title>
    </head>
    <body>
        <%
            String name = (String)session.getAttribute("loggedUser"); 
        %>    
        <h1>Events</h1>
        <form action="EventEmployees" method="POST">
            <%
                
                        EventList list = (EventList) request.getAttribute("processList");

                        if(list.equals(null))
                        {
                            out.println("<h1>No Available Events</h1>");
                        }
                        else
                        {
                            out.println("<select name='selectedEvent'>");
                            
                            for(int ctr = 0; ctr < list.size(); ctr++)
                            {
                                out.println("<option>");
                                out.println(list.get(ctr).getEventName());
                                out.println(" : ");
                                out.println(list.get(ctr).getEventTime());
                                out.println(" : ");
                                out.println(list.get(ctr).getEndEventTime());
                                out.println(" : ");
                                out.println(list.get(ctr).getEventSite());
                                out.println(" : ");
                                out.println(list.get(ctr).getEventEquip());
                                out.println("</option>");
                            }
                            
                            out.println("</select>");
                        }
            %>
        </br>
        <%
            if(name == null)
            {
                
            }
            else
            {
                if(name.equals("manager")) 
                {
                    out.println("<input type='submit' value='Add Employee to Event'/>");
                }
            }
          
        %>    
        </form>
        <%        
            if(name == null)
            {
                
            }
            else
            {
                
                if(name.equals("event planner")) 
                {
                    out.println("<form action='flyier.jsp' method='POST'>");
                    out.println("<input type='submit' value='Print Flyier'/>"); 
                    out.println("</form>");
                }
            }
 
        %>
        <form action="login.jsp" method="post">
            <input type="submit" value="Logout"/> 
        </form>
    </body>
</html>

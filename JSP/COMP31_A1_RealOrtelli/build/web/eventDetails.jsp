<%-- 
    Document   : eventDetails
    Created on : 9-Oct-2016, 12:18:38 PM
    Author     : Ray
--%>

<%@page import="Model.Equip"%>
<%@page import="Model.EquipmentList"%>
<%@page import="java.util.List"%>
<%@page import="Model.Sites"%>
<%@page import="Model.EventSites"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Event Details</title>
    </head>
    <body>
         <form action="Events" method="POST">
            <label>Event Name</label>
            <input type="text" name="eventName" required value="Test"/>
            </br>
            <label>Event Start Time (Ex: 3:30)</label>
            <input type="time" name="eventTime" required value="3:30"/>
            </br>
            <label>Event End Time (Ex: 3:30)</label>
            <input type="time" name="endEventTime" required value="4:30"/>
            </br>
            <label>Event Site (Location)</label>
            <select name="eventSite">
                <% 
                    
                if(request.getAttribute("siteList") == null)
                {
                    out.println("request is null");
                }
                
                EventSites list = (EventSites) request.getAttribute("siteList");
                //List<Sites> sites = list.getEventSites();
                
                if(list == null)
                {
                    out.println("sites is null");
                }
            
                for(int ctr = 0; ctr < list.size(); ctr++)
                {
                    out.println("<option>");
                    out.println(list.get(ctr).toString());
                    out.println("</option>");
                }
                %>
            </select>    
            </br>
            <label>Event Equipment</label>
            <select name="eventEquip">
                <% 
                
                if(request.getAttribute("equipList") == null)
                {
                    out.println("request is null");
                }
                
                EquipmentList list2 = (EquipmentList) request.getAttribute("equipList");
                //List<Equip> equip = list2.getEventEquip();
                
                if(list2 == null)
                {
                    out.println("Equip is null");
                }
            
                for(int ctr = 0; ctr < list2.size(); ctr++)
                {
                    out.println("<option>");
                    out.println(list2.get(ctr).toString());
                    out.println("</option>");
                }
                %>
            </select>
            </br>
            <input type="submit" value="Process Event"/> 
         </form>    
    </body>
</html>

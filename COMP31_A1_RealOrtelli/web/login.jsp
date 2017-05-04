<%-- 
    Document   : login.jsp
    Created on : 10-Oct-2016, 4:22:02 PM
    Author     : Ray
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <% session.invalidate(); %>
    <body>
        <form action="Login" method="post">
            <label for='user'>User Name</label>
            <input type="text" name="user" required value="manager"/>
            </br>
            <label for='pwd'>Password</label>
            <input type="password" name="pwd" required value="pwd1"/>
            </br>
            <input type="submit" value="Submit"/>
        </form>
        <p>
            User: manager PWD: pwd1
        </p>
        <p>
             User: event planner PWD: pwd2
        </p>
    </body>
</html>
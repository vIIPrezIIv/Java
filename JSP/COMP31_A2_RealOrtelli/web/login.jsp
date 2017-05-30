<%-- 
    Document   : Index
    Created on : Oct 24, 2016, 1:22:45 PM
    Author     : rortelli27
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
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
        <pre>
            Manager Login: 
                User Name: manager
                Password: pwd1

            Event Planner Login:
                User Name: event planner
                Password: pwd2
        </pre>
    </body>
</html>

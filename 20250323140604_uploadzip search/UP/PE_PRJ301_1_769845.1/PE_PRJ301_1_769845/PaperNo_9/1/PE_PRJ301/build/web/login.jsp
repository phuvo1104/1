<%-- 
    Document   : login
    Created on : Mar 11, 2022, 9:02:11 PM
    Author     : hd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <!--your code here-->
                <% String error =  (String) request.getAttribute("error"); %>
        <% if (error != null) { %>
            <h3> <%= error %> </h3>
        <% } %>
        <form action="LoginController" name="" method="POST">
            <input name="user" type="text">
            <input name="password" type="password">
            <input value="Login" type="submit">
        </form>
        
    </body>
    
</html>


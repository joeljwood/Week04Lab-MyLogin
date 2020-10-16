<%-- 
    Document   : login
    Created on : Oct 11, 2020, 3:57:19 PM
    Author     : 850223
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <form method="post" action="login">
            <label>Username:</label>
            <input type="text" name="username" value="${username}">
            <br>
            <label>Password:</label>
            <input type="text" name="password" value="${password}">
            <br>
            <p>${message}</p>
            <input type="submit" name="login" value="login">
        </form>
    </body>
</html>

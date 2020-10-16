<%-- 
    Document   : home
    Created on : Oct 11, 2020, 3:54:51 PM
    Author     : Joel Wood
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <br>
        <h2>Hello ${username}</h2>
        <br>
        <form action="login" method="get">
            <a href="/login">Logout</a>
            <input type="hidden" name="action" value="logout">   
        </form>
    </body>
</html>

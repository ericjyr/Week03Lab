<%-- 
    Document   : agecalculator
    Created on : 13-Jan-2023, 11:41:50 PM
    Author     : ericr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculator - Age</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        <form method="post" action="age">
            Enter your age: <input type="text" name="user-age" min="0">
            <button type="submit">Age next birthday</button>
            <a href="">Arithmetic Calculator</a>
        </form>
    </body>
</html>

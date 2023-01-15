<%-- 
    Document   : arithmeticcalculator
    Created on : 14-Jan-2023, 2:47:54 PM
    Author     : ericr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculator - Arithmetic</title>
    </head>
    
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="post" action="arithmetic">
            First: <input type="text" name="firstnumber" value="${firstnumber}"min="0"><br>
            Second: <input type="text" name="secondnumber" value="${secondnumber}"min="0"><br>
            <input type="submit" name="submit" value="+">
            <input type="submit" name="submit" value="-">
            <input type="submit" name="submit" value="*">
            <input type="submit" name="submit" value="%"><br>
        </form>
        <p>Result: ${message}</p>
        <a href="age">Age Calculator</a>
        
        <style>
            p {margin-bottom: 0px;}
        </style> 
</body>
    </body>
</html>

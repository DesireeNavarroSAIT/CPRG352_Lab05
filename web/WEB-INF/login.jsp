<%-- 
    Document   : login
    Created on : 15-Jun-2021, 4:45:19 PM
    Author     : m-navarro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>

        <form method="get" action="login">

            <label>Username: </label>
            <input type="text" name="username" ><br>


            <label>Password: </label>
            <input type="text" name="password" ><br>
            
            <p>${"errorMsg"}</p>

            <input type="submit" value="Login">
        </form>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        
        <style>
            .required:after{
                content:"*";
                color: red;
            }
        </style>
    </head>
    <body>
        <h1>Login</h1>

        <form method="post">

            <label class="required" >Username: </label>
            <input type="text" name="username" value=${username} ><br>


            <label class="required" >Password: </label>
            <input type="text" name="password" value=${password} ><br>


            <input type="submit" name="login" value="Log in">
        </form>
        <p>${warning}</p>  

    </body>
</html>
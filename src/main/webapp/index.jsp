<%-- 
    Document   : login
    Created on : Mar 6, 2019, 9:27:37 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de Sesión</title>
    </head>
    <body>
        <h1>Iniciar Sesion</h1>
        <hr>
        <form action="LogIn" method="post">
            <label for="usuario">Usuario: </label>
            <input type="text" name="usuario"><br><hr>
            <label for="contrasena">Contraseña: </label>  
            <input type="password" name="contrasena"><hr>
            <button type="submit">Entrar</button>
        </form>
        <hr>
    </body>
</html>


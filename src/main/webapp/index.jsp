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
        <link rel="stylesheet" href="css/bulma.css">
    </head>
    <body >
        <div class="container" style="width:40%; margin-left:auto;margin-right:auto; margin-top: auto">
            <h1 class="title" style="margin-top: 100px;">Iniciar Sesion</h1>
            <form action="LogIn" method="post">
                
                <input class="input is-primary" placeholder="Usuario..." type="text" name="usuario"><br><hr>
                
                <input class="input is-primary" placeholder="Contraseña..." type="password" name="contrasena"><hr>
                <button class="button is-primary " type="submit">Entrar</button>
            </form>
        </div>
        <hr>
    </body>
</html>


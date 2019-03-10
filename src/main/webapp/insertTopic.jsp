<%-- 
    Document   : insertTopic
    Created on : Mar 9, 2019, 8:20:45 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bulma.css">
    </head>
    <body>
        <p class="button" onclick="location.href='Books'">Volver</p>
        <div class="container" style="width: 50%">
        <h1 class="title">Ingresar tema!</h1>
        <form action="AddTopic" method="post">
            <label for="topic">Tema</label>
            <input class="input" type="text" name="topic">
            <label for="topicDesc">Descripción</label>
            <input class="input" type="text" name="topicDesc">
            
            <button class="button is-primary" style="margin-top: 10px">Guardar</button>
        </form>
        </div>
    </body>
</html>

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
        <link rel="stylesheet" href="../css/bulma.css">
        <style>
            .menu-list {
                      position: fixed;
                      width: 100%;
                      background:#4d4d4d;
                      top:0;
                      padding: 10px;
                      box-sizing: border-box;
                       z-index: 100;
                  }
                  body {
                    margin: 0;
                    padding: 0;
                  }
        </style>
    </head>
    <body>
        <nav class="menu-list" style="text-align: right">  
            <button onclick="location.href='Books'" class="button">Libros</button>
            <button class="button">Renta</button>
            <button  class="button">Usuarios</button>               
        </nav>
        <p class="button" style="margin-left: 3%; margin-top: 5%;" onclick="location.href='../Books'">Volver</p>
        <div class="container" style="width: 50%">
        <h1 class="title">Ingresar tema!</h1>
        <form action="../AddTopic" method="post">
            <label for="topic">Tema</label>
            <input class="input" type="text" name="topic">
            <label for="topicDesc">Descripción</label>
            <input class="input" type="text" name="topicDesc">
            
            <button class="button is-primary" style="margin-top: 10px">Guardar</button>
        </form>
        </div>
    </body>
</html>

<%-- 
    Document   : insertBook
    Created on : Mar 7, 2019, 10:57:26 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresar libro</title>
        <link rel="stylesheet" href="css/bulma.css">
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
        <nav class="menu-list"style="text-align: right">
            <button onclick="location.href='Books'" class="button">Libros</button>
            <button class="button">Renta</button>
            <button  class="button">Usuarios</button>              
        </nav>
         <p class="button" style="margin-left: 3%; margin-top: 5%;" onclick="location.href='Books'">Volver</p>
        
        <div class="container is-mobile" style="width:50%">
        <h1 class="title">Agregue el libro!</h1>
            <form action="AddBook" method="post">
                <label for="title">Título del libro</label>
                <input type="text"  required class="input" name="title">
                <label for="description">Descripción</label>
                <input type="text" required class="input" name="description">

                <div class="select" style="margin-top: 10px">
                <select name="topics">
                    <c:forEach items="${topics}" var="topic">
                            <option value="${topic.topicId}">${topic.name}</option>
                    </c:forEach>
                </select>
                </div>
                <button style="margin-top: 10px" class="button is-primary">Guardar</button>
            </form>
        </div>
         
    </body>
</html>

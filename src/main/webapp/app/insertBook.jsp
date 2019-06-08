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
                  .best {
                       background:#4d4d4d;
                       /*background-color: brown;*/


                  }
        </style>
    </head>
    <body>
<nav class="navbar is-fixed-top best" role="navigation" aria-label="main navigation">
  <div class="navbar-brand">
    <a class="navbar-item">
      <button onclick="location.href='Books'" class="button">Libros</button>
    </a>

    <a role="button" class="navbar-burger burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
      <span aria-hidden="true" style="color: white"></span>
      <span aria-hidden="true" style="color: white"></span>
      <span aria-hidden="true" style="color: white"></span>
    </a>
  </div>

  <div id="navbarBasicExample" class="navbar-menu">
    <div class="navbar-end">
      <div class="navbar-item">
        <div class="buttons">
          <a onClick="location.href='ShowCustomers'" class="button is-light">
            Clientes
          </a>
          <a class="button is-light">
            Cerrar
          </a>
        </div>
      </div>
    </div>
  </div>
</nav>




         <p class="button is-warning" style="margin-left: 3%; margin-top: 5%;" onclick="location.href='Books'">Volver</p>

        <div class="container is-mobile" style="width:50%">
        <h1 class="title">Agregue el libro!</h1>
            <form action="AddBook" method="post">
                <label for="title">Título del libro</label>
                <input type="text"  required class="input" name="title">
                <label for="description">Descripción</label>
                <input type="text" required class="input" name="description">
                <label for="units">No. unidades</label>
                <input required type="number" min="0" step="1" class="input" name="units">

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
        <script>
          (function() {
            var burger = document.querySelector('.burger');
            var nav = document.querySelector('#'+burger.dataset.target);

            burger.addEventListener('click', function(){
              burger.classList.toggle('is-active');
              nav.classList.toggle('is-active');
            });
        })();
        </script>
    </body>
</html>

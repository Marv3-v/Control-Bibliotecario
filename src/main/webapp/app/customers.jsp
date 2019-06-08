<%--
    Document   : costumers
    Created on : Jun 7, 2019, 2:11:02 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
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

      <%-- MENU --%>
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
      <%-- FIN DEL MENU --%>



        <div class="columns" style="margin-top:1%">
          <div class="column is-four-fifths">
            <p class="button is-warning" style="margin-left: 3%; margin-top: 5%;" onclick="location.href = 'Books'">Volver</p>
          </div>
          <div class="column is-four-fifths">
            <p class="button is-primary" style="margin-top: 5%; margin-bottom: 2%;" onclick="location.href = 'app/insertCustomer.jsp'">Nuevo Cliente</p>
          </div>
        </div>


      <%-- Contenedor --%>
      <div class="container" style="width:97%; margin:auto; margin-bottom: 5%">
        <%-- Titulo --%>
        <span style="text-align:center; margin-bottom: 25px;">
            <span class="title">Clientes</span>
        </span>

        <table class="table is-fullwidth is-hoverable " style="margin-left:auto; margin-right:auto">
            <tr>
                <th> Nombre </th>
                <th> Correo </th>
                <th> Dirección </th>
            </tr>
            <c:forEach items="${customers}" var="c">
                <tr>
                    <td>${c.name}</td>
                    <td>${c.email}</td>
                    <td>${c.address}</td>
                </tr>
            </c:forEach>

        </table>



      </div>
      <script>
          (function () {
              var burger = document.querySelector('.burger');
              var nav = document.querySelector('#' + burger.dataset.target);

              burger.addEventListener('click', function () {
                  burger.classList.toggle('is-active');
                  nav.classList.toggle('is-active');
              });
          })();
      </script>
    </body>
</html>

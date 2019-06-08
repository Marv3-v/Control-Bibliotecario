<%--
    Document   : insertCustomer
    Created on : Jun 7, 2019, 3:54:35 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
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
                  <button onclick="location.href = '../Books'" class="button">Libros</button>
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

      <p class="button is-warning" style="margin-left: 3%; margin-top: 5%;" onclick="location.href = '../ShowCustomers'">Volver</p>
      <div class="container" style="width: 50%">
        <h1 class="title">Ingrese cliente</h1>
          <form action="../AddCustomer" method="post">
              <label for="name">Nombre</label>
              <input class="input" type="text" name="name" required>
              <label for="email">Correo</label>
              <input class="input" type="email" name="email" required>
              <label for="address">Dirección</label>
              <input class="input" type="text" name="address" required>
              <button class="button is-primary" style="margin-top: 10px">Guardar</button>
          </form>
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

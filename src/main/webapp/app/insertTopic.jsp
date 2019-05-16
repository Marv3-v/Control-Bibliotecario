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
                            <a class="button is-light">
                                Usuarios
                            </a>
                            <a class="button is-light">
                                Cerrar
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </nav>



        <p class="button" style="margin-left: 3%; margin-top: 5%;" onclick="location.href = '../Books'">Volver</p>
        <div class="container" style="width: 50%">
            <h1 class="title">Ingresar tema!</h1>
            <form action="../AddTopic" method="post">
                <label for="topic">Tema</label>
                <input class="input" type="text" name="topic"> 
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

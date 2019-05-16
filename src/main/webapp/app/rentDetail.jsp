<%-- 
    Document   : rentDetail
    Created on : Mar 24, 2019, 4:42:31 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bulma.css">
        <title>JSP Page</title>

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
            a,
            a:visited {
                color: #0A9297;
            }

            footer {
                text-align: center;
                margin: 1.6rem 0;
            }

            h1 {
                text-align: center;
            }

            .container2 {
                width: 94%;
                margin: 1.6rem auto;
                max-width: 42rem;
                text-align: center;
            }

            .demo-picked {
                font-size: 1.2rem;
                text-align: center;
            }

            .demo-picked span {
                font-weight: bold;
            }

            .best {
                background:#4d4d4d;
                /*background-color: brown;*/


            }
        </style>

    </head>
    <body>

        <p class="button" style="margin-left: 3%; margin-top: 5%;" onClick="location.href = 'BookDetail?title=${rentDetail.book.title}&id=${rentDetail.book.id}'">Volver</p>
        <nav class="navbar is-fixed-top best" role="navigation" aria-label="main navigation">
            <div class="navbar-brand">
                <a class="navbar-item">
                    <button onclick="location.href = 'Books'" class="button">Libros</button>
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
        <h1 class="title">Detalle de renta</h1>

        <div class="container" style="margin-top: 4%; width:50%">

            <div class="card">
                <div class="card-content">
                    <div class="media">
                        <div class="media-left">

                        </div>
                        <div class="media-content">
                            <p class="title is-4">${rentDetail.book.title}</p>
                            <p class="subtitle is-6">Cliente:
                                ${rentDetail.customerName}</p>
                        </div>
                    </div>

                    <div class="content">





                        <p><b>Fecha inicio:</b>          
                            ${rentDetail.startDate}          
                            
                        </p>
                        <p><b>Fecha final:</b>                     
                            ${rentDetail.finalDate}
                            <input type="text" id="finalDate" hidden value="${rentDetail.finalDate}">
                        </p>
                        <p><b>Costo:</b>           
                            ${rentDetail.payment}
                        </p>
                        <form action="AddReceivedDate" method="post">
                            <input name="idRent" type="hidden" value="${rentDetail.id}">
                            <label for="receivedDate"><b>Ingrese fecha de entrega</b>   </label>
                            <input  id="receivedDate" onChange="compararFechas()" name="receivedDate" type="date" class="input">
                            <button class="button is-primary">Guardar fecha</button>
                        </form>

                        <br>
                    </div>
                </div>
            </div>


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
        <script>
            function compararFechas() {
                var finalDate = document.querySelector("#finalDate").value;
                var receivedDate = document.querySelector('#receivedDate').value;
                if(receivedDate < finalDate) {
                    alert("Solo puede devolver el libro en la fecha final");
                    document.querySelector('#receivedDate').value = finalDate;
                }
            }
        </script>  
    </body>
</html>

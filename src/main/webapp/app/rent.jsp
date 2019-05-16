<%-- 
    Document   : rent
    Created on : Mar 17, 2019, 9:51:11 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Renta</title>
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

            .btn {
                background: rgb(255,255,255,.7);
                backface-visibility:visible;
                border: none;
            }
            .btn:hover {
                background: rgb(255,255,255,.2);
                backface-visibility:visible;
                border: none;
            }

            .best {
                background:#4d4d4d;
                /*background-color: brown;*/


            }

            .margen {
                margin-bottom: 10px;
            }

            .margen-form {
                margin-bottom: 50px;
            }
        </style> 
    </head>
    <body>
        <nav class="navbar is-fixed-top best" role="navigation" aria-label="main navigation">
            <div class="navbar-brand">
                <a class="navbar-item">
                    <button onClick="location.href = 'Books'" class="button">Libros</button>
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
        <p class="button" style="margin-top: 6%;margin-left: 3%;" onClick="location.href = 'BookDetail?libro=${book}&id=${id}'">Volver</p>
        <div class="container" style="width: 50%">
            <h1 class="title" style="padding: 30px;">Formulario Renta</h1>


            <div>
                <form action="AddRent" method="post" class="margen-form">    
                    <input type="hidden" name="id" value="${id}">
                    <br>
                    <label for="book">Libro</label>
                    <input type="text" readonly class="input margen" name="book" value="${book}">
                    <br>
                    <label for="startDate"  style="margin-top: 10px">Fecha inicial</label>
                    <input type="date" required onChange="comprobarFecha()" id="startDate" name="startDate" class="input margen">
                    <br>
                    <label for="finalDate" style="margin-top: 10px">Fecha final</label>
                    <input type="date" id="finalDate" onChange="compararFechas()" required name="finalDate" class="input margen">
                    <br>
                    <label for="customer" style="margin-top:10px">Cliente que renta</label> 
                    <div class="select">
                        <select name="customer">
                            <c:forEach items="${customers}" var="c">
                                <option value="${c.id}" onClick="print(${c.id})">${c.name} | ${c.email}</option>
                            </c:forEach>
                        </select> 
                    </div>
                    <br>

                    <label for="payment" style="margin-top: 10px">Pago</label>
                    <input type="number"  readonly value="25" name="payment" class="input margen">
                    <span sty le="margin-top: 20px;margin-bottom: 30px">
                        <!-- Enviar idCliente y idLibro-->
                        <button class="button margen" style="color: white; background: #4d4d4d">Rentar</button>
                    </span>
                </form>
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
            function comprobarFecha() {
                n =  new Date();
                y = n.getFullYear();
                m = n.getMonth() + 1;
                d = n.getDate();
                
                if(d<10) {
                    d='0'+d;
                } 
                if(m<10) {
                    m='0'+m;
                } 
                var date = y + "-" + m + "-" + d;
                if(document.querySelector('#startDate').value < date) {
                    alert("Escribe una fecha actual en adelante");
                    document.querySelector("#startDate").value = date;
                }
            }    
        </script>
        <script>
            function compararFechas() {
                var finalDate = document.querySelector("#finalDate").value;
                var startDate = document.querySelector('#startDate').value;
                if(finalDate < startDate) {
                    alert("La fecha debe ser mayor o igual a la fecha inicial");
                    document.querySelector("#finalDate").value = startDate;
                }
            }    
        </script>
    </body>
</html>

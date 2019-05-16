<%-- 
    Document   : bookdetail
    Created on : Mar 7, 2019, 11:44:17 PM
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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


        <p class="button" style="margin-left: 3%; margin-top: 5%;" onclick="location.href = 'Books'">Volver</p>
        <div class="is-rounded" style="margin-top:  20px; display: flex; justify-content: space-around; flex-wrap: wrap">
            <div class="is-mobile card" style="width: 300px; margin-bottom: 30px;">
                <div class="card-image">
                    <figure class="image is-4by3">
                        <img src="img/pexel.jpeg" alt="Placeholder image">
                    </figure>
                </div>
                <div class="card-content">
                    <div class="media">    
                        <div class="media-content">
                            <p class="title is-4">${oneBook.title}</p>
                            <p class="subtitle is-6">${oneBook.topicName}</p>
                            <p class="subtitle is-6"><b>Descripción:</b> ${oneBook.description}</p> 
                            <p class="subtitle is-6"><b>Unidades: </b>${oneBook.units}</p>
                            <p class="subtitle is-6"><b>Disponibles actualmente: </b>${oneBook.availableUnits}</p>
                            <p class="subtitle is-6"><b>Estado: </b>${oneBook.yesNoActive}</p>

                            <input type="hidden" name="idB" value="${oneBook.id}">
                            <button class="button is-primary" style="color: white; background: #4d4d4d" onClick="location.href = 'RentForm?libro=${oneBook.title}&id=${oneBook.id}'">Rentar libro</button>
                        </div>
                    </div>
                </div>                         
            </div>
            <div>


                <form action="UpdateBook" method="post" class="is-mobile" style="width: 100%">     
                    <h3 class="title is-4">Actualización</h3>
                    <div> 
                        <input type="hidden" name="idB" value="${oneBook.id}">
                        <label for="updatedTitle">Título</label>
                        <input required pattern="([A-z0-9À-ž\s]){2,}" pattern="[a-zA-ZñÑáéíóúÁÉÍÓÚ\s]+"style="margin-top: 20px; margin-bottom: 20px" class="input" type="text" name="updatedTitle" value="${oneBook.title}">
                    </div>
                    <div>
                        <label for="updatedDesc">Descripción</label>
                        <input required pattern="([A-z0-9À-ž\s]){2,}" pattern="[a-zA-ZñÑáéíóúÁÉÍÓÚ\s]+" style="margin-top: 20px; margin-bottom: 20px" class="input" type="text" name="updatedDesc" value="${oneBook.description}">
                    </div>
                    <input type="hidden" value="${oneBook.topic.topicId}" name="idT">
                    <div class="select">
                        <select required name="topics" id="">
                            <c:forEach items="${topics}" var="topic">
                                <option value="${topic.topicId}">${topic.name}</option>
                                <option selected hidden disabled>${oneBook.topicName}</option>
                            </c:forEach>
                        </select>
                        <br>   
                    </div>
                    <span>
                        <button class="button is-primary is-size-6-mobile">Actualizar</button>
                    </span>


                </form>
                <br>

                <br>
                <form action="UpdateUnits" method="post" style="width: 70%" >
                    <input type="hidden" name="id" value="${idBook}">
                    <label for="newUnits">Agregar unidades</label>
                    <div style="display: flex;">
                        <input required name="newUnits" type="number" min="0" step="1" class="input" style="margin-top: 20px; margin-bottom: 20px">
                        <span style="margin-top: 20px; margin-bottom: 20px">
                            <button class="button is-primary is-size-6-mobile" >Actualizar</button>
                        </span>
                    </div>
                </form>
            </div>
        </div>


        <div>
            <div class="container" style="width:97%; margin:auto; margin-bottom: 5%">
                <span style="text-align:center; margin-bottom: 25px;">     
                    <h2 class="title">Unidades rentadas actualmente</h2>
                </span>
                <table class="table" style="margin-left:auto; margin-right:auto">
                    <tr>
                        <th>Cliente</th>
                        <th>Fecha Inicio</th>
                        <th>Fecha Final</th>
                        <th>Costo de Renta</th>
                        <th></th>
                    </tr>
                    <c:forEach items="${currentRents}" var="r">
                        <tr>
                            <td>${r.customerName}</td>
                            <td>${r.startDate}</td>
                            <td>${r.finalDate}</td>
                            <td>${r.payment}</td>
                            <td><button class="button" onClick="location.href = 'RentDetail?id=${r.id}&customer=${r.customerName}'">Ver más</button></td>
                        </tr>
                    </c:forEach>
                </table>

                <button style="margin-bottom: 1%" class="button" onClick="location.href = 'ShowPreRents?idBook=${oneBook.id}'">Rentas anteriores</button>
            </div> 
        </div>




        <script>
            if (${right}) {
                alert("Se ha ingresado correctamente la renta");
            } else {
                alert("Hubo un error");
            }
        </script>
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

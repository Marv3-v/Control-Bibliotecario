<%-- 
    Document   : index
    Created on : Mar 6, 2019, 9:27:59 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Libros</title>
        <link rel="stylesheet" href="css/bulma.css">
        <style>
            .parallax {
                /*The image used*/ 
                background-image: url("img/books.jpg");

                min-height: 540px; 

                background-attachment: fixed;
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
            }

            .menu-list {


                background:#4d4d4d;
                /*                      top:0;
                                      padding: 10px;
                                      box-sizing: border-box;
                                       z-index: 100;*/
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
        <div class="parallax" style="">
            <nav class="" style="width: 100%">
                <div style="margin-top: 3%;padding: 70px;">

                    <button style="width: 150px;height: 40px;" onClick="location.href = 'app/insertTopic.jsp'" class="button btn">Ingresar tema</button>
                    <div style="overflow-y:auto; height: 300px"> 
                        <c:forEach items="${topics}" var="topic">            
                            <div style="text-align:right">                                      
                                <button style="margin-bottom: 10px;height: 40px; width: 230px;" onClick="location.href = 'Books?tema=${topic.name}&id=${topic.topicId}'" class="button btn">${topic.name}</button><br>            
                            </div>

                        </c:forEach>
                    </div>
                    <button style="margin-bottom: -40px;width: 150px;height: 40px;" onClick="location.href = 'BookForm'" class="button btn">Ingresar libro</button>                       
                </div>
            </nav>
        </div>

        <hr>   
        <div class="is-rounded" style="margin: auto; width: 97%; display: flex; flex-wrap: wrap; justify-content: flex-start;">       
            <c:if test="${books.isEmpty()}">
                <div class="container">
                    <h2 style="margin-bottom: 20px">No existe ningun libro con este tema</h2>
                </div>
            </c:if>
            <c:forEach items="${books}" var="book">
                <div class="is-rounded" style=" width: 230px; margin:  15px">
                    <div class="card">
                        <div class="card-image">
                            <figure class="image is-3by2">
                                <img src="img/pexel.jpeg" alt="Placeholder image">
                            </figure>
                        </div>
                        <div class="card-content">
                            <div class="media">              
                                <div class="media-content">
                                    <p class="title is-4">${book.title}</p>
                                    <p class="subtitle is-6">${book.topicName}</p>
                                    <!--Aqui ira onClick con el id del libro como url-->
                                    <button class="button is-small" style="color: white; background: #4d4d4d" 
                                            onClick="location.href = 'BookDetail?libro=${book.title}&id=${book.id}'">Detalle</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
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

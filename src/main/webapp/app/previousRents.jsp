<%-- 
    Document   : previousRents
    Created on : Mar 24, 2019, 6:42:38 PM
    Author     : User
--%>


<%@page import="com.models.Rented"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Date"%>
<%@page import="com.daos.RentedDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bulma.css">
        <title>Rentas anteriores</title>
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
        <h1>Rentas anteriores</h1>
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

        <div class="container" style="width:70;margin-top: 4%">
            <p class="button" style="margin-left: 3%; margin-top: 5%;" onClick="location.href = 'BookDetail?title=${oneBook.title}&id=${oneBook.id}'">Volver</p>

            <table class="table" style="margin-left:auto; margin-right: auto">
                <% HttpSession sesion = request.getSession();
                    String idBook = (String) sesion.getAttribute("id");

                    List<Rented> rents = RentedDao.getPreviousRents(idBook);
                    out.println("<tr>");
                    out.println("<th>Titulo</th>");
                    out.println(" <th>Cliente</th>");
                    out.println("<th>Fecha Inicio</th>");
                    out.println("<th>Fecha final</th>");
                    out.println(" <th>Costo</th>");
                    out.println("<th>Fecha Recibido</th>");
                    out.println("<th>Mora</th>");
                    out.println("<th>Días diferencia</th>");
                    out.println("</th>");
                    for (Rented r : rents) {
                        long days = RentedDao.getDifferenceDays(Date.valueOf(r.getFinalDate()), Date.valueOf(r.getReceivedDate()));
                        int mora = (int) (days * 20);
                        out.println("<tr>");
                        out.println("<td>" + r.getBook().getTitle() + "</td>");
                        out.println("<td>" + r.getCustomerName() + "</td>");
                        out.println("<td>" + r.getStartDate() + "</td>");
                        out.println("<td>" + r.getFinalDate() + "</td>");
                        out.println("<td>" + r.getPayment() + "</td>");
                        out.println("<td>" + r.getReceivedDate() + "</td>");
                        out.println("<td>" + mora + "</td>");
                        out.println("<td>" + days + "</td>");
                        out.println("</tr>");

                    }
                %>  
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

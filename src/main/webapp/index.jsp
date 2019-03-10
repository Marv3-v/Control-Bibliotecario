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
    </head>
    <body>
        <h1>Libros</h1>
        
        <header class="container">
        <c:forEach items="${topics}" var="topic">
            <button onClick="location.href='Books?tema=${topic.name}&id=${topic.topicId}'" class="button">${topic.name}</button>
        </c:forEach>
            <button onclick="location.href='Books'" class="button">Todos</button>
            <button onClick="location.href='BookForm'" class="button">Ingresar libro</button>
            <button onClick="location.href='insertTopic.jsp'" class="button">Ingresar tema</button>
            <button class="button">Renta</button>
        </header>
           
            
            <hr>   
            <div class="is-rounded" style="margin: auto; width: 97%; display: flex; flex-wrap: wrap; justify-content: flex-start;">       
                <c:if test="${books.isEmpty()}">
                    <div class="container">
                        <h2 class="">No existe ningun libro con este tema</h2>
                    </div>
                </c:if>
            <c:forEach items="${books}" var="book">
                <div class="is-rounded" style=" width: 230px; margin:  15px">
                    <div class="card">
                          <div class="card-image">
                            <figure class="image is-3by2">
                              <img src="https://bulma.io/images/placeholders/1280x960.png" alt="Placeholder image">
                            </figure>
                          </div>
                          <div class="card-content">
                            <div class="media">
                              
                              <div class="media-content">
                                <p class="title is-4">${book.title}</p>
                                <p class="subtitle is-6">${book.topicName}</p>
                                <!--Aqui ira onClick con el id del libro como url-->
                                <button class="button is-small is-warning" onClick="location.href='BookDetail?libro=${book.title}&id=${book.id}'">Detalle</button>
                              </div>
                            </div>
                          </div>
                    </div>
                </div>
            </c:forEach>
            </div>
    </body>
</html>

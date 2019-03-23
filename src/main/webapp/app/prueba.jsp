<%-- 
    Document   : prueba
    Created on : Mar 19, 2019, 10:48:59 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../css/bulma.css">
    </head>
    <body>
       <nav class="navbar is-primary">
<div class="container">
<div class="navbar-brand">
      <a class="navbar-item" href="#" style="font-weight:bold;">
        adam bray
      </a>
      <span class="navbar-burger burger" data-target="navMenu">
        <span></span>
        <span></span>
        <span></span>
      </span>
    </div>
<div id="navMenu" class="navbar-menu">
<div class="navbar-end">
        <a href="#" class="navbar-item is-active">Home</a>
        <a href="#" class="navbar-item">Blog</a>
        <a href="#" class="navbar-item">Forum</a>
        <a href="#" class="navbar-item">Shop</a>
        <a href="#" class="navbar-item">Examples</a>
      </div>
</div>
</div>
</nav>

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

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
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bulma.css">
        <link href="vanilla-calendar-master/dist/vanillaCalendar.css" rel="stylesheet">
        <style>
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
        </style>
    </head>
    <body>
        <p class="button" onclick="location.href='Books'">Volver</p>
            <div class="is-rounded" style="margin-top:  20px; display: flex; justify-content: space-around; flex-wrap: wrap">
                <div class="is-mobile card" style="width: 300px">
                          <div class="card-image">
                            <figure class="image is-4by3">
                              <img src="https://bulma.io/images/placeholders/1280x960.png" alt="Placeholder image">
                            </figure>
                          </div>
                          <div class="card-content">
                            <div class="media">    
                              <div class="media-content">
                                <p class="title is-4">${oneBook.title}</p>
                                <p class="subtitle is-6">${oneBook.topicName}</p>
                                <p class="subtitle is-6"><b>Descripción:</b> ${oneBook.description}</p>            
                                <p class="subtitle is-6"><b>Estado:</b> ${oneBook.yesNoRented}</p>
                              </div>
                            </div>
                          </div>                         
                </div>
                <form action="UpdateBook" method="post" class="is-mobile" style="width: 350px">     
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
                    </div>
                    <span>
                    <button class="button is-primary is-size-6-mobile">Actualizar</button>
                    </span>   
                </form>
            </div>

            
        
                    
                    
                    
        <div class="container2">    
			<g fill="none">
				<path d="M77.877 47.673a6.515 6.515 0 0 1-1.912 4.619 6.515 6.515 0 0 1-4.618 1.912H8.653a6.53 6.53 0 0 1-4.618-11.149 6.515 6.515 0 0 1 4.618-1.912h3.918a6.53 6.53 0 0 1-4.618-11.149 6.515 6.515 0 0 1 4.619-1.912h3.918a6.53 6.53 0 0 1-4.618-11.15 6.515 6.515 0 0 1 4.618-1.911h2.613c0-7.213 5.848-13.062 13.06-13.062H60.9a13.02 13.02 0 0 1-3.828 9.234 13.02 13.02 0 0 1-9.234 3.828h15.674a6.53 6.53 0 0 1 4.618 11.148 6.515 6.515 0 0 1-4.619 1.913h3.919a6.53 6.53 0 0 1 4.618 11.149 6.515 6.515 0 0 1-4.618 1.912h3.918a6.53 6.53 0 0 1 6.53 6.53z"
				  fill="#FFF" />
				<path d="M37.388 15.02h10.449a13.02 13.02 0 0 0 9.234-3.826 13.02 13.02 0 0 0 3.827-9.235H50.449a13.02 13.02 0 0 1-3.827 9.234 13.02 13.02 0 0 1-9.234 3.828zm33.959 26.123h-3.918a6.515 6.515 0 0 0 4.618-1.913 6.53 6.53 0 0 0-4.618-11.149h-3.918a6.515 6.515 0 0 0 4.618-1.912 6.53 6.53 0 0 0-4.618-11.149H53.062a6.53 6.53 0 0 1 4.618 11.15 6.515 6.515 0 0 1-4.618 1.911h3.918a6.53 6.53 0 0 1 4.618 11.15 6.515 6.515 0 0 1-4.618 1.912h3.918a6.53 6.53 0 0 1 4.618 11.149 6.515 6.515 0 0 1-4.618 1.912h10.449a6.515 6.515 0 0 0 4.618-1.912 6.53 6.53 0 0 0-4.618-11.149z"
				  fill="#EBE5DD" />
				<path fill="#FFDA44" d="M63.249 77.71425L53.06125 126.04075 26.93875 126.04075 16.751 77.71425" />
				<path d="M16.751 77.714l1.101 5.225h31.12c3.319 0 5.796 3.054 5.112 6.302l-7.758 36.8h6.736l10.187-48.327H16.751z" fill="#EEBF00"
				/>
				<path fill="#FFDA44" d="M67.242 77.71425L12.758 77.71425 7.347 54.204 72.653 54.204z" />
				<path d="M66.226 54.204L62.95 68.437a5.225 5.225 0 0 1-5.09 4.053H11.555l1.202 5.224h54.484l5.41-23.51h-6.426z" fill="#EEBF00"
				/>
				<path d="M79.837 47.673c0-3.667-2.338-6.799-5.603-7.983a8.427 8.427 0 0 0 1.684-5.078c0-3.668-2.338-6.799-5.602-7.983A8.427 8.427 0 0 0 72 21.55c0-4.681-3.809-8.49-8.49-8.49h-5.56A14.921 14.921 0 0 0 62.857 1.96V0H32.163C24.546 0 18.24 5.702 17.275 13.061h-.785c-2.269 0-4.401.883-6.004 2.486A8.436 8.436 0 0 0 8 21.551c0 1.9.627 3.656 1.686 5.072a8.459 8.459 0 0 0-3.118 1.985 8.434 8.434 0 0 0-2.486 6.004c0 1.9.627 3.656 1.686 5.072A8.456 8.456 0 0 0 2.65 41.67a8.433 8.433 0 0 0-2.486 6.003c0 3.63 2.288 6.732 5.498 7.944l5.535 24.057h3.965L25.349 128h29.302l10.187-48.326h3.965l5.534-24.052a8.461 8.461 0 0 0 3.013-1.945 8.434 8.434 0 0 0 2.487-6.004zm-70.029 8.49h6.742l3.006 19.592h-5.24L9.809 56.163zm41.388 19.592L52.7 56.163h6.787l-3.005 19.592h-5.285zm-3.93 0H41.96V56.163h6.81l-1.503 19.592zm-9.225 0h-5.307L31.23 56.163h6.81v19.592zM27.3 56.163l1.503 19.592h-5.285l-3.005-19.592H27.3zm24.171 67.919H28.528l-9.361-44.408h41.667l-9.362 44.408zm14.211-48.327h-5.238l3.005-19.592h6.742l-4.508 19.592zm8.897-24.848a4.542 4.542 0 0 1-3.233 1.338H8.653a4.577 4.577 0 0 1-4.572-4.572c0-1.221.476-2.37 1.339-3.233a4.542 4.542 0 0 1 3.233-1.338h20.898v-3.918h-16.98A4.577 4.577 0 0 1 8 34.612c0-1.222.475-2.37 1.338-3.233a4.542 4.542 0 0 1 3.234-1.338H40v-3.919H16.49a4.577 4.577 0 0 1-4.572-4.571c0-1.222.476-2.37 1.339-3.233a4.541 4.541 0 0 1 3.233-1.338h7.837V13.06h-3.09c.93-5.19 5.474-9.143 10.926-9.143h26.604a11.025 11.025 0 0 1-3.081 5.89 11.03 11.03 0 0 1-7.85 3.253H37.389v3.919H63.51c2.52 0 4.572 2.05 4.572 4.571 0 1.222-.475 2.37-1.338 3.233a4.542 4.542 0 0 1-3.234 1.338H53.061v3.919h14.367c2.521 0 4.572 2.05 4.572 4.571 0 1.222-.475 2.37-1.338 3.233a4.542 4.542 0 0 1-3.234 1.339H42.612v3.918h28.735c2.52 0 4.572 2.05 4.572 4.572 0 1.221-.476 2.37-1.339 3.233z"
				  fill="#000" />
			</g>
		</svg>

		<h1>Fechas que esta en renta</h1>

		<div id="v-cal">
			<div class="vcal-header">
				<button class="vcal-btn" data-calendar-toggle="previous">
					<svg height="24" version="1.1" viewbox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg">
						<path d="M20,11V13H8L13.5,18.5L12.08,19.92L4.16,12L12.08,4.08L13.5,5.5L8,11H20Z"></path>
					</svg>
				</button>

				<div class="vcal-header__label" data-calendar-label="month">
					Marzo 2019
				</div>


				<button class="vcal-btn" data-calendar-toggle="next">
					<svg height="24" version="1.1" viewbox="0 0 24 24" width="24" xmlns="http://www.w3.org/2000/svg">
						<path d="M4,11V13H16L10.5,18.5L11.92,19.92L19.84,12L11.92,4.08L10.5,5.5L16,11H4Z"></path>
					</svg>
				</button>
			</div>
			<div class="vcal-week">
				<span>Lun</span>
				<span>Martes</span>
				<span>Miérc</span>
				<span>Jueves</span>
				<span>Viernes</span>
				<span>Sábado</span>
				<span>Domi</span>
			</div>
			<div class="vcal-body" data-calendar-area="month"></div>
		</div>

		<p class="demo-picked">
			Fecha elegida:
			<span data-calendar-label="picked"></span>
		</p>

		<footer>
			<a href="https://github.com/chrisssycollins">@chrisssycollins</a> |
			<a href="https://github.com/chrisssycollins/vanilla-calendar">View on GitHub</a>
		</footer>
	</div>
	<script src="vanilla-calendar-master/dist/vanillaCalendar.js" type="text/javascript"></script>
	<script>
		window.addEventListener('load', function () {
			vanillaCalendar.init({
				disablePastDays: true
			});
		})
	</script>
    </body>
</html>

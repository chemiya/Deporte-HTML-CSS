<%-- 
    Document   : entrenamiento
    Created on : 01-jun-2022, 10:03:03
    Author     : chemi
--%>

<%@page import="modelo.Ejercicio"%>
<%@page import="modelo.Entrenamiento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="inicialSin.css">
        <!--link rel="stylesheet" href="entrenamiento.css"-->
    </head>
    <body id="body">
        <header>
            <div class="container">
                <img src="fotos/iconouvafit.JPG">
                <!--titulo y nav con los elementos-->
                <nav>
                <a href="descripcionEjer.html">Finalizar Entrenamiento</a>
                </nav>
            </div>
        </header>
        <%Entrenamiento entren = (Entrenamiento)request.getAttribute("entrenamiento");
        Ejercicio ejerc = (Ejercicio)request.getAttribute("ejercicio");
        int duracion = ejerc.getDuracion();
        %>
        <script src="entrenamientoTimer.js" type="text/javascript"></script>
        <div class="train-progress">
            <h3>Progreso: 0:00/<%=String.format("%02d",entren.getDuracion()) + ":00"%></h3>
        </div>
        <h1><%=ejerc.getNombre()%></h1>
        <div class="video-wrap">
            <iframe width="560" height="315" src='<%=ejerc.getVideoUrl()+"?autoplay=1&mute=1"%>' title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
        </div>
        <div class="desc">
            <p class="entre"><%=ejerc.getDescripcion()%></p>
        </div>
        <!--progress id="time" max="60" value="25">25</progress-->
        <div class="progress-cont">
            <div class="progress" id="progressBar" style="width:0%;">
            </div>
            <div class="buttons">
                <button name="pause">Pausar</button>
                <h2 id="time">0:45</h2>
                <form action="EntrenamientoServlet">
                <!--button type="submit" value="EntrenamientoServlet" name="next">Saltar</button-->
                <input type="submit" value="Siguiente">
                </form>
            </div>
        </div>

        <div class="next">
            <h6>Siguiente:</h6>
            <p class="entre"><%=request.getAttribute("nextEjercicio")%></p>
        </div>
    </body>
</html>
<script type="text/javascript">countdown(<%=duracion%>)</script>

<%-- 
    Document   : anadirEjerResultados
    Created on : 30-may-2022, 10:13:40
    Author     : chemi
--%>

<%@page import="modelo.Ejercicio"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="inicialSin.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200&display=swap" rel="stylesheet">
    
</head>
<body>
    <h2>introduce la duracion que quieres para el ejercicio</h2>
    <form action="GuardarDuracionServ" method="get" id="formularioDuracion">
        <div id="cuadro-duracion">
            <p>duracion:</p><!-- comment -->
        <input type="number" name="duracion" id="numero"><!-- comment -->
        <input type="submit">
        </div>
        
    </form>
    
    <p class="warnings" id="warnings1"></p>
    <script src="validaciones.js"></script> 
     
</body>
</html>

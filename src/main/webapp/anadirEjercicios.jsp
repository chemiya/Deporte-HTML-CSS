<%-- 
    Document   : anadirEjercicios
    Created on : 03-may-2022, 10:58:32
    Author     : chemi
--%>

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
    <h1 id="titulo-anadir">anade ejercicios a tu entrenamiento creado</h1>
    <div id="contenedor-anadir">
        <h2 id="titulo-buscar">buscador de ejercicios</h2>
        <form action="BuscEjerServl" method="get" id="formularioAnadir">
        <div id="cont1">
           

                <p>nombre: </p>
    
                <input type="text" name="nombreEjer" id="nombreEjer">
                <input type="submit">
            
        </div>
    </form>
        
    </div>
    
     <p class="warnings" id="warnings"></p>

     <script src="validaciones.js"></script> 

    
    
</body>
</html>
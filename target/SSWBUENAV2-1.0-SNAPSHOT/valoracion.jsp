<%-- 
    Document   : valoracion
    Created on : 03-may-2022, 17:10:21
    Author     : chemi
--%>

<%@page import="modelo.Entrenamiento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200&display=swap" rel="stylesheet">
   
    <link rel="stylesheet" href="inicialSin.css">
</head>
<body>
    
    <%Entrenamiento entrenamientoValoracion=(Entrenamiento) session.getAttribute("entrenamientoValoracion");
        
    %>
    <div id="contenedor-datos">
        <h1><%=entrenamientoValoracion.getNombre()%></h1>
        <div id="datos">
            <div id="datos-realizacion">
                <p><%=entrenamientoValoracion.getDescripcion()%></p>
                <p><%=entrenamientoValoracion.getDuracion()%> minutos</p>
            </div>
            <div id="datos-ejercicio">
                <p>difultad: <%=entrenamientoValoracion.getDificultad()%></p>
                
                
            </div>

        </div>
       
    </div>

     <form action="OpinionServlet" name="datos1" method="get" id="formularioValoracion" onsubmit="return validarFormulario5()">
    <div id="contenido-opinionv">
        <h1>valoracion</h1>
        <div id="contenedor-entradas">
            <div id="puntuacion">
                <label>que puntuacion le das?</label>
                <select name="puntuacion">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                     <option>4</option>
                    <option>5</option>
                    <option>6</option><!-- comment -->
                     <option>7</option>
                    <option>8</option>
                    <option>9</option>
                     <option>10</option>
                </select>
            </div>
            <div id="comentario">
                <p>que tal ha ido el ejercicio?</p>
                <textarea name="descripcion"  ></textarea>
            </div>

        </div>
        
          
    </div>
    
    
   
            
            
          
         <p class="boton-centrar-nuevo"> <input type="submit" name="submit" value="guardar" > </p>
            
        </form>
    
                  <p class="warnings" id="warnings4"></p>
                  
                  
    <script src="validaciones.js"></script> 
    
</body>
</html>

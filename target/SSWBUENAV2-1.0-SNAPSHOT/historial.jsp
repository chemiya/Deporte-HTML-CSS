<%-- 
    Document   : historial
    Created on : 02-may-2022, 9:45:34
    Author     : chemi
--%>

<%@page import="modelo.Historial"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <%@ page import="modelo.Usuario" %>
                <% Usuario usuario = (Usuario) session.getAttribute("usuario");
                Historial hist=(Historial) session.getAttribute("historial");
                %>
     
    <div id="contenedor-inicio">
        <div id="contenedor-usuario">
            <img src="fotos/persona1.jpg">
            <div id="usuario-datos">
                <p><%= usuario.getUsername() %></p>
                <div id="medidas">
                    <p><%= usuario.getPeso() %> kg</p>
                    <p><%= usuario.getAltura() %> cm</p>
                </div>
                
            </div>

        </div>
        <div id="contenedor-resumen">
            <p><%= hist.getEntrenamientosCompletos() %> entrenamientos completos</p>
            <p>3 programas completados</p>
            <p><%= hist.getTiempoEntrenamiento()%> minutos haciendo entrenamientos</p>
            <p><%= hist.getOpiniones()%> opnionezs</p>
            <p><%= hist.getEntrenamientosCreados()%> entrenamientos creados</p>
        </div>
    </div>

    <div id="consultar-actividad">
         <form action="HistorialServl"  id="formulario" name="datos3" onsubmit="return validarFormulario6()">
        <div id="aplicacion-filtros">
            <p>consultar actividad</p>
            <div id="filtros">
                <div class="filtroh">
                    <p>selecciona tipo</p>
                    <select name="tipo">
                        <option>entrenamiento</option>
                        <option>programa</option>
    
                    </select>
                </div>
                <div class="filtroh">
                    <p>selecciona intervalo de fechas</p>
                    <p>de:</p>
                    <input type="date" name="inicio" id="inicio">
                    <p>a:</p>
                    <input type="date" name="fin" id="fin">
    
                </div>
    
            </div>
             <input type="submit" name="submit" value="aplicar"  >
        </div>
        
        
             <p class="warnings" id="warningsHist"></p>
            
            
        </form>
        
        
        
        
        
        
        
    </div>



        <div id="resultados">
            <h2>resultados</h2>
            
            
           
            
        </div>
    </div>


    <footer>
        <div class="contenedor-footer">
            <div class="contacto">
                <h2>Telefono</h2>
                <p>3884753</p>
            </div>
            <div class="contacto">
                <h2>Email</h2>
                <p>uvafit@alumnos.uva.es</p>
            </div>
            <div class="contacto">
                <h2>Direccion</h2>
                <p>Escuela superior de tecnicos informaticos <br>Paseo del cauce, numero 5 <br> Valladolid, 47188</p>
            </div>
    
    
    
        </div>
    </footer>
      
    <script src="validaciones.js"></script> 
  
</body>
</html>

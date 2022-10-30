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
    <%
     ArrayList<Ejercicio> list = new ArrayList<Ejercicio>();
        list = (ArrayList<Ejercicio>) request.getAttribute("ejerciciosEncontrados");
    %>
    <h1 id="titulo-anadir">anade ejercicios a tu entrenamiento creado</h1>
    <div id="contenedor-anadir">
        <h2 id="titulo-buscar">buscador de ejercicios</h2>
        <form action="BuscEjerServl" method="get">
        <div id="cont1">
           

                <p>nombre: </p>
    
                <input type="text" name="nombreEjer">
                <input type="submit">
            
        </div>
    </form>
        
    </div>

    

    
    
    
    
    
     <div id="resultados">
            <h2>resultados</h2>
            <%for(int i=0;i<list.size();i++){
        Ejercicio realiz=list.get(i);
        
        
        
    %>
           <div class="ejercicioBuscador">
            <img src="">
            <div class="datos">
                <p><%=realiz.getNombre()%></p>
                 <p><%=realiz.getDescripcion()%></p>
                
                <button class="botonAnadirCrear"><a href="DarDuracionServlet?idEjercicio=<%=realiz.getIdEjercicio()%>">seleccionar</a></button>
            </div>
        </div>
            
           
        </div>
                        
                          <%
                        };
                        %>
                    
                   
    
                       
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
</body>
</html>

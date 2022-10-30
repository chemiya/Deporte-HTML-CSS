<%-- 
    Document   : programaDesc
    Created on : 28-may-2022, 18:39:40
    Author     : chemi
--%>

<%@page import="modelo.Entrenamiento"%>
<%@page import="modelo.Planificacion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.PlanEntrenamientos"%>
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
    <div id="contenido-entrenamientoPlan">
        
        <%
 PlanEntrenamientos selec =  (PlanEntrenamientos)request.getAttribute("planSeleccionado");
 
 ArrayList<Planificacion> list = new ArrayList<Planificacion>();
        list = (ArrayList<Planificacion>) request.getAttribute("planificacionEntrenamientos");
        
        ArrayList<Entrenamiento> list1 = new ArrayList<Entrenamiento>();
        list1 = (ArrayList<Entrenamiento>) request.getAttribute("entrenamientosIncluidos");
       
%>
        
        <h1><%=selec.getNombre()%></h1>
        <p><%= selec.getDuracion() %> dias </p>
        <p>descripcion: blah blah</p>
        <p>valoracion: 9.2</p>
        <p class="boton-centrar-nuevo1"> <a href="RegistradoEnPlan?idPlan=<%= selec.getIdPlan() %>">apuntarse</a></p>
    </div>

    <div id="entrenamientos">
        <h2>entrenamientos</h2>
       
        
        
        
        
            <%for(int i=0;i<list.size();i++){
        Planificacion realiz=list.get(i);
        Entrenamiento ent=list1.get(i);
        
        
    %>
             <div class="dia">
            <div class="dia-numero">
                <p>dia <%=realiz.getDia()%></p>
            </div>
            <div class="datos">
                <img src="fotos/flexiones.jpg">
                <div class="datos-ejer">
                    <p><%=ent.getNombre()%></p>
                    <div class="ejer-desc">
                        <p>moderado</p>
                        <p>15 minutos</p>
                        <p>cuerpo entero</p>
                    </div>
                </div>
            </div>
        </div>
                        
                          <%
                        };
                        %>
       
        
    </div>

    <div id="contenedor-opiniones">
        <h1>Opiniones</h1>
        <div id="opiniones">
            <div class="carta">
                <img src="fotos/perfil.jpg" class="fotos-programa-desc" >
                <div class="texto-opinion">
                    <h4>federico</h4>
                    <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. </p>
                </div>
    
            </div>
            <div class="carta">
                <img src="fotos/persona1.jpg" class="fotos-programa-desc">
                <div class="texto-opinion">
                    <h4>federico</h4>
                    <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. </p>
                </div>
    
            </div>
            <div class="carta">
                <img src="fotos/persona1.jpg" class="fotos-programa-desc">
                <div class="texto-opinion">
                    <h4>federico</h4>
                    <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. </p>
                </div>
    
            </div>
            <div class="carta">
                <img src="fotos/persona1.jpg" class="fotos-programa-desc">
                <div class="texto-opinion">
                    <h4>federico</h4>
                    <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. </p>
                </div>
    
            </div>
            <div class="carta">
                <img src="fotos/persona1.jpg" class="fotos-programa-desc">
                <div class="texto-opinion">
                    <h4>federico</h4>
                    <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. </p>
                </div>
    
            </div>
            
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
    
</body>
</html>

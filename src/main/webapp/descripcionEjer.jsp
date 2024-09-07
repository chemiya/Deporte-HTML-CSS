<%-- 
    Document   : descripcionEjer
    Created on : 28-may-2022, 17:32:24
    Author     : chemi
--%>

<%@page import="modelo.ValoracionEntrenamiento"%>
<%@page import="modelo.Ejercicio"%>
<%@page import="modelo.Ejecuccion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Entrenamiento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200&display=swap" rel="stylesheet">
     <link rel="stylesheet" href="inicialSin.css">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

    

    
    <div class="container w-50 mt-5">
        <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img src="fotos/flexiones.jpg" class="d-block w-100" alt="...">
              </div>
              <div class="carousel-item">
                <img src="fotos/pesas.jpg" class="d-block w-100" alt="...">
              </div>
              
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Next</span>
            </button>
          </div>
        </div>

<%
 Entrenamiento selec =  (Entrenamiento)session.getAttribute("entrenamientoSelec");
 
 ArrayList<Ejecuccion> list = new ArrayList<Ejecuccion>();
        list = (ArrayList<Ejecuccion>) request.getAttribute("ejecuccionEjercicios");
        
        ArrayList<Ejercicio> list1 = new ArrayList<Ejercicio>();
        list1 = (ArrayList<Ejercicio>) request.getAttribute("ejerciciosIncluidos");
        
 ArrayList<ValoracionEntrenamiento> list2 = new ArrayList<ValoracionEntrenamiento>();
        list2 = (ArrayList<ValoracionEntrenamiento>) request.getAttribute("valoraciones");
       
%>

    <div id="contenido-entrenamiento">
        <a href="EntrenamientoServlet?idEntrenamiento=<%= selec.getIdEntrenamiento() %>">iniciar</a>
        <h1><%=selec.getNombre()%></h1>
        <p><span class="text-descrip">Dificultad: </span><span class="valor"><%=selec.getDificultad()%></span> </p>
        <p><span class="text-descrip">Valoracion: </span><span class="valor">9.4</span> </p>
        <p><span class="text-descrip">Areas objetivo: </span><span class="valor"> piernas, gluteos</span> </p>
        
        <p><span class="text-descrip">Descripcion:</span> </p>
        <p id="centrar"><span class="valor"><%=selec.getDescripcion()%></span></p>
    </div>


    <div id="contenido-ejercicios">
        <h1>EJERCICIOS</h1>
       
        
            
            
             <%for(int i=0;i<list.size();i++){
        Ejecuccion realiz=list.get(i);
        Ejercicio ent=list1.get(i);
        
        
    %>
            <div class="conjunto">
            
            <div class="ejercicio">
                <img src="fotos/flexiones.jpg" width="200px" height="200px">
                <div class="datos-ejercicio">
                    <p><%=ent.getNombre()%></p>
                    <p> <%=realiz.getDuracion()%> segs/<%=realiz.getRepeticiones()%> repeticiones </p>
                </div>
            </div>
                        
                          <%
                        };
                        %>
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        </div>
        

    </div>

    <!--
    <div id="clientes-contenedor">
       <h1>opiniones</h1>
       <div class="opiniones">
           <div class="carta">
               <img src="fotos/persona1.jpg">
               <div class="texto-opinion">
                   <h2>federico</h2>
                   <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Voluptatum ducimus eum distinctio neque ea quasi, nam ut delectus provident beatae reprehenderit porro error optio ipsum itaque obcaecati saepe expedita?</p>
               </div>
           </div>
           <div class="carta">
            <img src="fotos/persona1.jpg">
            <div class="texto-opinion">
                <h2>federico</h2>
                <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Voluptatum ducimus eum distinctio neque ea quasi, nam ut delectus provident beatae reprehenderit porro error optio ipsum itaque obcaecati saepe expedita?</p>
            </div>
        </div>
        <div class="carta">
            <img src="fotos/persona1.jpg">
            <div class="texto-opinion">
                <h2>federico</h2>
                <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Voluptatum ducimus eum distinctio neque ea quasi, nam ut delectus provident beatae reprehenderit porro error optio ipsum itaque obcaecati saepe expedita?</p>
            </div>
        </div>
        <div class="carta">
            <img src="fotos/persona1.jpg">
            <div class="texto-opinion">
                <h2>federico</h2>
                <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Voluptatum ducimus eum distinctio neque ea quasi, nam ut delectus provident beatae reprehenderit porro error optio ipsum itaque obcaecati saepe expedita?</p>
            </div>
        </div>
       </div>
    </div>
    -->

    <div id="contenedor-opiniones">
        <h1>Opiniones</h1>
        <div id="opiniones">
            
            
            
              <%for(int i=0;i<list2.size();i++){
        ValoracionEntrenamiento val=list2.get(i);
        
        
    %>
            <div class="carta">
                <img src="fotos/perfil.jpg" class="fotos-programa-desc">
                <div class="texto-opinion">
                    <h4><%=val.getUsername()%></h4>
                    <p><%=val.getOpinion()%> </p>
                </div>
    
            </div>
                        
                          <%
                        };
                        %>
            
            
            
            
            
            
            
            
            
            
            
            
            
           
           
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


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>
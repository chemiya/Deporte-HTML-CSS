<%-- 
    Document   : principalRegistrado
    Created on : 02-may-2022, 9:32:22
    Author     : chemi
--%>

<%@page import="java.sql.Time"%>
<%@page import="java.util.Date"%>
<%@page import="modelo.Entrenamiento"%>
<%@page import="modelo.RealizacionEntrenamiento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDate"%>
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
    <div id="contenedor-grid">
        <div id="contenedor-lateral">
            <div id="contenido-usuario">
                <%@ page import="modelo.Usuario" %>
                <% Usuario usuario = (Usuario) session.getAttribute("usuario"); 
                
                ArrayList<Entrenamiento> list2 = new ArrayList<Entrenamiento>();
        list2 = (ArrayList<Entrenamiento>) session.getAttribute("entRecomendados");
        
          Entrenamiento entR1=list2.get(list2.size()-1); 
Entrenamiento entR2=list2.get(list2.size()-2); 
Entrenamiento entR3=list2.get(list2.size()-3); 
Entrenamiento entR4=list2.get(list2.size()-4); 
                
                int admin=(int)session.getAttribute("admin");
                
                
                %>
                <img id="uvafit-imagen" src="fotos/iconouvafit.JPG">
                <img id="usuario-imagen" src="ImagenUsuario?username=<%= usuario.getUsername() %>">
                <p><%= usuario.getUsername() %></p>
            </div>
            <div id="opciones">
                <a href="buscEntre.html">buscar entrenamiento</a>
                <a href="buscPlan.html">buscar plan</a>
                <a href="crearEntre.html">crear entrenamiento</a>
                <a href="historial.jsp">historial</a>
                <a href="editPerfServletGetData">editar Perfil</a>
               
                <a href="ajustesCuenta.html">ajustes de la cuenta</a>
                <a href="cerrarSesionServ">cerrar sesion</a>
                
               <%if(admin==1){
                   
                   
               %>
                
                 <a href="administrador.html">administrador</a>
                <%
                    }
                %>

            </div>
               

        </div>
        <div id="contenedor-central">
            <div id="calendario">
                <h2>calendario</h2>
                <div id="cuadros">
                    <div class="cuadro-dia">
                        <div class="datos-dia">
                            <p><%=LocalDate.now()%></p>
                            <p>no hay ejercicios planeados </p>

                        </div>
                        

                    </div>
                    <div class="cuadro-dia">
                        <div class="datos-dia">
                            <p><%=LocalDate.now().plusDays(1)%></p>
                            <p>no hay ejercicios planeados </p>

                        </div>
                        
                    </div>
                    <div class="cuadro-dia">
                        <div class="datos-dia">
                            <p><%=LocalDate.now().plusDays(2)%></p>
                            <a href="descripcionEjer.html"><p>adelgaza con tu peso </p></a>

                        </div>
                        
                    </div>
                    <div class="cuadro-dia">
                        <div class="datos-dia">
                            <p><%=LocalDate.now().plusDays(3)%></p>
                            <p>no hay ejercicios planeados </p>

                        </div>
                        
                    </div>
                </div>

            </div>
            <div id="recomendados">
                <h2>recomendados</h2>
                <div id="entrenamientos-recomendados">
                    <div id="contenedor-recomendado">
                        <img src="fotos/flexiones.jpg">
                        <div class="texto-recomendado">
                            <a href="descripcionEjer.html"><p><%=entR1.getNombre()%> </p></a>
                            <p><%=entR1.getDificultad()%></p>
                            <p><%=entR1.getDuracion()%> minutos</p>
                        </div>
                    </div>
                    <div id="contenedor-recomendado">
                        <img src="fotos/flexiones.jpg">
                        <div class="texto-recomendado">
                            <a href="descripcionEjer.html"><p><%=entR2.getNombre()%> </p></a>
                            <p><%=entR2.getDificultad()%></p>
                            <p><%=entR2.getDuracion()%> minutos</p>
                        </div>
                    </div>
                    <div id="contenedor-recomendado">
                        <img src="fotos/flexiones.jpg">
                        <div class="texto-recomendado">
                            <a href="descripcionEjer.html"><p><%=entR3.getNombre()%> </p></a>
                            <p><%=entR3.getDificultad()%></p>
                            <p><%=entR3.getDuracion()%> minutos</p>
                        </div>
                    </div>
                    <div id="contenedor-recomendado">
                        <img src="fotos/flexiones.jpg">
                        <div class="texto-recomendado">
                            <a href="descripcionEjer.html"><p><%=entR4.getNombre()%></p></a>
                            <p><%=entR4.getDificultad()%></p>
                            <p><%=entR4.getDuracion()%> minutos</p>
                        </div>
                    </div>
                </div>

            </div>


                            
                            <%
                       ArrayList<RealizacionEntrenamiento> list = new ArrayList<RealizacionEntrenamiento>();
        list = (ArrayList<RealizacionEntrenamiento>) session.getAttribute("historialResumen");
         ArrayList<Entrenamiento> list1 = new ArrayList<Entrenamiento>();
        list1 = (ArrayList<Entrenamiento>) session.getAttribute("resumenEntrenamientos");
        RealizacionEntrenamiento realiz1=new RealizacionEntrenamiento();
        RealizacionEntrenamiento realiz2=new RealizacionEntrenamiento();
        RealizacionEntrenamiento realiz3=new RealizacionEntrenamiento();
        Entrenamiento ent1=new Entrenamiento();
        Entrenamiento ent2=new Entrenamiento();
        Entrenamiento ent3=new Entrenamiento();
        if(list.size()>=3){
      realiz1=list.get(list.size()-1);
        ent1=list1.get(list1.size()-1);  
realiz2=list.get(list.size()-2);
        ent2=list1.get(list1.size()-2); 
realiz3=list.get(list.size()-3);
      ent3=list1.get(list1.size()-3); 
        }else{
            ent1.setNombre("sin entrenamientos");
             ent2.setNombre("sin entrenamientos");
              ent3.setNombre("sin entrenamientos");
              Date fecha=new Date(2022,1,1);
              long now = System.currentTimeMillis();
              Time hora=new Time(now);
              realiz1.setFecha(fecha);
              realiz1.setHora(hora);
              realiz2.setFecha(fecha);
              realiz2.setHora(hora);
              realiz3.setFecha(fecha);
              realiz3.setHora(hora);
        }
 
                            
                            %>
                <div id="ultimos">
                    <div id="ultimos-entrenamientos">
                        <h2>ultimos entrenamientos realizados</h2>
                        <div class="entrenamiento-realizado">
                            
                            <p><%=ent1.getNombre()%></p>
                            <div class="datos-realizacion">
                                <p><%=realiz1.getFecha()%></p>
                                <p><%=realiz1.getHora()%></p>
                            </div>
                        </div>
                        <div class="entrenamiento-realizado">
                            <p><%=ent2.getNombre()%></p>
                            <div class="datos-realizacion">
                                <p><%=realiz2.getFecha()%></p>
                                <p><%=realiz2.getHora()%></p>
                            </div>
                        </div>
                        <div class="entrenamiento-realizado">
                            <p><%=ent3.getNombre()%></p>
                            <div class="datos-realizacion">
                                <p><%=realiz3.getFecha()%></p>
                                <p><%=realiz3.getHora()%></p>
                            </div>
                            
                        </div>

                            
                    </div>
                    <div id="ayuda">
                        <form action="ChatServl" method="post">
                        <h2>no encuentras lo que buscas?</h2>
                        <p>escribe lo que quieres hacer en la aplicacion y te ayudaremos</p>
                        <textarea name="chat" rows="6" cols="40"></textarea>
                        <p class="boton-centrar-nuevo"> <input type="submit" name="submit" value="aplicar"  ></p>
                        </form>
                    </div>

                </div>
        

        </div>
    </div>


    

    
    
</body>
</html>


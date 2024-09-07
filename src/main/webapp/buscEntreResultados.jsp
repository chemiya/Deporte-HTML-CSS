<%-- 
    Document   : verArray
    Created on : 30-abr-2022, 16:04:03
    Author     : chemi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <%@page import="modelo.Entrenamiento"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <%

        ArrayList<Entrenamiento> list = new ArrayList<Entrenamiento>();
        list = (ArrayList<Entrenamiento>) request.getAttribute("entrenamientos");
        pageContext.setAttribute("entrenamientos", list);
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="inicialSin.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200&display=swap" rel="stylesheet">
    
    </head>
    <body>
        
        
         <h1 class="titulo-pagina">Buscador de entremientos</h1>
    
    <form action="BuscarEntrenamientoServlet" method="get">
       <div id="contenedor">
        <div class="seccion">
            <label>selecciona area objetivo</label>
            <select id="parte1" name="parte1">
                <option>cuerpo entero</option>
                <option>parte superior</option>
                <option>parte inferior</option>
                <option>brazos</option>
                <option>pecho</option>
            </select>
        </div> 
        
        <div class="seccion">
            <label>selecciona minutos</label>
            <select id="parte1" name="parte2">
                <option>5</option>
                <option>10</option>
                <option>20</option>
                <option>30</option>
                <option>40</option>
                <option>50</option>
                <option>60</option>
            </select>
        </div>
        <div class="seccion">
            <label>selecciona material</label>
            <select id="parte1" name="parte3">
                <option>pesas</option>
                <option>bandas elasticas</option>
                <option>balon medicinal</option>
            </select>
        </div>
        <div class="seccion">
            <label>selecciona dificultad</label>
            <select id="parte1" name="parte4">
                <option>suave</option>
                <option>moderado</option>
                <option>intenso</option>
            </select>
        </div>
            </div>
        <p class="boton-centrar-nuevo"><input type="submit" value="buscar"></p>
        </form>
    
        <div id="resultados">
        <h1 class="titulo-pagina"> Resultados de la busqueda</h1>
        <div id="resultados-busqueda">
            <c:forEach items="${entrenamientos}" var="current">
            <div class="entrenamiento">
                <img src="ImagenEntrenamiento?nombre=${current.nombre}">
                <div class="texto-entrenamiento">
                    <a href="SeleccionarEjerServ?idEntrenamiento=${current.idEntrenamiento}"><c:out value="${current.nombre}" /></a>
                    <div class="descripcion">
                        <p><c:out value="${current.duracion}" /> minutos</p>
                        <p><c:out value="${current.dificultad}"/> </p>
                        <p><%=request.getAttribute("area")%> </p>
                        <p><%=request.getAttribute("material")%>  </p>
                    </div>
                    
                </div>
               
            </div>
                        
             </c:forEach>
        </div><!-- comment -->
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

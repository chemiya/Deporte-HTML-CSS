<%-- 
    Document   : buscarPlanResultados
    Created on : 04-may-2022, 10:06:53
    Author     : chemi
--%>

<%@page import="modelo.PlanEntrenamientos"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="inicialSin.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200&display=swap" rel="stylesheet">
     
</head>
<body>

     <%

        ArrayList<PlanEntrenamientos> list = new ArrayList<PlanEntrenamientos>();
        list = (ArrayList<PlanEntrenamientos>) request.getAttribute("planes");
        pageContext.setAttribute("planes", list);
    %>
    <h1 class="titulo-pagina">Buscador de programas de entrenamiento</h1>
    <div id="contenedor">
         <form action="BuscarPlanServlet" method="get">
        <div class="seccion">
            <label>selecciona palabras clave</label>
            <select id="parte1" name="palabra">
                <option>adelgazar</option>
                <option>masa muscular</option>
                <option>brazos</option>
                
            </select>
        </div>
        <div class="seccion">
            <label>selecciona dias</label>
            <select id="parte1" name="dias">
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
                <option>10</option><!-- comment -->
                 <option>11</option>
                  <option>12</option>
                   <option>13</option>
                    <option>14</option>
                     <option>15</option>
            </select>
        </div>
        <div class="seccion">
            <label>selecciona valoracion media</label>
            <select id="parte1" name="valoracion">
                <option>superior a 9</option>
                <option>entre 8 y 9</option>
                <option>entre 7 y 8</option>
            </select>
        </div>
        

             <p class="boton-centrar-nuevo"><input type="submit" value="buscar"></p>
         </form>
    </div>

    <div id="resultados">
        <h1 class="titulo-pagina"> Resultados de la busqueda</h1>
        
        <div id="resultados-busqueda">
            <c:forEach items="${planes}" var="current">
            <div class="entrenamiento">
               
                <div class="texto-entrenamiento">
                    <a href="SeleccionarPlanServ?idPlan=${current.idPlan}"><c:out value="${current.nombre}" /></a>
                    <div class="descripcion">
                        
                        <p><c:out value="${current.duracion}" /> dias</p>
                        <p><c:out value="${current.descripcion}" /> </p>
                        <p><c:out value="${current.valoracion}" /> </p>
                    </div>
                    
                </div>
               
            </div>
            </c:forEach>
           
               
            
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

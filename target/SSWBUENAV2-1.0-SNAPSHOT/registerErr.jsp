<%-- 
    Document   : register
    Created on : 26 abr. 2022, 19:18:00
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="inicialSin.css">
        <link rel="stylesheet" href="login.css">
    </head>
    <body>
        <header>
            <div class="container">
                <img src="fotos/iconouvafit.JPG">
                <!--titulo y nav con los elementos-->
                <nav>
                <a href="index.html">&lt; Atr&aacute;s</a>
                </nav>
            </div>
        </header>
        <!--<div class="topnav">
            <a href="index.html">&LT; Back</a>
        </div>-->
        <div class="login-form">
            <h1>Registro</h1>
            <form action="RegisterServlet" method="post">
                <p id="error"><%= request.getAttribute("error") %></p>
                <label>Nombre: </label>
                <input type="text" placeholder="Nombre" name="nombre">
                <label>Apellidos: </label>
                <input type="text" placeholder="Apellidos" name="apellidos">
                
                <label>Usuario: </label>
                <input type="text" placeholder="Usuario" name="user">
                
                <label>Correo electr&oacute;nico: </label>
                <input type="text" placeholder="correo@ejemplo.com" name="email">
                
                <label>Contrase&ntilde;a: </label>
                <input type="password" placeholder="Contrase&ntilde;a" name="password">
                
                <label>D&iacute;a de nacimiento: </label>
                <input type="date" id="nacimiento" min="1900-01-01" max="2022-03-15" name="fechaNac">
                
                <label>G&eacute;nero</label>
                <select id="genero" name="genero">
                    <option value="HOMBRE">Hombre</option>
                    <option value="MUJER">Mujer</option>
                </select>
                
                <div id="login-form-short">
                    <label>Peso (kg): </label>
                    <input type="text" placeholder="" name="peso">
                    <label>Altura (m): </label>
                    <input type="text" placeholder="" name="altura">
                </div>
                
                <label>Frecuencia con la que haces ejercicio: </label>
                <select id="frecuencia" name="frecuencia">
                    <option value="DIARIO">Todos los d&iacute;as</option>
                    <option value="SEMANAL">Semanalmente</option>
                    <option value="MENSUAL">Mensualmente</option>
                    <option value="NUEVO">Soy nuevo</option>
                </select>
                
                <label>¿Qu&eacute; raz&oacute;n te ha traido a esta p&aacute;gina?: </label>
                <select id="frecuencia" name="motivo">
                    <option value="PERDER_PESO">Perder peso</option>
                    <option value="GANAR_MUSC">Ganar musculatura</option>
                    <option value="MEJORAR_FORMA">Mejorar mi forma f&iacute;sica</option>
                    <option value="HACER_DEPORTE">Hacer Deporte</option>
                </select>
                
                <input type="submit" value="Registrar">
            </form>
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


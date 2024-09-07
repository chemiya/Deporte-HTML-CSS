<%-- 
    Document   : loginErr
    Created on : 18 abr. 2022, 17:14:16
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--link rel="stylesheet" href="login.css"-->
        <link rel="stylesheet" href="inicialSin.css">
    </head>
    <body>
        <header>
            <div class="container">
                <img src="fotos/iconouvafit.JPG">
                <!--titulo y nav con los elementos-->
                <nav>
                <a href="index.html">&lt; Atr&aacute;s</a>
                <a href="register.html">Crear Cuenta</a>
                </nav>
            </div>
        </header>
        <div class="login-form">
            <h1>Login</h1>
            <form action="LoginServlet" method="post">
                <p id="error"><%= request.getAttribute("error") %></p>
                <label>Usuario:</label>
                <input type="text" name="user" placeholder="Usuario">
                <label>Contrase&ntilde;a:</label>
                <input type="password" name="password" placeholder="Contrase&ntilde;a">
                <input type="submit" value="Entrar">
                <p>&iquest;No tienes cuenta? <a href="register.html">Reg&iacute;strate</a></p>
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


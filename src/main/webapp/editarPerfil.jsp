<%-- 
    Document   : editarPerfil
    Created on : 18 abr. 2022, 18:28:08
    Author     : Usuario
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="modelo.Usuario"%>
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
    <div id="foto-perfil">
        <img src="fotos/persona2.jpg">
        <input type="file">
    </div>
    
    <div id="modificaciones">
        <h1>datos de la cuenta</h1>
        <% Usuario user = (Usuario) request.getAttribute("usuario"); %>
        <form action ="editPerfServletUpdateDB" method="post">
        <div id="entradas">
            <%
                String error = (String) request.getAttribute("error");
                if(error == null) error = "";
            %>
            <%="<p id='error'>"+error+"</p>"%>
            <div class="form-group">
                <label>Nombre </label>
                <input type="text" name="nombre" value=<%=user.getNombre()%> >
            </div>
            <div class="form-group">
                <label>Apellidos </label>
                <input type="text" name="apellidos" value="<%=user.getApellidos()%>" >
            </div>
            <div class="form-group">
                <label>Nombre de usuario </label>
                <input type="text" name="user" value=<%=user.getUsername()%> >
            </div>
            <div class="form-group">
                <label>Email </label>
                <input type="mail" name="email" value=<%=user.getEmail()%>  >
            </div>
            <div class="form-group">
                <label>contraseña </label>
                <input type="password" name="password" value=<%=user.getPassword()%>>
            </div>
            <div class="form-group">
                <label>peso </label>
                <input type="number" name="peso" value=<%=Float.toString(user.getPeso())%> >
            </div>
            <div class="form-group">
                <label>altura </label>
                <input type="number" name="altura" value=<%=Float.toString(user.getAltura())%> >
            </div>
            <div class="form-group">
                <label>fecha de nacimiento </label>
                <input type="date" name="fechaNac" value=<%=new SimpleDateFormat("yyyy-MM-dd").format(user.getNacimiento())%> >
            </div>
    
    
            <div id="guardar">
                <!--p>la contraseña seguira la misma si el campo de la contraseña permanece vacio</p-->
                <input type="submit" value="guardar cambios">
            </div>

        </div>
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

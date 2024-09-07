/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BaseDatos.DBRequest;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.*;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Si hay un usuario en la sesion, lo eliminamos.
        HttpSession sesion = request.getSession();
        sesion.removeAttribute("usuario");
        
        //Get parametros
        String name = request.getParameter("nombre");
        String surname = request.getParameter("apellidos");
        String usr = request.getParameter("user");
        String pass = request.getParameter("password");
        String email = request.getParameter("email");
        System.out.println(request.getParameter("fechaNac"));
        Date fechaNac;  
        try {
            fechaNac = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechaNac"));
        } catch (ParseException ex) {
            System.err.println("Formato de fecha incorrecto");
            request.setAttribute("error","El peso o la altura son incorrectos");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registerErr.jsp");
            dispatcher.forward(request, response); 
            fechaNac = new Date();
        }
        float peso = 0;
        float altura = 0;
        try{
            altura = Float.parseFloat(request.getParameter("altura"));
            peso = Float.parseFloat(request.getParameter("peso"));
        }
        catch(Exception e){
            System.err.println("Datos incorrectos");
            request.setAttribute("error","El peso o la altura son incorrectos");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registerErr.jsp");
            dispatcher.forward(request, response); 
            return;
        }
        Genero genero = Genero.valueOf(request.getParameter("genero"));
        Frecuencia frecEjerc = Frecuencia.valueOf(request.getParameter("frecuencia"));
        Motivo motivo = Motivo.valueOf(request.getParameter("motivo"));
        Rol rol = Rol.NORMAL; //El rol es normal para todos los usuarios creados desde la aplicacion.
        
        //Si los datos son invalidos (cadena vacía), mandamos error y recargamos
        //if(name.equals("") || surname.equals("") || usr.equals("") || pass.equals("") || email.equals("")){
        if(name.isEmpty() || surname.isEmpty() || usr.isEmpty() || pass.isEmpty() || email.isEmpty()){
            System.err.println("Hay uno o más campos sin rellenar");
            request.setAttribute("error","Hay uno o más campos sin rellenar");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registerErr.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        DBRequest dbrequest = new DBRequest();
        //Si el username ya está en la database, mandamos error y recargamos
        if(dbrequest.isInDatabase(usr)){
            request.setAttribute("error","Ese nombre de usuario ya esta en uso, elija otro");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registerErr.jsp");
            dispatcher.forward(request, response); 
            return;
        }
        else{
            Usuario user = new Usuario(name, surname, usr, pass, email, fechaNac, altura, peso, genero, frecEjerc, motivo, rol);
            //Subir el user a la DB
            //ConnectionPool pool = ConnectionPool.getInstance();
            //Connection connection = pool.getConnection(); //Establecer conexion con la DB
            try {
                dbrequest.userRegister(user);

                //Crear la pagina respuesta
                sesion.setAttribute("usuario",user);
                request.setAttribute("usuario",user);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.html");
                dispatcher.forward(request, response); 
            } catch (SQLException e) {
                System.err.println("No se pudo escribir a la base de datos");
                request.setAttribute("error","Se ha producido un error inesperado, por favor int&eacute;ntelo m&aacute;s tarde");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/registerErr.jsp");
                dispatcher.forward(request, response); 
            }
        }
    }
    
    /*private boolean isInDatabase(String usr){
        boolean isInDB=false;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection(); //Establecer conexion con la DB
        try {
            Statement statement = connection.createStatement();
            ResultSet users = statement.executeQuery(
        "SELECT * FROM usuario");
            while (users.next()) {
                String usrname = users.getString("username");
                if(usrname.equals(usr)){
                    isInDB = true;
                }
            }
        } catch (SQLException e) {
            System.err.println("No se pudo acceder a la base de datos");
        }
        return isInDB;
    }*/

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


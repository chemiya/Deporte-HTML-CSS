/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BaseDatos.ConnectionPool;
import BaseDatos.DBRequest;
import java.io.IOException;
import java.io.PrintWriter;
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
import modelo.Frecuencia;
import modelo.Genero;
import modelo.Motivo;
import modelo.Rol;
import modelo.Usuario;

/**
 *
 * @author Usuario
 */

@WebServlet(name = "editPerfServletUpdateDB", urlPatterns = {"/editPerfServletUpdateDB"})
public class editPerfServletUpdateDB extends HttpServlet {

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
        HttpSession sesion = request.getSession();
        
        //obtenemos el antiguo usuario y el nuevo
        Usuario olduser = (Usuario) sesion.getAttribute("usuario");
        String usrOld = olduser.getUsername();
        //Get parametros
        String name = request.getParameter("nombre");
        String surname = request.getParameter("apellidos");
        String usr = request.getParameter("user");
        String pass = request.getParameter("password");
        String email = request.getParameter("email");
        Date fechaNac;
        try {
            fechaNac = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fechaNac"));
        } catch (ParseException ex) {
            System.err.println("Formato de fecha incorrecto, se va a usar la fecha de hoy");
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
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editPerfServletGetData");
            dispatcher.forward(request, response); 
            return;
        }
        
        //Comprobamos que ningun dato es invalido (cadenas vacias)
        /*if(name.equals("") || surname.equals("") || usr.equals("") || pass.equals("") || email.equals("")){*/
        if(name.isEmpty() || surname.isEmpty()|| usr.isEmpty() || pass.isEmpty() || email.isEmpty()){
            System.err.println("Hay uno o más campos sin rellenar");
            request.setAttribute("usuario",olduser);
            request.setAttribute("error","Hay uno o más campos sin rellenar");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editarPerfil.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        //Si el nuevo username está ya en la base de datos, siendo este distinto al antiguo, mandamos error.
        DBRequest dbrequest = new DBRequest();
        if(!usrOld.equals(usr) && dbrequest.isInDatabase(usr)){
            request.setAttribute("usuario",olduser);
            request.setAttribute("error","Ese nombre de usuario ya esta en uso, elija otro");
            System.err.println("Ese nombre de usuario ya esta en uso, elija otro");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editarPerfil.jsp");
            dispatcher.forward(request, response);
        }
        //Si no, todo correcto, se actualiza la DB y se sale a la pagina principalRegistrado.jsp
        else{
            Usuario user = new Usuario(name, surname, usr, pass, email, fechaNac, altura, peso, null, null, null, null);
            //Subir el user a la DB
            //ConnectionPool pool = ConnectionPool.getInstance();
            //Connection connection = pool.getConnection(); //Establecer conexion con la DB
            try {
                dbrequest.updateUser(user, olduser);
                /*String query = "UPDATE usuario SET nombre = ?, apellidos = ?, username = ?, password = ?, email = ?, fechaNac = ?, altura = ?, peso = ?"+
                        "WHERE username = ?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, user.getNombre());
                ps.setString(2, user.getApellidos());
                ps.setString(3, user.getUsername());
                ps.setString(4, user.getPassword());
                ps.setString(5, user.getEmail());
                ps.setDate(6, new java.sql.Date(user.getNacimiento().getTime()));
                ps.setFloat(7, user.getAltura());
                ps.setFloat(8, user.getPeso());
                ps.setString(9, olduser.getUsername());

                System.out.println(ps.toString());
                int rowCount = ps.executeUpdate();*/

                //Crear la pagina respuesta
                sesion.setAttribute("usuario",user);
                request.setAttribute("usuario",user);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/principalRegistrado.jsp");
                dispatcher.forward(request, response);
                return;
            } catch (SQLException e) {
                //En caso de que no se pueda mandar la informacion a la DB, informar del error y recargar la página.
                e.printStackTrace();
                System.err.println("No se pudo escribir a la base de datos");
                request.setAttribute("error","No se pudo modificar la informaci&oacute;n. Intente de nuevo mas tarde.");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editPerfServletGetData");
                dispatcher.forward(request, response);
                return;
            }
        }
    }

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


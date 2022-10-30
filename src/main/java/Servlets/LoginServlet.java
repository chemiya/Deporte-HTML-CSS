/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BaseDatos.ConnectionPool;
import BaseDatos.DBRequest;
import BaseDatos.EntrenamientoDB;
import BaseDatos.HistorialDB;
import BaseDatos.RealizacionEntrenamientoDB;
import BaseDatos.UsuarioDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Entrenamiento;
import modelo.Frecuencia;
import modelo.Genero;
import modelo.Historial;
import modelo.Motivo;
import modelo.RealizacionEntrenamiento;
import modelo.Rol;
import modelo.Usuario;

/**
 *
 * @author chemi
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
        sesion.removeAttribute("usuario");
        String usr, pass;
        usr = request.getParameter("user");
        pass = request.getParameter("password");
        //Buscar en la DB el usuario
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection(); //Establecer conexion con la DB
        try {
            DBRequest dbrequest = new DBRequest();
            Usuario user = dbrequest.userLog(usr, pass);
            if(user == null){
                //El usuario no existe
                request.setAttribute("error","El usuario no es v&aacute;lido o no existe, por favor vuelve a intentarlo");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/loginErr.jsp");
                dispatcher.forward(request, response); 
                return;
            }
            else{
                //Todo correcto. Crear la pagina respuesta
                user.setUsername(usr);
                sesion.setAttribute("usuario",user);
                request.setAttribute("usuario",user);
                ArrayList<RealizacionEntrenamiento> obtenidoRealizados=RealizacionEntrenamientoDB.buscarResultadosEntrenamiento("2020-01-01",LocalDate.now().toString(),usr);
                 sesion.setAttribute("historialResumen",obtenidoRealizados);
                request.setAttribute("historialResumen",obtenidoRealizados);
              ArrayList<Entrenamiento>datosRealizados=new ArrayList<Entrenamiento>();
            for(int i=0;i<obtenidoRealizados.size();i++){
                RealizacionEntrenamiento real=obtenidoRealizados.get(i);
                Entrenamiento ent=EntrenamientoDB.asociarDatos(real.getIdEntrenamiento());
                datosRealizados.add(ent);
            }
            sesion.setAttribute("resumenEntrenamientos",datosRealizados);
                request.setAttribute("resumenEntrenamientos",datosRealizados);
                
                ArrayList<Entrenamiento>recomendados=new ArrayList<Entrenamiento>(); 
                recomendados=EntrenamientoDB.obtenerRecomendados();
                 sesion.setAttribute("entRecomendados",recomendados);
                request.setAttribute("entRecomendados",recomendados);
                
                UsuarioDB.actualizarHistorial(user);
                Historial hist=HistorialDB.obtenerHistorial(user.getUsername());
                   sesion.setAttribute("historial",hist);
                request.setAttribute("historial",hist);
                
                int admin=UsuarioDB.esAdmin(usr);
                sesion.setAttribute("admin",admin);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/principalRegistrado.jsp");
                dispatcher.forward(request, response); 
                
               
                
            } 
        } catch (SQLException e) {
            //La contraseña es incorrecta
            request.setAttribute("error","Se ha producido un error, por favor vuelve a intentarlo");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/loginErr.jsp");
            dispatcher.forward(request, response); 
        }
        catch (IllegalArgumentException e){
            //La conexión con la base de datos no se ha realizado
            request.setAttribute("error","La contrase&ntilde;a no es correcta, por favor vuelve a intentarlo");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/loginErr.jsp");
            dispatcher.forward(request, response);
        }
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*String user=request.getParameter("user");
         String password=request.getParameter("password");
      
       Usuario introducido=new Usuario();
       introducido.setUsername(user);
       introducido.setPassword(password);
       boolean correcto=UsuarioDB.comprobacion(introducido);
       
       if(correcto){
           String url="/principalRegistrado.jsp";
           Historial histUsuario=UsuarioDB.actualizarHistorial(introducido);
          
           HttpSession session = request.getSession();
        session.setAttribute("usuario", introducido);
         session.setAttribute("historial", histUsuario);
RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
dispatcher.forward(request, response);
       }*/
       
       
        
     
        
       
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

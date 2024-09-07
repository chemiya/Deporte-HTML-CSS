/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BaseDatos.RealizacionEntrenamientoDB;
import BaseDatos.EntrenamientoDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Entrenamiento;
import modelo.RealizacionEntrenamiento;
import modelo.Usuario;

/**
 *
 * @author chemi
 */
@WebServlet(name = "HistorialServl", urlPatterns = {"/HistorialServl"})
public class HistorialServl extends HttpServlet {

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
        String tipo=request.getParameter("tipo");
        String inicio=request.getParameter("inicio");
        String fin=request.getParameter("fin");
        HttpSession misession= (HttpSession) request.getSession();
        Usuario user=(Usuario)misession.getAttribute("usuario");
        String username=user.getUsername();
        
        //suponiendo username='chemiya11' habria que obtener el username del usuario que este
       
       
        
        
        if(tipo.equals("entrenamiento")){
            ArrayList<RealizacionEntrenamiento> obtenidoRealizados=RealizacionEntrenamientoDB.buscarResultadosEntrenamiento(inicio,fin,username);
             ArrayList<Entrenamiento>datosRealizados=new ArrayList<Entrenamiento>();
            for(int i=0;i<obtenidoRealizados.size();i++){
                RealizacionEntrenamiento real=obtenidoRealizados.get(i);
                Entrenamiento ent=EntrenamientoDB.asociarDatos(real.getIdEntrenamiento());
                datosRealizados.add(ent);
            }
            
            
           
            HttpSession session = request.getSession();
request.setAttribute("realizaciones", obtenidoRealizados);
request.setAttribute("datosEntrenamientos", datosRealizados);


// forward the request and response to the view
RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/historialMostrar.jsp");
dispatcher.forward(request, response);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BaseDatos.EjecuccionDB;
import BaseDatos.EjercicioDB;
import BaseDatos.EntrenamientoDB;
import BaseDatos.ValoracionEntrenamientoDB;
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
import modelo.Ejecuccion;
import modelo.Ejercicio;
import modelo.Entrenamiento;
import modelo.ValoracionEntrenamiento;

/**
 *
 * @author chemi
 */
@WebServlet(name = "SeleccionarEjerServ", urlPatterns = {"/SeleccionarEjerServ"})
public class SeleccionarEjerServ extends HttpServlet {

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
          String idEntrenamiento = request.getParameter("idEntrenamiento");
           Entrenamiento entrenamientoSelec=new Entrenamiento();
        entrenamientoSelec.setIdEntrenamiento(Integer.parseInt(idEntrenamiento));
        entrenamientoSelec=EntrenamientoDB.asociarDatos(entrenamientoSelec.getIdEntrenamiento());
        
        ArrayList<Ejercicio> ejerciciosIncluidos=new ArrayList<Ejercicio>();
         ArrayList<Ejecuccion> ejecuccionEjercicios=new ArrayList<Ejecuccion>();
         ejecuccionEjercicios=EjecuccionDB.obtenerEjecucciones(idEntrenamiento);
        for(int i=0;i<ejecuccionEjercicios.size();i++){
            Ejercicio ejer=EjercicioDB.asociarDatos(ejecuccionEjercicios.get(i).getIdEjercicio());
            ejerciciosIncluidos.add(ejer);
        }
       
         ArrayList<ValoracionEntrenamiento> valoraciones=new ArrayList<ValoracionEntrenamiento>();
        valoraciones=ValoracionEntrenamientoDB.buscar(idEntrenamiento);
       
         HttpSession session = request.getSession();
         session.setAttribute("entrenamientoSelec", entrenamientoSelec);
         request.setAttribute("ejerciciosIncluidos",ejerciciosIncluidos);
          request.setAttribute("ejecuccionEjercicios",ejecuccionEjercicios);
          request.setAttribute("valoraciones",valoraciones);
         
          RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/descripcionEjer.jsp");
dispatcher.forward(request, response);
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

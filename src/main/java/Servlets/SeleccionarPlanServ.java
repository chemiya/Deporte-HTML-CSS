/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BaseDatos.EjecuccionDB;
import BaseDatos.EjercicioDB;
import BaseDatos.EntrenamientoDB;
import BaseDatos.PlanEntrenamientoDB;
import BaseDatos.PlanificacionDB;
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
import modelo.PlanEntrenamientos;
import modelo.Planificacion;

/**
 *
 * @author chemi
 */
@WebServlet(name = "SeleccionarPlanServ", urlPatterns = {"/SeleccionarPlanServ"})
public class SeleccionarPlanServ extends HttpServlet {

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
        String idPlan = request.getParameter("idPlan");
        
        int idPlan1=Integer.parseInt(idPlan);
           PlanEntrenamientos planSelec=new PlanEntrenamientos();
        planSelec.setIdPlan(idPlan1);
       
        planSelec=PlanEntrenamientoDB.asociarDatos(planSelec.getIdPlan());
        
        
     
        
         ArrayList<Entrenamiento> entrenamientosIncluidos=new ArrayList<Entrenamiento>();
         ArrayList<Planificacion> planificacionEntrenamientos=new ArrayList<Planificacion>();
         planificacionEntrenamientos=PlanificacionDB.obtenerPlanificaciones(idPlan);
        for(int i=0;i< planificacionEntrenamientos.size();i++){
            Entrenamiento ent=EntrenamientoDB.asociarDatos(planificacionEntrenamientos.get(i).getIdEntrenamiento());
            entrenamientosIncluidos.add(ent);
        }
       
        
       
         HttpSession session = request.getSession();
         request.setAttribute("entrenamientosIncluidos", entrenamientosIncluidos);
         request.setAttribute("planificacionEntrenamientos",planificacionEntrenamientos);
          request.setAttribute("planSeleccionado",planSelec);
         
          RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/programaDesc.jsp");
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

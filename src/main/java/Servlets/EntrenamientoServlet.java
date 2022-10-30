/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BaseDatos.EjecuccionDB;
import BaseDatos.EjercicioDB;
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
import modelo.Ejecuccion;
import modelo.Ejercicio;
import modelo.Entrenamiento;

/**
 *
 * @author chemi
 */
@WebServlet(name = "EntrenamientoServlet", urlPatterns = {"/EntrenamientoServlet"})
public class EntrenamientoServlet extends HttpServlet {

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
        int nEjerc=0;
        int idEntrenamiento=0;
        if(sesion.getAttribute("nEjerc")!=null){
            nEjerc= (int)sesion.getAttribute("nEjerc") + 1;
             
            
        }
        
        //idEntrenamiento=Integer.parseInt(request.getParameter("idEntrenamiento"));
        
       idEntrenamiento=1;
        
        
        Entrenamiento entren = EntrenamientoDB.asociarDatos(idEntrenamiento); //Usamos un id de entrenamiento predefinido como placeholder
        
        ArrayList<Ejecuccion> ejerc1 = EjecuccionDB.getEjercicios(idEntrenamiento);
         /*try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>"+entren.getNombre()+"  "+ejerc.size());
            
        }*/
         
         ArrayList<Ejercicio> ejerc = new ArrayList<Ejercicio>();
         for(int i=0;i<ejerc1.size();i++){
             Ejecuccion ejecuccion=(Ejecuccion)ejerc1.get(i);
             Ejercicio anadir=EjercicioDB.asociarDatos(ejecuccion.getIdEjercicio());
             anadir.setDuracion(ejecuccion.getDuracion());
             anadir.setVideoUrl("sssdf");
             ejerc.add(anadir);
             
         }
         
         /*try (PrintWriter out = response.getWriter()) {
           for(int i=0;i<ejerc.size();i++){
               Ejercicio ej=(Ejercicio)ejerc.get(i);
               out.println("<!DOCTYPE html>"+ej.getNombre()+"  "+ej.getDescripcion()+"  "+ej.getIdEjercicio()+"  "+ej.getDuracion()+"  "+ej.getVideoUrl());
           }
            
            
        }*/
         
        
         
         /*
        Ejercicio tmpEjerc=new Ejercicio();
         tmpEjerc.setNombre("primero");
                        tmpEjerc.setDescripcion("desc");
                        tmpEjerc.setIdEjercicio(9);
                        tmpEjerc.setDuracion(23);
                        tmpEjerc.setVideoUrl("sssd");
                        ejerc.add(tmpEjerc);
                        
                         Ejercicio tmpEjerc1=new Ejercicio();
         tmpEjerc1.setNombre("seg");
                        tmpEjerc1.setDescripcion("desc1");
                        tmpEjerc1.setIdEjercicio(91);
                        tmpEjerc1.setDuracion(22);
                        tmpEjerc1.setVideoUrl("sssd1");
                        ejerc.add(tmpEjerc1);
         
         */
        
        if(nEjerc < ejerc.size()){
            sesion.setAttribute("entrenamiento", entren);
            request.setAttribute("entrenamiento", entren);
            request.setAttribute("ejercicio", ejerc.get(nEjerc));
            if(nEjerc < ejerc.size()-1){
                request.setAttribute("nextEjercicio", ejerc.get(nEjerc+1).getNombre());
            }
            else{
                request.setAttribute("nextEjercicio", "FIN");
            }
            sesion.setAttribute("nEjerc",nEjerc);
            response.setContentType("text/html;charset=UTF-8");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/entrenamiento.jsp");
            dispatcher.forward(request, response);
        }
        else{
            sesion.removeAttribute("entrenamiento");
            sesion.removeAttribute("nEjerc");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/principalRegistrado.jsp");
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

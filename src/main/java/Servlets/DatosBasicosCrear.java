/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BaseDatos.AreaDB;
import BaseDatos.EntrenamientoDB;
import BaseDatos.MaterialDB;
import modelo.AreaEntrenamiento;
import modelo.MaterialEntrenamiento;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Dificultad;
import modelo.Entrenamiento;
import modelo.Usuario;

/**
 *
 * @author chemi
 */
@WebServlet(name = "DatosBasicosCrear", urlPatterns = {"/DatosBasicosCrear"})
public class DatosBasicosCrear extends HttpServlet {

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
        String nombre=request.getParameter("nombre");
        String descripcion=request.getParameter("descripcion");
        String area=request.getParameter("area");
        String material=request.getParameter("material");
        String dificultad=request.getParameter("dificultad");
         String videoUrl=request.getParameter("videourl");
        Entrenamiento entrenamientoCreado=new Entrenamiento();
        entrenamientoCreado.setNombre(nombre);
        entrenamientoCreado.setDescripcion(descripcion);
        entrenamientoCreado.setVideoUrl(videoUrl);
        if(dificultad.equals("moderado")){
             entrenamientoCreado.setDificultad(Dificultad.MODERADO); 
        }else if(dificultad.equals("intenso")){
             entrenamientoCreado.setDificultad(Dificultad.INTENSO); 
        }else{
           entrenamientoCreado.setDificultad(Dificultad.SUAVE); 
        }
        
         HttpSession misession= (HttpSession) request.getSession();
          Usuario user=(Usuario)misession.getAttribute("usuario");
          entrenamientoCreado.setUsername(user.getUsername());
        //insertaria y obtendria id
        int idEntrenamiento=EntrenamientoDB.insert(entrenamientoCreado);
        entrenamientoCreado.setIdEntrenamiento(idEntrenamiento);
        
       
       /* try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>"+entrenamientoCreado.getNombre()+"  "+entrenamientoCreado.getDescripcion()+"  "+entrenamientoCreado.getVideoUrl()+"  "+entrenamientoCreado.getDificultad()+"  "+entrenamientoCreado.getUsername());
            
        }*/
        
        
        //AreaEntrenamiento areaEnt=new AreaEntrenamiento();
        //MaterialEntrenamiento materialEnt=new MaterialEntrenamiento();
        int idArea=AreaDB.obtenerID(area);
        int idMaterial=MaterialDB.obtenerID(material);
        AreaEntrenamiento areaEnt=new AreaEntrenamiento();
        areaEnt.setIdArea(idArea);
        areaEnt.setIdEntrenamiento(idEntrenamiento);
        MaterialEntrenamiento materialEnt=new MaterialEntrenamiento();
        materialEnt.setIdMaterial(idMaterial);
        materialEnt.setIdEntrenamiento(idEntrenamiento);
        AreaDB.insert(areaEnt);
        MaterialDB.insert(materialEnt);
        
        
        
       /* try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>"+idArea+"  "+idMaterial+"  "+descripcion+" "+area+"  "+material+"  "+dificultad);
            
        }*/
        HttpSession session = request.getSession();
        session.setAttribute("entrenamientoCreado", entrenamientoCreado);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/anadirEjercicios.jsp");
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

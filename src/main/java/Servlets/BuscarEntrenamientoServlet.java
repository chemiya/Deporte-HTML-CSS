/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java;

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

/**
 *
 * @author chemi
 */
@WebServlet(name = "BuscarEntrenamientoServlet", urlPatterns = {"/BuscarEntrenamientoServlet"})
public class BuscarEntrenamientoServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
    PrintWriter out = response.getWriter();
   
    String area=request.getParameter("area");
     String minutos=request.getParameter("minutos");
      String material=request.getParameter("material");
       String dificultad=request.getParameter("dificultad");
     
     /*out.println("<h1>HTML from servlet</h1>"+area);
      out.println("<h1>HTML from servlet</h1>"+minutos);
       out.println("<h1>HTML from servlet</h1>"+material);
       out.println("<h1>HTML from servlet</h1>"+dificultad);*/
       
     
    ArrayList<Entrenamiento> res=new ArrayList<Entrenamiento>();
            res=EntrenamientoDB.buscarSimilares(area,minutos,material,dificultad);
            //out.println("<h1>HTML from servlet</h1>"+res.size());
    
   /* for(int i=0;i<res.size();i++){
       
        Entrenamiento ver=res.get(i);
         out.println("<h1>HTML from servlet</h1>"+ver.getNombre());
    }*/
     request.setAttribute("entrenamientos", res);
     request.setAttribute("area", area);
     request.setAttribute("material", material);
            RequestDispatcher view = request.getRequestDispatcher("buscEntreResultados.jsp");
            view.forward(request, response);
   
    /*
String firstName = request.getParameter("firstName");
String lastName = request.getParameter("lastName");
String emailAddress = request.getParameter("emailAddress");
User user = new User();
user.setEmailAddress(emailAddress);
user.setFirstName(firstName);
user.setLastName(lastName);
String url = "";
if (UserDB.emailExists(user.getEmailAddress())) {
url = "/join_email_list.html";
} else {
UserDB.insert(user);
url = "/display_email_entry.jsp";
// store the user in the session
HttpSession session = request.getSession();
session.setAttribute("user", user);
}
// forward the request and response to the view
RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
dispatcher.forward(request, response);
*/} 
    
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */




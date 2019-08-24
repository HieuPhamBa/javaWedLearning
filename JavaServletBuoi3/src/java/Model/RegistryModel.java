/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import User.User;
import User.UserModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PhamBaHieu
 */
@WebServlet(name = "RegistryModel", urlPatterns = {"/RegistryModel"})
public class RegistryModel extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    User us = new User();
    UserModel usm = null;
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
             usm = new UserModel();
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String pass = request.getParameter("pass");
                String comfirm_pass = request.getParameter("comfir-pass");
                
                us.setEmail(email);
                us.setName(name);
                us.setPass(pass);
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Registry</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet Registry at " + request.getContextPath() + "</h1>");
                try {
                    if(pass.equals(comfirm_pass)){
                        if(usm.signUp(us)){
                            response.sendRedirect("index.jsp");
                        }else{
                            out.println("sign up failse");
                        }
                    }
                } catch (SQLException ex) {
                    out.print("Exceptoim form registry: "+ex.toString());
                }
                out.println("</body>");
                out.println("</html>");
            }
        }   catch (ClassNotFoundException ex) {
         
        } catch (SQLException ex) {
           
        }
    }

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

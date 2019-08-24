/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import User.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import User.UserModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PhamBaHieu
 */
@WebServlet(name  = "LoginServlet", urlPatterns = {"/Login"})
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
        String statusLogin = "";
         String pass = "";
         String email = "";
        try (PrintWriter out = response.getWriter()) {
            User ust = (User) request.getAttribute("user");
            if(ust==null){
                email =  request.getParameter("email");
                pass =  request.getParameter("pass");
            }
            else{
                email = ust.getEmail();
                pass = ust.getPass();
            }
            UserModel usm = null;
            try {
                /* TODO output your page here. You may use following sample code. */
                usm = new UserModel();
            } catch (ClassNotFoundException |SQLException ex) {
               out.print("alert(\""+ex.toString()+"\");");
            } 
         
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");  
             out.println("<link rel=\"stylesheet\" href=\"./Css/StyleGreeting.css\">"); 
            out.println("</head>");
            out.println("<body>");

            try {
                User us = usm.signIn(email, pass);
               if(us!=null){
                        out.println("<div class=\"container\">\n" +
                        "  <div class=\"card\">\n" +
                        "     <div class=\"card__image-container\">\n" +
                        "       <img class=\"card__image\" src=\"https://images.unsplash.com/photo-1519999482648-25049ddd37b1?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=2126&q=80\" alt=\"\">\n" +
                        "    </div>\n" +
                        "      \n" +
                        "      <svg class=\"card__svg\" viewBox=\"0 0 800 500\">\n" +
                        "\n" +
                        "        <path d=\"M 0 100 Q 50 200 100 250 Q 250 400 350 300 C 400 250 550 150 650 300 Q 750 450 800 400 L 800 500 L 0 500\" stroke=\"transparent\" fill=\"#333\"/>\n" +
                        "        <path class=\"card__line\" d=\"M 0 100 Q 50 200 100 250 Q 250 400 350 300 C 400 250 550 150 650 300 Q 750 450 800 400\" stroke=\"pink\" stroke-width=\"3\" fill=\"transparent\"/>\n" +
                        "      </svg>\n" +
                        "    \n" +
                        "     <div class=\"card__content\">\n" +
                        "       <h1 class=\"card__title\">Hello "+us.getName()+"</h1>\n" +
                        "     <p>Email: "+us.getEmail()+"</p>\n" +
                        "     <p>ID:    "+us.getId()+"</p>\n" +
                        "    </div>\n" +
                        "  </div>\n" +
                        "</div>");
               }
                else{
                    out.println("<script language=javascript");
                    out.println("alert( \' login failse messages\')");
                    out.println("</script>");
                    response.setStatus(response.SC_MOVED_TEMPORARILY);
                    response.setHeader("Location", "index.html?"+"false");
                }
            } catch (SQLException ex) {
               out.print("alert(\""+ex.toString()+"!!!\");");
            }
           
            out.println("</body>");
            out.println("</html>");
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

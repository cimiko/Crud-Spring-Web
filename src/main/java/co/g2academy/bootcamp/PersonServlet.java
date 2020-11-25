/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cimiko
 */
@WebServlet(name = "PersonServlet", urlPatterns = {"/person"})
public class PersonServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Person Data</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css\"\n" +
"        integrity=\"sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2\" crossorigin=\"anonymous\">");
            out.println("<link rel='stylesheet' href='css/style.css\'>");
            out.println("</head>");
            out.println("<body class='container-fluid'>");
            out.println("<nav class='navbar'>");
            out.println("<a class='navbar-brand' href='http://localhost:8080/bootcamp-java-web/'>");
            out.println("<img src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSRliDdW0n18MCieL74e0JTpjbVCh6F3fAvNw&usqp=CAU' width='30' height='30' class='d-inline-block align-top' alt='' loading='lazy'>CiMiKo</a>");
            out.println("</nav>");
            out.println("<video autoplay muted loop id='myVideo'>");
            out.println("<source src='video/TechnologyBG.mp4' type='video/mp4'>");
            out.println("</video>");
//            out.println("<h1>Servlet PersonServlet at " + request.getContextPath() + "</h1>");
            out.println("<h1>Hi user with ID:  " + request.getParameter("id") + " name "
                    + request.getParameter("name") + "</h1>");
            out.println("<h2>This request accept: " + request.getHeader("Accept") + "</h2>");
            
            Enumeration<String> headerNames = request.getHeaderNames();
            while(headerNames.hasMoreElements()){
                String header = headerNames.nextElement();
                out.println("<br/>" + header + " : " + request.getHeader(header));
            }
            
            //Create mew session
            HttpSession session = request.getSession();

            
            //Existing session
            HttpSession existingSession = request.getSession(false);
            
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

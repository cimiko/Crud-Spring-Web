/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.controller;

import co.g2academy.bootcamp.model.Authenticator;
import co.g2academy.bootcamp.model.LoginModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static co.g2academy.bootcamp.helper.ControllerHelper.*;
import static co.g2academy.bootcamp.helper.EncryptionHelper.encrypt;
import co.g2academy.bootcamp.model.LoginModelValidator;
import co.g2academy.bootcamp.model.sessionModel;
import javax.servlet.http.HttpSession;
/**
 *
 * @author cimiko
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    private static final String LOGIN_PAGE = "/view/login-view.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        //1. show login page
        //2. no logic at all
        dispatchToView(request, response, LOGIN_PAGE);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        Account account = accountModel.find(username);
        //1. maping antara model dengan request parameter
        LoginModel login = new LoginModel();
        login.setUserName(request.getParameter("userName"));
        login.setPassword(encrypt(request.getParameter("password")));
        HttpSession session=request.getSession(false);
        
        if(session != null){
            LoginModelValidator validator = new LoginModelValidator();
            if(validator.validate(login)){
                //2. Authenticate
                Authenticator authenticator = new Authenticator();
                if(authenticator.authenticate(login.getUserName(), login.getPassword())){
                    //3. send userName to JSP
                    sessionModel ses = new sessionModel();
                    ses.setName(login.getUserName());
                    session = request.getSession(true);
                    session.setAttribute("name", login.getUserName());
                    request.setAttribute("userName", login.getUserName());
                    //4. show login-success-view.jsp
                    dispatchToView(request, response, "/view/login-success-view.jsp");
                } else {
                    //5. show login-error-view if authentication process failed
                    if(!authenticator.authUser(login.getUserName())){
                    String error = "username is not registered, please register your account first!";
                    request.setAttribute("error", error);
                    request.setAttribute("userName", login.getUserName());
                    dispatchToView(request, response, LOGIN_PAGE);
                    }
                    dispatchToView(request, response, "/view/login-error-view.jsp");
                }
            }
            String error = "User Name should be valid email address " + "and enter the correct password!";
            request.setAttribute("error", error);
            request.setAttribute("userName", login.getUserName());
            dispatchToView(request, response, LOGIN_PAGE);
        }
        dispatchToView(request, response, LOGIN_PAGE);
    }
}

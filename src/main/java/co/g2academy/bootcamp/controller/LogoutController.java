package co.g2academy.bootcamp.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static co.g2academy.bootcamp.helper.ControllerHelper.dispatchToView;
import java.io.IOException;
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
@WebServlet(urlPatterns = {"/logout"})
public class LogoutController extends HttpServlet {
    private static final String LOGOUT_PAGE = "/view/login-view.jsp";



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        session.invalidate();
        dispatchToView(request, response, LOGOUT_PAGE);
    }
}

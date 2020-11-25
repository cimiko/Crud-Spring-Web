/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.controller;

import co.g2academy.bootcamp.model.RegistrationModel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static co.g2academy.bootcamp.helper.ControllerHelper.*;
import co.g2academy.bootcamp.entity.Person;
import static co.g2academy.bootcamp.helper.EncryptionHelper.encrypt;
import co.g2academy.bootcamp.model.Authenticator;
import co.g2academy.bootcamp.model.RegistrationModelValidator;
import co.g2academy.bootcamp.service.PersonService;

/**
 *
 * @author cimiko
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

    private static final String REGISTRATION_PAGE = "/view/register-view.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        dispatchToView(request, response, REGISTRATION_PAGE); 
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RegistrationModel registration = new RegistrationModel();
        registration.setUserName(request.getParameter("userName"));
        registration.setPassword(request.getParameter("password"));
        registration.setConfirmPassword(request.getParameter("confirmPassword"));
        
//        Person person = new Person();
//        person.setName(registration.getUserName());
//        person.setPassword(registration.getPassword());
//        PersonService service = new PersonService(); 
//        service.save(person);
//        dispatchToView(request, response, "/view/register-success-view.jsp");
        
        RegistrationModelValidator validator = new RegistrationModelValidator();
        if(validator.validate(registration)){
            Authenticator authenticator = new Authenticator();
            if(authenticator.authUser(registration.getUserName())){
                String error = "username already registered, try using another username.";
                request.setAttribute("error", error);
                request.setAttribute("userName", registration.getUserName());
                dispatchToView(request, response, REGISTRATION_PAGE);
            }
            Person person = new Person();
            person.setName(registration.getUserName());
            person.setPassword(encrypt(registration.getPassword()));
        
            PersonService service = new PersonService();
            Person p = service.save(person);
            dispatchToView(request, response, "/view/register-success-view.jsp");
            if(p != null){
                return;
            }
        }else if(validator.validateEmail(registration)){
            String error = "User Name should be valid email address.";
            request.setAttribute("error", error);
            request.setAttribute("userName", registration.getUserName());
            dispatchToView(request, response, REGISTRATION_PAGE);
        }else if(validator.validatePassword(registration)){
            String error = "Password and confirm password must be the same.";
            request.setAttribute("error", error);
            request.setAttribute("userName", registration.getUserName());
            dispatchToView(request, response, REGISTRATION_PAGE);
        }
        String error = "User Name should be valid email address " + "and password should match";
        request.setAttribute("error", error);
        request.setAttribute("userName", registration.getUserName());
        dispatchToView(request, response, REGISTRATION_PAGE);
    }  
    


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

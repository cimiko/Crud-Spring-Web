/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.controller;

import co.g2academy.bootcamp.entity.Person;
import static co.g2academy.bootcamp.helper.ControllerHelper.dispatchToView;
import static co.g2academy.bootcamp.helper.EncryptionHelper.encrypt;
import co.g2academy.bootcamp.model.UpdateModel;
import co.g2academy.bootcamp.model.UpdateModelValidator;
import co.g2academy.bootcamp.service.PersonService;
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
@WebServlet(name = "PersonUpdateController", urlPatterns = {"/update"})
public class PersonUpdateController extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session=request.getSession();
        if(session.getAttribute("name") != null){
            Integer id = Integer.parseInt(request.getParameter("id"));
            PersonService service = new PersonService();
            Person person = service.getPersonById(id);
        
            if(person != null){
                request.setAttribute("person", person);
                dispatchToView(request, response, "/view/update.jsp");
            }else{
                dispatchToView(request, response, "/view/update-error.jsp");
            }
        }
        dispatchToView(request, response, "/view/login-view.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        UpdateModel model = new UpdateModel();
        model.setId(Integer.valueOf(request.getParameter("id")));
        model.setName(request.getParameter("name"));
        model.setPassword(request.getParameter("password"));
        model.setConfirmPassword(request.getParameter("confirmPassword"));
        
//        PersonService service = new PersonService();
//        Person person = service.getPersonById(model.getId());
//        person.setPassword(model.getPassword());
//        service.save(person);
//        dispatchToView(request, response, "/view/update-success.jsp");
        
        UpdateModelValidator validator = new UpdateModelValidator();
        if(validator.validate(model)){
            PersonService service = new PersonService();
            Person person = service.getPersonById(model.getId());
            if(person != null){
                person.setPassword(encrypt(model.getPassword()));
                if(service.save(person) != null){
                    dispatchToView(request, response, "/view/update-success.jsp");
                    return;
                }
            }
            request.setAttribute("error", "Person you try to update is not avaible");
            dispatchToView(request, response, "/view/update-error.jsp");
            return;
        }
        request.setAttribute("error", "Password is empty or did not match");
        request.setAttribute("person", model);
        dispatchToView(request, response, "/view/update.jsp");

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

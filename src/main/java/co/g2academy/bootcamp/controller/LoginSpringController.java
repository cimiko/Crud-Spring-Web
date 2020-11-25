/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.controller;

import co.g2academy.bootcamp.entity.Person;
import co.g2academy.bootcamp.model.Authenticator;
import co.g2academy.bootcamp.model.sessionModel;
import co.g2academy.bootcamp.service.PersonSpringJdbcService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author cimiko
 */
@Controller
public class LoginSpringController {
    
    @Autowired
    private PersonSpringJdbcService personService;
    
    @RequestMapping(method = RequestMethod.POST, value = "/login-spring-mvc")
    public ModelAndView login(
            @RequestParam String userName, 
            @RequestParam String password, 
            ModelAndView mv, HttpServletRequest request){
        Authenticator authenticator = new Authenticator();
        Person person = personService.getByUserName(userName);
        HttpSession session=request.getSession(false);
        
        if(authenticator.authenticateSpring(userName, password, person)){
            sessionModel ses = new sessionModel();
            ses.setName(userName);
            session = request.getSession(true);
            session.setAttribute("name", userName);
            mv.addObject("userName", userName);
            mv.setViewName("login-success-view");
            return mv;
        }
        mv.setViewName("login-error-view");
        return mv;
    }
    
}

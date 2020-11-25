/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.model;

import java.util.regex.Pattern;

/**
 *
 * @author cimiko
 */
public class LoginModelValidator {
    public Boolean validate(LoginModel model){
        return validateUserNameAsEmailAddress(model)
                && validatePassword(model);
    }
    
    public Boolean validateUserNameAsEmailAddress(LoginModel model){
        //regex
        String regex = "^.(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(model.getUserName()).matches();
    }
    
    public Boolean validatePassword(LoginModel model){
        return model.getPassword() != null
                && model.getPassword().trim().length() > 0;
    }
    
}

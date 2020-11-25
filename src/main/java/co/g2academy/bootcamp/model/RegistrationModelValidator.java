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
public class RegistrationModelValidator {
    
    public Boolean validate(RegistrationModel model){
        return validateUserNameAsEmailAddress(model)
                && validatePasswordAndConfirmPasswordIsTheSame(model);
//        return validatePasswordAndConfirmPasswordIsTheSame(model);
    }
    
    public Boolean validatePassword(RegistrationModel model){
        return model.getPassword() != null
                || model.getConfirmPassword() != null
                || model.getPassword().trim().length() > 0
                || model.getConfirmPassword().trim().length() > 0
                || model.getPassword().equals(model.getConfirmPassword());
    }
    
    public Boolean validateEmail(RegistrationModel model){
        return !validateUserNameAsEmailAddress(model)
                && validatePasswordAndConfirmPasswordIsTheSame(model);
    }
    
    public Boolean validateUserNameAsEmailAddress(RegistrationModel model){
        //regex
        String regex = "^.(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(model.getUserName()).matches();
    }
    
    public Boolean validatePasswordAndConfirmPasswordIsTheSame(RegistrationModel model){
        return model.getPassword() != null
                && model.getConfirmPassword() != null
                && model.getPassword().trim().length() > 0
                && model.getConfirmPassword().trim().length() > 0
                && model.getPassword().equals(model.getConfirmPassword()); 
    }
    
}

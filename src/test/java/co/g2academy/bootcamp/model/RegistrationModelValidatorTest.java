/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author cimiko
 */
public class RegistrationModelValidatorTest {
    
    private final RegistrationModelValidator validator = new RegistrationModelValidator();
    private final RegistrationModel model;
    private final RegistrationModel invalidModel = new RegistrationModel();
    
    public RegistrationModelValidatorTest(){
        model = new RegistrationModel();
        model.setUserName("hartono@mail.com");
        model.setPassword("cimz123");
        model.setConfirmPassword("cimz123");
    }
    
    @Test
    public void testValidate(){
        Boolean actual = validator.validate(model);
        assertTrue(actual);
    }
    
    @Test
    public void testValidateUserNameAsEmailAddress(){
        Boolean actual = validator.validateUserNameAsEmailAddress(model);
        assertTrue(actual);
    }
    
    @Test
    public void testValidateUserNameNotEmailAddress(){
        invalidModel.setUserName("hartono");
        Boolean actual = validator.validateUserNameAsEmailAddress(invalidModel);
        assertFalse(actual);
    }
    
    @Test
    public void testPasswordAndConfirmPasswordIsTheSame(){
        Boolean actual = validator.validatePasswordAndConfirmPasswordIsTheSame(model);
        assertTrue(actual);
    }
    
    @Test
    public void testPasswordAndConfirmPasswordIsNotTheSame(){
        invalidModel.setPassword("cimz123");
        invalidModel.setConfirmPassword("har123");
        Boolean actual = validator.validatePasswordAndConfirmPasswordIsTheSame(invalidModel);
        assertFalse(actual);
    }
    
}

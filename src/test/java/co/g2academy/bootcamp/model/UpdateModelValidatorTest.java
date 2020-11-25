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
public class UpdateModelValidatorTest {
    private final UpdateModelValidator validator = new UpdateModelValidator();
    private final UpdateModel model = new UpdateModel();
    
    @Test
    public void testValidate(){
        model.setPassword("pwd");
        model.setConfirmPassword("pwd");
        Boolean actual = validator.validate(model);
        assertTrue(actual);
    }
    
    @Test
    public void testPasswordNotMatchValidation(){
        model.setPassword("pwd");
        model.setConfirmPassword("pwd123");
        Boolean actual = validator.validate(model);
        assertFalse(actual);
    }
    
    @Test
    public void testPasswordIsEmptyValidation(){
        model.setPassword("");
        model.setConfirmPassword("");
        Boolean actual = validator.validate(model);
        assertFalse(actual);
    }
    
}

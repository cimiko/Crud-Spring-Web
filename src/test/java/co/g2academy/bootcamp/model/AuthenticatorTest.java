/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cimiko
 */
public class AuthenticatorTest {
    
    public AuthenticatorTest() {
    }

    @Test
    public void testAuthenticate() {
        Authenticator authenticator = new Authenticator();
        Boolean actual = authenticator.authenticate("cimiko", "pwd123");
//        assertTrue(actual);

    }
    
}

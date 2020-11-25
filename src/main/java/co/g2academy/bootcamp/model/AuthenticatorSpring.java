/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.model;

import co.g2academy.bootcamp.entity.Person;
import co.g2academy.bootcamp.helper.EncryptionHelper;

/**
 *
 * @author cimiko
 */
public class AuthenticatorSpring {
    public Boolean authenticate(String userName, String password, Person person){
        return person != null
                && userName.equalsIgnoreCase(person.getName())
                && EncryptionHelper.match(password, person.getPassword());
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.model;
import co.g2academy.bootcamp.entity.Person;
import co.g2academy.bootcamp.helper.EncryptionHelper;
import co.g2academy.bootcamp.service.PersonService;

/**
 *
 * @author cimiko
 */
public class Authenticator {
    
    public Boolean authenticate(String userName, String password){
        PersonService personService = new PersonService();

        Person person = personService.getPersonByUserName(userName);
        return person != null
            && userName.equalsIgnoreCase(person.getName())
            && password.equalsIgnoreCase(person.getPassword());
    }
    
    public Boolean authenticateSpring(String userName, String password, Person person){
        return person != null
                && userName.equalsIgnoreCase(person.getName())
                && EncryptionHelper.match(password, person.getPassword());
    }
    
    public Boolean authUser(String userName){
        PersonService personService = new PersonService();
        
        Person person = personService.getPersonByUserName(userName);
        return person != null
                && userName.equalsIgnoreCase(person.getName());
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.service;

import co.g2academy.bootcamp.entity.Person;
import java.util.List;

/**
 *
 * @author cimiko
 */
public interface PersonSpringJdbcService {
    
    Person save(Person p);
    
    Person delete(Person p);
    
    Person getById(Integer id);
    
    Person getByUserName(String userName);
    
    List<Person> getAll();
    
}

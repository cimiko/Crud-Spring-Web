/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.service.impl;

import co.g2academy.bootcamp.dao.PersonSpringDaoJdbc;
import co.g2academy.bootcamp.entity.Person;
import co.g2academy.bootcamp.service.PersonSpringJdbcService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cimiko
 */
@Service
public class PersonSpringJdbcServiceImplementation implements PersonSpringJdbcService{

    @Autowired
    private PersonSpringDaoJdbc personDao;
    
    @Override
    @Transactional
    public Person save(Person p) {
        return personDao.save(p);
    }

    @Override
    @Transactional
    public Person delete(Person p) {
        return personDao.delete(p);
    }

    @Override
    public Person getById(Integer id) {
        return personDao.getById(id);
    }

    @Override
    public Person getByUserName(String userName) {
        return personDao.getByUserName(userName);
    }

    @Override
    public List<Person> getAll() {
        return personDao.getAll();
    }
    
}

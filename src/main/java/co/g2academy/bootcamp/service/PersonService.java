/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.service;

import co.g2academy.bootcamp.dao.PersonDaoJdbc;
import co.g2academy.bootcamp.entity.Person;
import co.g2academy.bootcamp.model.Authenticator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cimiko
 */
public class PersonService {
    //Load MySql driver
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException ex){
            Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //create singel connection
    private static Connection connection;
    public static Connection getConnection(){
        if(connection == null){
            try{
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/javabootcamp",
                        "root", "test1234");
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return connection;
    }
    
    //instantiate DAO during service instantiation
    private PersonDaoJdbc personDao;
    
    public PersonService(){
        try{
            this.personDao = new PersonDaoJdbc();
            personDao.setConnection(getConnection());
            
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public Person save(Person p){
        try{
            getConnection().setAutoCommit(false);
            personDao.save(p);
            getConnection().commit();
            
            //save second table
            
            //update table ke-3
            
            //delete table yang ke empat
            
            getConnection().setAutoCommit(true);
            return p;
        } catch (SQLException ex) {
            try{
                getConnection().rollback();
            }catch(SQLException rollbackException){
                rollbackException.printStackTrace();
            }
        }
        return null;
    }
    
    public Person delete(Person p){
        try{
            getConnection().setAutoCommit(false);
            personDao.delete(p);
            getConnection().commit();
            getConnection().setAutoCommit(true);
            return p;
        } catch (SQLException ex) {
            ex.printStackTrace();
            try{
                getConnection().rollback(); //rollback untuk mengundo coding bila terjadi error
            }catch(SQLException rollbackException){
                rollbackException.printStackTrace();
            }
        }
        return null;
    }
    
    public Person getPersonByUserName(String userName){
        try{
            return personDao.getByUserName(userName);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public Person getPersonById(Integer id){
        try{
            return personDao.getById(id);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Person> getPersons(){
        try{
            return personDao.getAll();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return Collections.emptyList();
    }
}

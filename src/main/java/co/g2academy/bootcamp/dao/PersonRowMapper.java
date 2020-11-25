/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.dao;

import co.g2academy.bootcamp.entity.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author cimiko
 */
public class PersonRowMapper implements RowMapper<Person>{
    
    @Override
        public Person mapRow(ResultSet rs, int i) throws SQLException {
            Person p = new Person();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setPassword(rs.getString("password"));
            return p;
        }
}

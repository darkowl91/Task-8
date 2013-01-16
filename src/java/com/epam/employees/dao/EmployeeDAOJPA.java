/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.dao;

import com.epam.employees.model.Entity;
import java.util.List;

/**
 *
 * @author Nickolay_Petrash
 */
public class EmployeeDAOJPA implements IEmployeeDAO<Entity> {

    @Override
    public List<Entity> getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

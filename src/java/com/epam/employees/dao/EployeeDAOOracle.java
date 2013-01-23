/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.dao;

import com.epam.employees.model.BaseEntity;
import java.util.List;

/**
 *
 * @author Nickolay_Petrash
 */
public class EployeeDAOOracle implements IEmployeeDAO<BaseEntity> {
    
    @Override
    public List<BaseEntity> getRecords(int firstRecNumber, int lastRecNumber) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.dao;

import com.epam.employees.model.BaseEntity;
import java.util.List;

/**
 *
 * @author Owl
 */
public interface IEmployeeDAO<T extends BaseEntity> {

    public List<T> getRecords(int firstRecNumber, int lastRecNumber);
}

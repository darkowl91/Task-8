/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.dao;

import com.epam.employees.model.BaseEntity;
import com.epam.employees.util.EntityManagerFactoryWrapper;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Nickolay_Petrash
 */
public class EmployeeDAOJPA implements IEmployeeDAO<BaseEntity> {

    private static final String NAMED_QUERY_GET_RECORDS = "employeeList";

    @Override
    public List<BaseEntity> getRecords(int firstRecNumber, int lastRecNumber) {
        List<BaseEntity> records = new ArrayList<>();
        EntityManager eManager = EntityManagerFactoryWrapper.getEntityManager();
        EntityTransaction transaction = eManager.getTransaction();
        transaction.begin();
        Query query = eManager.createQuery(NAMED_QUERY_GET_RECORDS);
        query.setFirstResult(firstRecNumber);
        query.setMaxResults(lastRecNumber);
        records = query.getResultList();
        return records;
    }
}

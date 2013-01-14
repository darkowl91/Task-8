/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.dao;

import com.epam.employees.model.Employee;
import com.epam.employees.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Owl
 */
public class EmployeeDAO implements IEmployeeDAO<Employee> {

    private static final int FIRST_RECORD_NUMBER = 1;
    private static final int LAST_RECORD_NUMBER = 100;
    private static final String LIST ="employeeList";

    @Override
    public List<Employee> getAll() {
        Session session = HibernateUtil.getSession();
        List<Employee> employees;
        Transaction transaction = null;
        try {
            transaction = session.getTransaction();
            transaction.begin();
            Query query = session.getNamedQuery(LIST);
            query.setCacheable(true);
            query.setFirstResult(FIRST_RECORD_NUMBER);
            query.setMaxResults(LAST_RECORD_NUMBER);
            employees = query.list();
            transaction.commit();
            return employees;
        } catch (HibernateException ex) {
            transaction.rollback();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}

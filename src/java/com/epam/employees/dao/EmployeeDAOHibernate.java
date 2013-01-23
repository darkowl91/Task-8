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
public class EmployeeDAOHibernate implements IEmployeeDAO<Employee> {

    private static final String LIST ="employeeList";

    @Override
    public List<Employee> getRecords(int firstRecNumber, int lastRecNumber) {
        Session session = HibernateUtil.getSession();
        List<Employee> employees;
        Transaction transaction = null;
        try {
            transaction = session.getTransaction();
            transaction.begin();
            Query query = session.getNamedQuery(LIST);
            query.setCacheable(true);
            query.setFirstResult(firstRecNumber);
            query.setMaxResults(lastRecNumber);
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

package com.epam.employees.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            /**
             * Create the SessionFactory from standard (hibernate.cfg.xml)
             * config file.
             */
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     *
     * @return SessionFactory from standard (hibernate.cfg.xml)
     */
    public static Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}

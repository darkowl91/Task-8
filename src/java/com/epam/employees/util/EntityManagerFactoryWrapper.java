package com.epam.employees.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author Nickolay_Petrash
 */
public final class EntityManagerFactoryWrapper {

    private static final String PERSISTENCE_UNIT = "EmployeesRPU";
    private static EntityManager entityManager;

    static {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
            entityManager = emf.createEntityManager();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }
}

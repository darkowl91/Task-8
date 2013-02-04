/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.dao;

import com.epam.employees.model.PersistentEntity;
import com.epam.employees.pagination.page.Page;
import com.epam.employees.util.EntityManagerFactoryWrapper;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Nickolay_Petrash
 */
public class JpaImpl<Entity extends PersistentEntity> implements
        PersistentEntityDAO<Entity> {

    @Override
    public Page<Entity> findByNamedQuery(int pageNumber, int pageSize, String queryName, Object... params) throws SQLException {
        EntityManager eManager = EntityManagerFactoryWrapper.getEntityManager();
        EntityTransaction entityTransaction = eManager.getTransaction();
        entityTransaction.begin();
//        
        
        
        
        
//        
        entityTransaction.commit();
        return null;
    }
}

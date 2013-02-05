/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.dao;

import com.epam.employees.model.PersistentEntity;
import com.epam.employees.pagination.page.Page;
import com.epam.employees.pagination.page.PageImpl;
import com.epam.employees.util.EntityManagerFactoryWrapper;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author Nickolay_Petrash
 */
public class JpaImpl<Entity extends PersistentEntity> implements
        PersistentEntityDAO<Entity> {

    private static final String COUNT_QNAME = ".count";

    @Override
    public Page<Entity> findByNamedQuery(int pageNumber, int pageSize, String queryName, Object... params) throws SQLException {
        EntityManager eManager = EntityManagerFactoryWrapper.getEntityManager();
        EntityTransaction entityTransaction = eManager.getTransaction();
        entityTransaction.begin();

        long totalNumberOfElements = getRowCount(eManager, queryName, params);
        Query query = eManager.createNamedQuery(queryName);
        setParameters(query, params);

        int firstResuIt = (pageNumber - 1) * pageSize;
        int maxResults = pageSize;

        query.setFirstResult(firstResuIt);
        query.setMaxResults(maxResults);

        List<Entity> contents = query.getResultList();

        Page page = new PageImpl(contents, pageNumber, pageSize, totalNumberOfElements);

        entityTransaction.commit();
        return page;
    }

    /**
     *
     * @param query
     * @param params
     */
    private void setParameters(Query query, final Object... params) {
        for (int index = 0; index < params.length; index++) {
            query.setParameter(index, params[index]);
        }
    }

    /**
     *
     * @param eManager
     * @param queryName
     * @param params
     * @return
     * @throws SQLException
     */
    private long getRowCount(final EntityManager eManager, final String queryName, final Object... params)
            throws SQLException {

        String rowCountQueryName = queryName + COUNT_QNAME;
        Query rowCountQuery = eManager.createNamedQuery(rowCountQueryName);
        setParameters(rowCountQuery, params);
        return ((Number)rowCountQuery.getSingleResult()).longValue();
    }
}

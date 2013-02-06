package com.epam.employees.dao;

import com.epam.employees.constants.DBConstants;
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
public final class JpaImpl<Entity extends PersistentEntity> implements
        PersistentEntityDAO<Entity> {

    @Override
    public Page<Entity> getPage(int pageNumber, int pageSize) throws SQLException {
        EntityManager eManager = EntityManagerFactoryWrapper.getEntityManager();
        EntityTransaction entityTransaction = eManager.getTransaction();
        entityTransaction.begin();

        long totalNumberOfElements = getRowCount(eManager, DBConstants.QUERY_NAME_EMPLOYEELIST);
        Query query = eManager.createNamedQuery(DBConstants.QUERY_NAME_EMPLOYEELIST);

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
     * get total number of records in db
     *
     * @param eManager
     * @param queryName
     * @param params
     * @return number of records
     * @throws SQLException
     */
    private long getRowCount(final EntityManager eManager, final String queryName)
            throws SQLException {

        String rowCountQueryName = queryName + DBConstants.COUNT_QNAME;
        Query rowCountQuery = eManager.createNamedQuery(rowCountQueryName);
        return ((Number) rowCountQuery.getSingleResult()).longValue();
    }
}

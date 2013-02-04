/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.dao.hibernate;

import com.epam.employees.dao.PersistentEntityDAO;
import com.epam.employees.model.PersistentEntity;
import com.epam.employees.pagination.page.Page;
import com.epam.employees.pagination.page.PageImpl;
import com.epam.employees.util.HibernateUtil;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Nickolay_Petrash
 */
public class PersistentEntityDaoImpl<Entity extends PersistentEntity> implements
        PersistentEntityDAO<Entity> {

    private static final String COUNT_QNAME = ".count";

    @Override
    public Page<Entity> findByNamedQuery(int pageNumber, int pageSize, String queryName, Object... params) throws SQLException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        Page page = null;
        try {
            transaction = session.getTransaction();
            transaction.begin();
            long totalNumberOfElements = getRowCount(session, queryName, params);

            Query query = getNamedQuery(session, queryName);
            setParameters(query, params);

            int firstResult = (pageNumber - 1) * pageSize;
            int maxResults = pageSize;

            query.setFirstResult(firstResult);
            query.setMaxResults(maxResults);

            List<Entity> contents = query.list();

            page = new PageImpl(contents, pageNumber, pageSize, totalNumberOfElements);
            transaction.commit();
            return page;
        } catch (HibernateException ex) {
            transaction.rollback();
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    /**
     *
     * @param session
     * @param queryName
     * @return
     */
    private Query getNamedQuery(final Session session, final String queryName) {
        try {
            return session.getNamedQuery(queryName);
        } catch (MappingException mappingException) {
            return null;
        }
    }

    /**
     *
     * @param query
     * @param params
     */
    private void setParameters(final Query query, final Object... params) {
        for (int index = 0; index < params.length; index++) {
            query.setParameter(index, params[index]);
        }
    }

    /**
     *
     * @param session
     * @param queryName
     * @param params
     * @return
     * @throws SQLException
     */
    private long getRowCount(final Session session, final String queryName, final Object... params)
            throws SQLException {

        String rowCountQueryName = queryName + COUNT_QNAME;
        Query rowCountQuery = getNamedQuery(session, rowCountQueryName);
        if (rowCountQuery == null) {
            rowCountQuery = getNamedQuery(session, queryName);
            setParameters(rowCountQuery, params);
            return rowCountQuery.list().size();
        } else {
            setParameters(rowCountQuery, params);
            return (Long) rowCountQuery.uniqueResult();
        }
    }
}

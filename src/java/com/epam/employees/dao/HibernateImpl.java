package com.epam.employees.dao;

import com.epam.employees.constants.DBConstants;
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
public final class HibernateImpl<Entity extends PersistentEntity> implements
        PersistentEntityDAO<Entity> {

    @Override
    public Page<Entity> getPage(int pageNumber, int pageSize) throws SQLException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        Page page = null;
        try {
            transaction = session.getTransaction();
            transaction.begin();
            long totalNumberOfElements = getRowCount(session, DBConstants.QUERY_NAME_EMPLOYEELIST);

            Query query = getNamedQuery(session, DBConstants.QUERY_NAME_EMPLOYEELIST);

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
     * @param session
     * @param queryName
     * @param params
     * @return
     * @throws SQLException
     */
    private long getRowCount(final Session session, final String queryName, final Object... params)
            throws SQLException {
        String rowCountQueryName = queryName + DBConstants.COUNT_QNAME;
        Query rowCountQuery = getNamedQuery(session, rowCountQueryName);
        if (rowCountQuery == null) {
            rowCountQuery = getNamedQuery(session, queryName);
            return rowCountQuery.list().size();
        } else {
            return (Long) rowCountQuery.uniqueResult();
        }
    }
}

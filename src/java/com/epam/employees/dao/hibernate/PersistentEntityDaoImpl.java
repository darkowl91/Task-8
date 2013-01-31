/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.dao.hibernate;

import com.epam.employees.dao.PersistentEntityDAO;
import com.epam.employees.model.PersistentEntity;
import com.epam.employees.pagination.page.Page;
import com.epam.employees.pagination.page.PageImpl;
import com.epam.employees.pagination.page.PageRequest;
import com.epam.employees.util.HibernateUtil;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.MappingException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Nickolay_Petrash
 */
public class PersistentEntityDaoImpl<Entity extends PersistentEntity> implements
        PersistentEntityDAO<Entity> {

    @Override
    public Page<Entity> findByNamedQuery(final PageRequest pageRequest, String queryName, Object... params) throws SQLException {
        Session session = HibernateUtil.getSession();
        
        long totalNumberOfElements = getRowCount(session, queryName, params);
        
        Query query = getNamedQuery(session, queryName);
        setParameters(query, params);

        int pageNumber = pageRequest.getPageNumber();
        int pageSize = pageRequest.getPageSize();

        int firstResult = (pageNumber - 1) * pageSize;
        int maxResults = pageSize;

        query.setFirstResult(firstResult);
        query.setMaxResults(maxResults);

        List<Entity> contents = query.list();

        Page page = new PageImpl(contents, pageNumber, pageSize, totalNumberOfElements);
        return page;
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

        String rowCountQueryName = queryName + ".count";
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

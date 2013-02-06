package com.epam.employees.dao;

import com.epam.employees.model.PersistentEntity;
import com.epam.employees.pagination.page.Page;
import java.sql.SQLException;

/**
 *
 * @author Owl
 */
public interface PersistentEntityDAO<Entity extends PersistentEntity> {

    /**
     * 
     * @param pageNumber number of current page
     * @param pageSize number of records per page
     * @param queryName name of query to get records from db
     * @param params parameters for query
     * @return Page with content
     * @throws SQLException
     */
    Page<Entity> getPage(int pageNumber, int pageSize) throws SQLException;
}

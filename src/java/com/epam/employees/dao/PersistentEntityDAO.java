/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.dao;

import com.epam.employees.model.PersistentEntity;
import com.epam.employees.pagination.page.Page;
import java.sql.SQLException;

/**
 *
 * @author Owl
 */
public interface PersistentEntityDAO<Entity extends PersistentEntity> {

    Page<Entity> findByNamedQuery(int pageNumber, int pageSize, String queryName, Object... params)  throws SQLException;
}

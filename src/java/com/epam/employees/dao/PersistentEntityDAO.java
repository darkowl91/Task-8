/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.dao;

import com.epam.employees.model.PersistentEntity;
import com.epam.employees.pagination.page.Page;
import com.epam.employees.pagination.page.PageRequest;
import java.sql.SQLException;

/**
 *
 * @author Owl
 */
public interface PersistentEntityDAO<Entity extends PersistentEntity> {

    Page<Entity> findByNamedQuery(PageRequest pageRequest, String queryName, Object... params)  throws SQLException;
}

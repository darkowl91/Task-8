/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.dao;

import com.epam.employees.model.PersistentEntity;
import com.epam.employees.pagination.page.Page;
import com.epam.employees.pagination.page.PageRequest;

/**
 *
 * @author Owl
 */
public interface EmployeeDAO<Entity extends PersistentEntity> {

    Page<Entity> findByNamedQuery(PageRequest pageRequest, String queryName, Object... params);
}

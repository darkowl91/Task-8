/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.dao;

import com.epam.employees.model.PersistentEntity;
import com.epam.employees.pagination.page.Page;
import com.epam.employees.pagination.page.PageRequest;
import java.util.List;

/**
 *
 * @author Owl
 */
public interface IEmployeeDAO<Entity extends PersistentEntity> {

   // public List<T> getRecords(int pageSize, int pageNumber);

    List<Entity> findByNamedQuery(String queryName, Object... params);

    Page<Entity> findByNamedQuery(PageRequest pageRequest, String queryName, Object... params);
}

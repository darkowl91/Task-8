/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.dao.hibernate;

import com.epam.employees.dao.PersistentEntityDAO;
import com.epam.employees.model.PersistentEntity;
import com.epam.employees.pagination.page.Page;
import com.epam.employees.pagination.page.PageRequest;

/**
 *
 * @author Nickolay_Petrash
 */
public class PersistentEntityDaoImpl<Entity extends PersistentEntity> implements
        PersistentEntityDAO<Entity> {

    @Override
    public Page<Entity> findByNamedQuery(final PageRequest pageRequest, String queryName, Object... params) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

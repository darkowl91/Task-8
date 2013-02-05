package com.epam.employees.dao;

import com.epam.employees.model.PersistentEntity;
import com.epam.employees.pagination.page.Page;
import com.epam.employees.util.ConnectionPool;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nickolay_Petrash
 */
public final class JdbcImpl<Entity extends PersistentEntity> implements
        PersistentEntityDAO<Entity> {

     private ConnectionPool connectionPool;
     private Releaser resourceReleaser;
     private PreparedStatement preparedStatement = null;
     private ResultSet resultSet = null;

    public void setConnectionPool(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public void setResourceReleaser(Releaser resourceReleaser) {
        this.resourceReleaser = resourceReleaser;
    }
    
    
    @Override
    public Page<Entity> findByNamedQuery(int pageNumber, int pageSize, String queryName, Object... params) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

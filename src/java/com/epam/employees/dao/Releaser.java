/**
 * Resources are not held for the lifetime of the application
 *
 */
package com.epam.employees.dao;

import com.epam.employees.util.ConnectionPool;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nickolay_Petrash
 */
public class Releaser {

    public Releaser() {
    }

    /**
     * Close ResultSet & statement
     *
     * @param statement
     * @param resultSet
     */
    public void closeAll(Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException ex) {
                Logger.getLogger(Releaser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(Releaser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @param connectionPool
     * @param connection
     */
    public void takeConnectionBack(ConnectionPool connectionPool, Connection connection) {
        if (connection != null) {
            connectionPool.takeConnectionBack(connection);
        }
    }
}

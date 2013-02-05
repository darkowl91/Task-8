/**
 * It's a technique to allow multiple clients to make use of a cached set of
 * shared and reusable connection objects providing access to a database.
 *
 */
package com.epam.employees.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nickolay_Petrash
 */
public final class ConnectionPool {

    private Integer maxConnectionsCount;
    private DataBaseParameters dbParameters;
    private Semaphore semaphore;
    /**
     * A ConcurrentLinkedQueue is an appropriate choice when many threads will
     * share access to a common collection.
     */
    private Queue<Connection> connectionQueue = new ConcurrentLinkedQueue<Connection>();
    private Queue<Connection> usedConnections = new ConcurrentLinkedQueue<Connection>();

    public ConnectionPool() {
    }

    /**
     * initializing the connection pool
     */
    private void initConPool() {
        semaphore = new Semaphore(maxConnectionsCount, true);
        String driver = dbParameters.getDriver();
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            System.out.println("1");
        }
    }

    /**
     *
     * @return data base parameters
     */
    public DataBaseParameters getDbParameters() {
        return dbParameters;
    }

    /**
     *
     * @param dbParameters
     */
    public void setDbParameters(DataBaseParameters dbParameters) {
        this.dbParameters = dbParameters;
    }

    /**
     *
     * @return max connections count
     */
    public Integer getMaxConnectionsCount() {
        return maxConnectionsCount;
    }

    /**
     *
     * @param maxConnectionsCount
     */
    public void setMaxConnectionsCount(Integer maxConnectionsCount) {
        this.maxConnectionsCount = maxConnectionsCount;
    }

    /**
     * Create new connection
     *
     * @return connection
     * @throws SQLException
     */
    private Connection createConnection() throws SQLException {
        String url = dbParameters.getURL();
        String user = dbParameters.getUser();
        String password = dbParameters.getPassword();
        return DriverManager.getConnection(url, user, password);
    }

    /**
     *
     * @return connection
     */
    public Connection getConnection() {
        try {
            semaphore.acquire();
            Connection connection = connectionQueue.poll();
            if (connection != null) {
                usedConnections.add(connection);
                return connection;
            } else {
                try {
                    connection = createConnection();
                    usedConnections.add(connection);
                    return connection;
                } catch (SQLException e) {
                    Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        } catch (InterruptedException e) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;

    }

    /**
     * take connection back to queue
     *
     * @param connection
     */
    public void takeConnectionBack(Connection connection) {
        connectionQueue.add(connection);
        usedConnections.remove(connection);
        semaphore.release();
    }

    /**
     * Close all connections
     */
    public void releaseAll() {
        Iterator iterator = connectionQueue.iterator();
        while (iterator.hasNext()) {
            try {
                Connection c = (Connection) iterator.next();
                c.rollback();
                c.close();
                iterator.remove();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        iterator = usedConnections.iterator();
        while (iterator.hasNext()) {
            try {
                Connection c = (Connection) iterator.next();
                c.rollback();
                c.close();
                iterator.remove();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
/**
 *
 *
 */
package com.epam.employees.util;

/**
 *
 * @author Nickolay_Petrash
 */
class DataBaseParameters {

    private String URL;
    private String user;
    private String password;
    private String driver;

    public DataBaseParameters() {
    }

    /**
     *
     * @return database URL
     */
    public String getURL() {
        return URL;
    }

    /**
     *
     * @param URL
     */
    public void setURL(String URL) {
        this.URL = URL;
    }

    /**
     *
     * @return database driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     *
     * @param driverName
     */
    public void setDriver(String driverName) {
        this.driver = driverName;
    }

    /**
     *
     * @return database password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return database userName
     */
    public String getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }
}

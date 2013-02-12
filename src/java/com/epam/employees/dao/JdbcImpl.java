package com.epam.employees.dao;

import com.epam.employees.constants.DBConstants;
import com.epam.employees.constants.DBQuery;
import com.epam.employees.model.Address;
import com.epam.employees.model.City;
import com.epam.employees.model.Company;
import com.epam.employees.model.Country;
import com.epam.employees.model.Employee;
import com.epam.employees.model.Office;
import com.epam.employees.model.PersistentEntity;
import com.epam.employees.model.Position;
import com.epam.employees.model.Work;
import com.epam.employees.pagination.page.Page;
import com.epam.employees.pagination.page.PageImpl;
import com.epam.employees.util.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nickolay_Petrash
 */
public final class JdbcImpl<Entity extends PersistentEntity> implements
        PersistentEntityDAO<Entity> {
    
    private ConnectionPool connectionPool;
    private Releaser resourceReleaser;
    private Connection connection;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    public void setConnectionPool(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
    
    public void setResourceReleaser(Releaser resourceReleaser) {
        this.resourceReleaser = resourceReleaser;
    }
    
    @Override
    public Page<Entity> getPage(int pageNumber, int pageSize) throws SQLException {
        Page page = null;
        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(DBQuery.SELECT_EMPLOYEES);
            List<Employee> employees = new ArrayList<>();
            
            int firstResult = (pageNumber - 1) * pageSize;

            preparedStatement.setInt(1, firstResult + pageSize);
            preparedStatement.setInt(2, firstResult + 1);
            
            resultSet = preparedStatement.executeQuery();
            
            int id = -1;
            while (resultSet.next()) {
                if (id != resultSet.getInt(DBConstants.IDEMPLOYEE)) {
                    id = resultSet.getInt(DBConstants.IDEMPLOYEE);
                    Employee employee = createEmployee(resultSet);
                    Work work = createWork(resultSet);
                    HashSet<Work> currentWork = new HashSet<>();
                    currentWork.add(work);
                    employee.setWorks(currentWork);
                    employees.add(employee);
                } else {
                    Work work = createWork(resultSet);
                    employees.get(employees.size() - 1).getWorks().add(work);
                }
            }
            long totalNumberOfElements = getRowCount(connection);
            page = new PageImpl(employees, pageNumber, pageSize, totalNumberOfElements);

        } catch (Exception e) {
            Logger.getLogger(JdbcImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            resourceReleaser.closeAll(preparedStatement, resultSet);
            resourceReleaser.takeConnectionBack(connectionPool, connection);
        }
        return page;
    }
    
    private Employee createEmployee(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt(DBConstants.IDEMPLOYEE));
        employee.setFirstName(resultSet.getString(DBConstants.EMPLOYEE_FIRSTNAME));
        employee.setLastName(resultSet.getString(DBConstants.EMPLOYEE_LASTNAME));
        
        Country country = new Country();
        country.setId(resultSet.getInt(DBConstants.EMPL_IDCOUNTRY));
        country.setTitle(resultSet.getString(DBConstants.EMPL_COUNTRY_TITLE));
        
        City city = new City();
        city.setId(resultSet.getInt(DBConstants.EMPL_IDCITY));
        city.setTitle(resultSet.getString(DBConstants.EMPL_CITY_TITLE));
        city.setCountry(country);
        
        Address address = new Address();
        address.setId(resultSet.getInt(DBConstants.EMPL_IDADDRESS));
        address.setStreet(resultSet.getString(DBConstants.EMPL_STREET));
        address.setBuilding(resultSet.getString(DBConstants.EMPL_BUILDING));
        address.setRoom(resultSet.getString(DBConstants.EMPL_ROOM));
        address.setCity(city);
        
        employee.setAddress(address);
        return employee;
    }
    
    private Work createWork(ResultSet resultSet) throws SQLException {
        Country countryOfOffice = new Country();
        countryOfOffice.setId(resultSet.getInt(DBConstants.OFF_IDCOUNTRY));
        countryOfOffice.setTitle(resultSet.getString(DBConstants.OFF_COUNTRY_TITLE));
        
        City cityOfOffice = new City();
        cityOfOffice.setId(resultSet.getInt(DBConstants.OFF_IDCITY));
        cityOfOffice.setTitle(resultSet.getString(DBConstants.OFF_CITY_TITLE));
        cityOfOffice.setCountry(countryOfOffice);
        
        Address addressOfOffice = new Address();
        addressOfOffice.setId(resultSet.getInt(DBConstants.OFF_IDADDRESS));
        addressOfOffice.setStreet(resultSet.getString(DBConstants.OFF_STREET));
        addressOfOffice.setBuilding(resultSet.getString(DBConstants.OFF_BUILDING));
        addressOfOffice.setRoom(resultSet.getString(DBConstants.OFF_ROOM));
        addressOfOffice.setCity(cityOfOffice);
        
        Company company = new Company();
        company.setId(resultSet.getInt(DBConstants.IDCOMPANY));
        company.setTitle(resultSet.getString(DBConstants.COMPANY_TITLE));
        
        Office office = new Office();
        office.setId(resultSet.getInt(DBConstants.IDOFFICE));
        office.setAddress(addressOfOffice);
        office.setCompany(company);
        office.setCountOfEmployees(resultSet.getInt(DBConstants.COUNT));
        
        Position position = new Position();
        position.setId(resultSet.getInt(DBConstants.IDPOSITION));
        position.setTitle(resultSet.getString(DBConstants.POSITION_TITLE));
        
        Work work = new Work();
        work.setId(resultSet.getInt(DBConstants.IDWORK));
        work.setIdEmployee(resultSet.getInt(DBConstants.IDEMPLOYEE));
        work.setPosition(position);
        work.setOffice(office);
        return work;
    }
    
    private long getRowCount(Connection connection) throws SQLException {
        resultSet = null;
        Statement statement = null;
        statement = connection.createStatement();
        resultSet = statement.executeQuery(DBQuery.EMPLOYEE_COUNT);
        resultSet.next();
        return resultSet.getInt(1);
    }
}

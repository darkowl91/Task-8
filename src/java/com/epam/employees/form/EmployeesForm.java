/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.form;

import com.epam.employees.model.Address;
import com.epam.employees.model.City;
import com.epam.employees.model.Company;
import com.epam.employees.model.Country;
import com.epam.employees.model.Employee;
import com.epam.employees.model.Position;
import java.util.List;
import org.apache.struts.action.ActionForm;

/**
 *
 * @author Owl
 */
public class EmployeesForm extends ActionForm {

    private List<Address> addresses;
    private List<City> cities;
    private List<Company> companies;
    private List<Country> countrys;
    private List<Employee> employees;
    private List<Position> positions;
    long time;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

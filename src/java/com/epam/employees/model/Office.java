/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.model;

/**
 *
 * @author Owl
 */
public class Office extends Entity {

    private Company company;
    private Address address;
    private int countOfEmployees;

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setCountOfEmployees(int count) {
        this.countOfEmployees = count;
    }

    public int getCountOfEmployees() {
        return this.countOfEmployees;
    }
}

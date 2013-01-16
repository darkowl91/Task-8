/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.model;

import java.util.Set;

/**
 *
 * @author Owl
 */
public class Employee extends Entity {

    private String firstName;
    private String lastName;
    private Address address;
    private Set works;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setWorks(Set works) {
        this.works = works;
    }

    public Set getWorks() {
        return this.works;
    }
}

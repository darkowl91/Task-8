/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.model;

import com.epam.employees.constants.DBConstants;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Formula;

/**
 *
 * @author Owl
 */
@Entity
@Table(name = DBConstants.OFFICE_TABLE)
public class Office extends BaseEntity {

    private Company company;
    private Address address;
    private int countOfEmployees;

    public void setCompany(Company company) {
        this.company = company;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DBConstants.COMPANY_ID)
    public Company getCompany() {
        return this.company;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DBConstants.ADDRESS_ID)
    public Address getAddress() {
        return this.address;
    }

    public void setCountOfEmployees(int count) {
        this.countOfEmployees = count;
    }

    @Formula(value = DBConstants.FORMULA_NAME)
    public int getCountOfEmployees() {
        return this.countOfEmployees;
    }
}

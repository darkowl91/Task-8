/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.model;

import com.epam.employees.constants.DBConstants;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.BatchSize;

/**
 *
 * @author Owl
 */
@Entity
@Table(name = DBConstants.EMPLOYEE_TABLE)
public class Employee extends BaseEntity {

    private String firstName;
    private String lastName;
    private Address address;
    private Set works;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = DBConstants.EMPLOYEE_FIRSTNAME)
    public String getFirstName() {
        return this.firstName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DBConstants.ID, insertable = false, updatable = false)
    public Address getAddress() {
        return this.address;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = DBConstants.EMPLOYEE_LASTNAME)
    public String getLastName() {
        return this.lastName;
    }

    public void setWorks(Set works) {
        this.works = works;
    }

    @OneToMany(mappedBy = DBConstants.EMPLOYEE_ID, fetch = FetchType.EAGER)
    @BatchSize(size = 100)
    public Set getWorks() {
        return this.works;
    }
}

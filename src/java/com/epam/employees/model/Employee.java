package com.epam.employees.model;

import com.epam.employees.constants.DBConstants;
import com.epam.employees.constants.DBQuery;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.BatchSize;

/**
 *
 *
 * @author Owl
 */
@Entity
@Table(name = DBConstants.EMPLOYEE_TABLE)
@NamedQueries({
    @NamedQuery(name = DBConstants.QUERY_NAME_EMPLOYEELIST, query = DBQuery.EMPLOYEE_LIST),
    @NamedQuery(name = DBConstants.QUERY_NAME_EMPLOYEELIST_COUNT, query = DBQuery.EMPLOYEE_LIST_COUNT)
})
public class Employee extends PersistentEntity {

    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private Address address;
    private Set<Work> works;

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

    public void setWorks(Set<Work> works) {
        this.works = works;
    }

    @OneToMany(mappedBy = DBConstants.ID_EMPLOYEE, fetch = FetchType.EAGER)
    @BatchSize(size = 100)
    public Set<Work> getWorks() {
        return this.works;
    }
}

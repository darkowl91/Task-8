/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.model;

import com.epam.employees.constants.DBConstants;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Owl
 */
@Entity
@Table(name = DBConstants.WORK_TABLE)
public class Work extends PersistentEntity {

    private Office office;
    private Position position;
    private long idEmployee;

    public void setOffice(Office office) {
        this.office = office;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DBConstants.OFFICE_ID)
    public Office getOffice() {
        return this.office;
    }

//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }
//
//    @ManyToOne
//    public Employee getEmployee() {
//        return this.employee;
//    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = DBConstants.POSITION_ID)
    public Position getPosition() {
        return this.position;
    }

    @Column(name = DBConstants.EMPLOYEE_ID)
    public long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(long idEmployee) {
        this.idEmployee = idEmployee;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.model;

/**
 *
 * @author Owl
 */
public class Work extends BaseEntity {

    private Office office;
    private Employee employee;
    private Position position;

    public void setOffice(Office office) {
        this.office = office;
    }

    public Office getOffice() {
        return this.office;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }
}

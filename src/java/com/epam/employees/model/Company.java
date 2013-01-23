/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.model;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 *
 * @author Owl
 */
@Table(name = "COMPANY")
public class Company extends BaseEntity {

    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return this.title;
    }
}

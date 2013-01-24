/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.model;

import com.epam.employees.constants.DBConstants;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Owl
 */
@Entity
@Table(name = DBConstants.POSITION_TABLE)
public class Position extends BaseEntity {

    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = DBConstants.TITLE)
    public String getTitle() {
        return this.title;
    }
}

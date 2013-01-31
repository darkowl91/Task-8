/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.model;

import com.epam.employees.constants.DBConstants;
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
@Table(name = DBConstants.CITY_TABLE)
public class City extends PersistentEntity {

    private String title;
    private Country country;

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = DBConstants.TITLE)
    public String getTitle() {
        return this.title;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @ManyToOne
    @JoinColumn(name = DBConstants.COUNTRY_ID)
    public Country getCountry() {
        return this.country;
    }
}

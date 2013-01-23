/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Owl
 */
@Table(name = "CITY")
public class City extends BaseEntity {

    private String title;
    private Country country;

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return this.title;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "COUNTRY_ID", nullable = false)
    public Country getCountry() {
        return this.country;
    }
}

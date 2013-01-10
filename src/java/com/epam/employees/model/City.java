/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.model;

/**
 *
 * @author Owl
 */
public class City extends Entity {
     private String title;
    private Country country;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return this.country;
    }
}

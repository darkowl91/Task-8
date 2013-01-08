/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.model;

import java.util.Set;

/**
 *
 * @author Owl
 */
public class Address extends Entity {

    private String street;
    private String building;
    private String room;
    private City city;
    private Set<Company> companies;

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getBuilding() {
        return building;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRoom() {
        return room;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

    public Set<Company> getCompanies() {
        return this.companies;
    }
}

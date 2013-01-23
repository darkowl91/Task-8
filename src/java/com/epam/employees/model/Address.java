/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.model;

import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Owl
 */
@Entity
public class Address extends BaseEntity {

    private String street;
    private String building;
    private String room;
    private City city;
    private Set<Company> companies;

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "STREET")
    public String getStreet() {
        return street;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Column(name = "BUILDING")
    public String getBuilding() {
        return building;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Column(name = "ROOM")
    public String getRoom() {
        return room;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "CITY_ID", nullable = false)
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

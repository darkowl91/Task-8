/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.model;

import java.io.Serializable;

/**
 *
 * @author Owl
 */
public class Entity implements Serializable{

    private long id;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }
}

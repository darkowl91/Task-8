/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.employees.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Owl
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    private long id;
      private static final long serialVersionUID = 2630114410283439578L;

    public void setId(long id) {
        this.id = id;
    }

    @Id
   @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return this.id;
    }
}

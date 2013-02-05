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
public class PersistentEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private long id;

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

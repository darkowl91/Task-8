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
public class Position extends PersistentEntity {

    private static final long serialVersionUID = 1L;
    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = DBConstants.TITLE)
    public String getTitle() {
        return this.title;
    }
}

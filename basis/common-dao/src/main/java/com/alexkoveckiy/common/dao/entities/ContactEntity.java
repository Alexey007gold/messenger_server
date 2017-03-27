package com.alexkoveckiy.common.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by alex on 05.03.17.
 */

@Entity
@Table(name = "contacts")
public class ContactEntity extends BaseEntity {

    private static final long serialVersionUID = -7753889542769024084L;

    //Whose contact it is
    @Column(name = "user_id")
    private String userId;

    //Contact name
    private String name;

    //Yeah
    private String number;

    public ContactEntity() {
    }

    public ContactEntity(String id, String userId, String name, String number) {
        super(id);
        this.userId = userId;
        this.name = name;
        this.number = number;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

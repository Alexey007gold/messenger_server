package com.alexkoveckiy.common.dao.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by alex on 05.03.17.
 */
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    private static final long serialVersionUID = -1019243451531277705L;

    private String phoneNumber;

    public UserEntity(String id, String phoneNumber) {
        super(id);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

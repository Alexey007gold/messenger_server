package com.alexkoveckiy.common.dao.entities;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by alex on 27.03.17.
 */
public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = -4097791966361292473L;
    
    @Id
    private String id;

    public BaseEntity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

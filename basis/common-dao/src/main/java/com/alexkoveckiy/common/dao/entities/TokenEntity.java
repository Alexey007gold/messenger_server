package com.alexkoveckiy.common.dao.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by alex on 12.03.17.
 */
@Entity
@Table(name = "tokens")
public class TokenEntity implements Serializable, EntityInterface {
    private static final long serialVersionUID = 3500292805326242961L;

    private String phoneNumber;
    private Long creationDate;
}

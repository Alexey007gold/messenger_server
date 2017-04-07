package com.alexkoveckiy.common.dao.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by alex on 05.03.17.
 */
@Entity
@Table(name = "profile")
public class ProfileEntity extends BaseEntity {

    private static final long serialVersionUID = -1019243451531277705L;

    private String phoneNumber;

    private Long createDateTime;

    private Long updateDateTime;

    private String avatarUri;

    private String name;

    private String status;

    public ProfileEntity() {
    }

    public ProfileEntity(String phoneNumber, Long createDateTime, Long updateDateTime, String avatarUri, String name, String status) {
        this.phoneNumber = phoneNumber;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
        this.avatarUri = avatarUri;
        this.name = name;
        this.status = status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Long createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Long getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Long updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public String getAvatarUri() {
        return avatarUri;
    }

    public void setAvatarUri(String avatarUri) {
        this.avatarUri = avatarUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

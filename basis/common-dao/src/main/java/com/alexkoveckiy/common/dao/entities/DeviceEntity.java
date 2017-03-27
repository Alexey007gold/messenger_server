package com.alexkoveckiy.common.dao.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by alex on 16.03.17.
 */
@Entity
@Table(name = "devices")
public class DeviceEntity extends BaseEntity {

    private static final long serialVersionUID = 1115505457482755907L;

    private String userId;

    private String deviceId;

    private Long confirmationTime;

    public DeviceEntity(String id, String userId, String deviceId, Long confirmationTime) {
        super(id);
        this.userId = userId;
        this.deviceId = deviceId;
        this.confirmationTime = confirmationTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Long getConfirmationTime() {
        return confirmationTime;
    }

    public void setConfirmationTime(Long confirmationTime) {
        this.confirmationTime = confirmationTime;
    }
}

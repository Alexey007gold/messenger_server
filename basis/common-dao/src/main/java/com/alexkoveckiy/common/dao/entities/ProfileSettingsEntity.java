package com.alexkoveckiy.common.dao.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by alex on 23.03.17.
 */
@Entity
@Table(name = "profile_settings")
public class ProfileSettingsEntity extends BaseEntity {
    private static final long serialVersionUID = -6782289112689337033L;

    private String profileId;

    private boolean shareOnlineStatus;

    private boolean shareSeenStatus;

    public ProfileSettingsEntity() {
    }

    public ProfileSettingsEntity(String profileId, boolean shareOnlineStatus, boolean shareSeenStatus) {
        this.profileId = profileId;
        this.shareOnlineStatus = shareOnlineStatus;
        this.shareSeenStatus = shareSeenStatus;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public boolean isShareOnlineStatus() {
        return shareOnlineStatus;
    }

    public void setShareOnlineStatus(boolean shareOnlineStatus) {
        this.shareOnlineStatus = shareOnlineStatus;
    }

    public boolean isShareSeenStatus() {
        return shareSeenStatus;
    }

    public void setShareSeenStatus(boolean shareSeenStatus) {
        this.shareSeenStatus = shareSeenStatus;
    }
}

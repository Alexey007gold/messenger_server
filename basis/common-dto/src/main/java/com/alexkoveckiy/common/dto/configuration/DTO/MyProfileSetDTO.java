package com.alexkoveckiy.common.dto.configuration.DTO;

/**
 * Created by alex on 22.03.17.
 */
public class MyProfileSetDTO {

    private String avatarUri;

    private String name;

    private String status;

    public MyProfileSetDTO() {
    }

    public String getAvatarUri() {
        return avatarUri;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}

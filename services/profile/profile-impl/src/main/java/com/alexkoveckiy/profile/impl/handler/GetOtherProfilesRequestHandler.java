package com.alexkoveckiy.profile.impl.handler;

import com.alexkoveckiy.common.dao.entities.ProfileEntity;
import com.alexkoveckiy.common.dao.service.ProfileService;
import com.alexkoveckiy.common.dto.configuration.DTO.UserProfileDTO;
import com.alexkoveckiy.common.modelmapper.ModelMapperService;
import com.alexkoveckiy.common.protocol.Request;
import com.alexkoveckiy.common.protocol.Response;
import com.alexkoveckiy.common.protocol.ResponseFactory;
import com.alexkoveckiy.common.router.api.AbstractRequestHandler;
import com.alexkoveckiy.profile.api.message.GetOtherProfilesRequest;
import com.alexkoveckiy.profile.api.message.GetOtherProfilesResponse;
import com.alexkoveckiy.profile.api.router.ProfileRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 23.03.17.
 */
@Component
public class GetOtherProfilesRequestHandler extends AbstractRequestHandler<GetOtherProfilesRequest, GetOtherProfilesResponse>
        implements ProfileRequestHandler {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public String getName() {
        return "get_other_profiles";
    }

    @Override
    protected Response<GetOtherProfilesResponse> process(Request<GetOtherProfilesRequest> msg) {
        List<UserProfileDTO> userProfileDTOS = new ArrayList<>();

        for (ProfileEntity profileEntity : profileService.findAll(msg.getData().getUserId()))
            userProfileDTOS.add(modelMapperService.map(profileEntity, UserProfileDTO.class));

        return ResponseFactory.createResponse(msg, new GetOtherProfilesResponse(userProfileDTOS));
    }
}

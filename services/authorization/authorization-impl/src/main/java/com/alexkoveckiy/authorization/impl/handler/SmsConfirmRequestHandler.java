package com.alexkoveckiy.authorization.impl.handler;

import com.alexkoveckiy.authorization.api.message.SmsConfirmRequest;
import com.alexkoveckiy.authorization.api.message.SmsConfirmResponse;
import com.alexkoveckiy.authorization.api.router.AuthorizationRequestHandler;
import com.alexkoveckiy.authorization.impl.model.RegSession;
import com.alexkoveckiy.authorization.impl.model.RegSessions;
import com.alexkoveckiy.common.dao.entities.DeviceEntity;
import com.alexkoveckiy.common.dao.entities.ProfileEntity;
import com.alexkoveckiy.common.dao.entities.ProfileSettingsEntity;
import com.alexkoveckiy.common.dao.entities.ProfileStatusEntity;
import com.alexkoveckiy.common.dao.service.DeviceService;
import com.alexkoveckiy.common.dao.service.ProfileService;
import com.alexkoveckiy.common.dao.service.ProfileSettingsService;
import com.alexkoveckiy.common.dao.service.ProfileStatusService;
import com.alexkoveckiy.common.protocol.ActionHeader;
import com.alexkoveckiy.common.protocol.Request;
import com.alexkoveckiy.common.protocol.Response;
import com.alexkoveckiy.common.protocol.ResponseStatus;
import com.alexkoveckiy.common.router.api.AbstractRequestHandler;
import com.alexkoveckiy.common.token.api.TokenHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by alex on 24.02.17.
 */

@Component
public class SmsConfirmRequestHandler extends AbstractRequestHandler<SmsConfirmRequest, SmsConfirmResponse> implements AuthorizationRequestHandler {

    @Autowired
    private RegSessions regSessions;

    @Autowired
    private TokenHandler tokenHandler;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private ProfileSettingsService profileSettingsService;

    @Autowired
    private ProfileStatusService profileStatusService;

    @Autowired

    @Override
    public String getName() {
        return "sms_confirm";
    }

    @Override
    public Response<SmsConfirmResponse> process(Request<SmsConfirmRequest> msg) {
        ActionHeader header = null;
        SmsConfirmResponse data = null;
        ResponseStatus status = null;

        try {
            String uuid = msg.getData().getRegistrationRequestUuid();
            int authCode = msg.getData().getAuthCode();

            RegSession regSession = regSessions.takeRegSession(uuid);
            if (regSession != null && regSession.getAuthCode() == authCode) {
                long time = System.currentTimeMillis();
                ProfileEntity profileEntity = profileService.save(new ProfileEntity(regSession.getPhoneNumber(),
                        time,
                        time,
                        null,
                        null,
                        null));
                String deviceToken = tokenHandler.createDeviceToken(profileEntity.getId(),
                        regSession.getDeviceId(),
                        regSession.getLocale());

                deviceService.save(new DeviceEntity(profileEntity.getId(),
                        regSession.getDeviceId(),
                        tokenHandler.getClaimsFromDeviceToken(deviceToken).getIssuedAt().getValueInMillis()));
                profileSettingsService.save(new ProfileSettingsEntity(profileEntity.getId(), true, true));
                profileStatusService.save(new ProfileStatusEntity(profileEntity.getId(), null));

                header = new ActionHeader(UUID.randomUUID().toString(),
                        msg.getHeader().getUuid(),
                        "sms_confirm",
                        "authorization",
                        "HTTP/1.1");
                data = new SmsConfirmResponse(deviceToken);
                status = new ResponseStatus(200, "OK");
            } else {
                status = new ResponseStatus(403, "Forbidden");
            }
        } catch (Exception e) {
            status = new ResponseStatus(400, "Bad request");
        }

        return new Response<>(header, data, status);
    }
}

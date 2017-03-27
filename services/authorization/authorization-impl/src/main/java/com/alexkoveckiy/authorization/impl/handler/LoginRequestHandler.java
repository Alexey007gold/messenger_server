package com.alexkoveckiy.authorization.impl.handler;

import com.alexkoveckiy.authorization.api.message.LoginRequest;
import com.alexkoveckiy.authorization.api.message.LoginResponse;
import com.alexkoveckiy.authorization.api.router.AuthorizationRequestHandler;
import com.alexkoveckiy.common.dao.service.DeviceService;
import com.alexkoveckiy.common.exceptions.InvalidTokenException;
import com.alexkoveckiy.common.protocol.ActionHeader;
import com.alexkoveckiy.common.protocol.Request;
import com.alexkoveckiy.common.protocol.Response;
import com.alexkoveckiy.common.protocol.ResponseStatus;
import com.alexkoveckiy.common.router.api.AbstractRequestHandler;
import com.alexkoveckiy.common.token.api.TokenHandler;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by alex on 24.02.17.
 */

@Component
public class LoginRequestHandler extends AbstractRequestHandler<LoginRequest, LoginResponse> implements AuthorizationRequestHandler {

    @Autowired
    private TokenHandler tokenHandler;

    @Autowired
    private DeviceService deviceService;

    @Override
    public String getName() {
        return "login";
    }

    @Override
    public Response<LoginResponse> process(Request<LoginRequest> msg) {
        ActionHeader header;
        LoginResponse data;
        ResponseStatus status;

        try {
            String deviceToken = msg.getData().getDeviceToken();
            JwtClaims claims = tokenHandler.getClaimsFromDeviceToken(deviceToken);
            String userId = claims.getStringClaimValue("user_id");
            String deviceId = claims.getStringClaimValue("device_id");
            if (claims.getIssuedAt().getValueInMillis()
                    == deviceService.findByProfileIdAndDeviceId(userId, deviceId).getConfirmationTime()) {
                header = new ActionHeader(UUID.randomUUID().toString(),
                        msg.getHeader().getUuid(),
                        "login",
                        "authorization",
                        "HTTP/1.1");
                data = new LoginResponse(tokenHandler.createTemporaryToken(userId, deviceId));
                status = new ResponseStatus(200, "OK");
            } else
                throw new InvalidTokenException();
        } catch (InvalidTokenException | MalformedClaimException e) {
            header = null;
            data = null;
            status = new ResponseStatus(403, "Forbidden");
        }
        return new Response<>(header, data, status);
    }
}

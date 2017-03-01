package com.alex_koveckiy.authorization.impl.handler;

import com.alex_koveckiy.authorization.api.message.RegisterRequest;
import com.alex_koveckiy.authorization.api.message.RegisterResponse;
import com.alex_koveckiy.authorization.api.router.AuthorizationRequestHandler;
import com.alex_koveckiy.authorization.impl.model.RegSessions;
import com.alex_koveckiy.common.protocol.Request;
import com.alex_koveckiy.common.protocol.Response;
import com.alex_koveckiy.common.router.api.AbstractRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by alex on 23.02.17.
 */

@Component
public class RegisterRequestHandler extends AbstractRequestHandler<RegisterRequest, RegisterResponse> implements AuthorizationRequestHandler<RegisterResponse> {

    @Autowired
    private RegSessions regSessions;

    @Override
    public String getName() {
        return "register";
    }

    @Override
    public Response<RegisterResponse> process(Request<?> msg) {
        return null;
    }

    private void sendSms(String phoneNumber, int authCode) {
    }

    private boolean numberIsOk(String phoneNumber) {
        return phoneNumber.charAt(0) == '+' &&
                !phoneNumber.substring(1).contains("+") &&
                phoneNumber.length() > 10 &&
                phoneNumber.length() < 15;
    }
}

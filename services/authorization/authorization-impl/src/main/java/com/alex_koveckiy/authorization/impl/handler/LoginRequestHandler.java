package com.alex_koveckiy.authorization.impl.handler;

import com.alex_koveckiy.authorization.api.message.LoginRequest;
import com.alex_koveckiy.authorization.api.message.LoginResponse;
import com.alex_koveckiy.authorization.api.router.AuthorizationRequestHandler;
import com.alex_koveckiy.authorization.impl.model.RegSessions;
import com.alex_koveckiy.common.protocol.Request;
import com.alex_koveckiy.common.protocol.Response;
import com.alex_koveckiy.common.router.api.AbstractRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by alex on 24.02.17.
 */

@Component
public class LoginRequestHandler extends AbstractRequestHandler<LoginRequest, LoginResponse> implements AuthorizationRequestHandler<LoginResponse> {

    @Autowired
    private RegSessions regSessions;

    @Override
    public String getName() {
        return "login";
    }

    @Override
    public Response<LoginResponse> process(Request<?> msg) {
        return null;
    }
}

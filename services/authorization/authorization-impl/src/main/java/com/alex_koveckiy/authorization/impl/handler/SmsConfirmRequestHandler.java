package com.alex_koveckiy.authorization.impl.handler;

import com.alex_koveckiy.authorization.api.message.SmsConfirmRequest;
import com.alex_koveckiy.authorization.api.message.SmsConfirmResponse;
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
public class SmsConfirmRequestHandler extends AbstractRequestHandler<SmsConfirmRequest, SmsConfirmResponse> implements AuthorizationRequestHandler<SmsConfirmResponse> {

    @Autowired
    private RegSessions regSessions;

    @Override
    public String getName() {
        return "sms_confirm";
    }

    @Override
    public Response<SmsConfirmResponse> process(Request<?> msg) {
        return null;
    }
}

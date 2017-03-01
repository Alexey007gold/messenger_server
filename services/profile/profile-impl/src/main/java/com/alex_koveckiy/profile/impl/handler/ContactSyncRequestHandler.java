package com.alex_koveckiy.profile.impl.handler;

import com.alex_koveckiy.common.protocol.ActionHeader;
import com.alex_koveckiy.common.protocol.Request;
import com.alex_koveckiy.common.protocol.Response;
import com.alex_koveckiy.common.protocol.ResponseStatus;
import com.alex_koveckiy.common.router.api.AbstractRequestHandler;
import com.alex_koveckiy.profile.api.message.ContactSyncRequest;
import com.alex_koveckiy.profile.api.message.ContactSyncResponse;
import com.alex_koveckiy.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by alex on 24.02.17.
 */

@Component
public class ContactSyncRequestHandler extends AbstractRequestHandler<ContactSyncRequest, ContactSyncResponse>
        implements ProfileRequestHandler<ContactSyncResponse> {


    @Override
    public String getName() {
        return "contacts_sync";
    }

    @Override
    public Response<ContactSyncResponse> process(Request<?> msg) {
        ActionHeader header = new ActionHeader(UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                "contact_sync",
                "profile",
                "HTTP/1.1");
        ResponseStatus status = new ResponseStatus(200, "OK");
        return new Response<>(header, new ContactSyncResponse(), status);
    }
}

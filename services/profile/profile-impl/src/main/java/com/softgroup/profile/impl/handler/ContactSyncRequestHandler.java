package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.ContactSyncRequest;
import com.softgroup.profile.api.message.ContactSyncResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
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

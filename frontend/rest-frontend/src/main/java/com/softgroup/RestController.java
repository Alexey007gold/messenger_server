package com.softgroup;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.protocol.ResponseStatus;
import com.softgroup.common.router.api.HandlerFactory;
import com.softgroup.common.router.api.RouterHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by alex on 24.02.17.
 */

@org.springframework.web.bind.annotation.RestController
@RequestMapping(path = "",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class RestController {

    @Autowired
    private HandlerFactory<RouterHandler> handlerFactory;

    @RequestMapping(path = "")
    public Response<?> getRequest(@RequestBody final Request<?> request) {
        try {
            return handlerFactory.getHandler("first-router").handle(request);
        } catch (Exception e) {
            return new Response<>(null, null, new ResponseStatus(400, "Bad request"));
        }
    }
}
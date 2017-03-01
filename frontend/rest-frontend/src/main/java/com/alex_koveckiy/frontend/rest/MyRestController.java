package com.alex_koveckiy.frontend.rest;

import com.alex_koveckiy.common.protocol.Request;
import com.alex_koveckiy.common.protocol.Response;
import com.alex_koveckiy.common.protocol.ResponseStatus;
import com.alex_koveckiy.common.router.api.HandlerFactory;
import com.alex_koveckiy.common.router.api.RouterHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by alex on 24.02.17.
 */

@RestController
@RequestMapping(path = "",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class MyRestController {

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
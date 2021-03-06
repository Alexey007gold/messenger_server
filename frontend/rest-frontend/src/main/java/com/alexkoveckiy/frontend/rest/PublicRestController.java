package com.alexkoveckiy.frontend.rest;

import com.alexkoveckiy.common.protocol.Request;
import com.alexkoveckiy.common.protocol.Response;
import com.alexkoveckiy.common.protocol.ResponseStatus;
import com.alexkoveckiy.common.router.api.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidParameterException;

/**
 * Created by alex on 24.03.17.
 */

@RestController
@RequestMapping(method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        path = "server/public")
public class PublicRestController {

    @Autowired
    private Handler firstRouter;

    @RequestMapping
    public Response<?> processPublicRequest(@RequestBody final Request<?> request) {
        if (!request.getHeader().getType().equals("authorization"))
            return new Response<>(null, null, new ResponseStatus(400, "Bad request"));
        return firstRouter.handle(request);
    }
}

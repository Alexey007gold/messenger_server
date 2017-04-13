package com.alexkoveckiy.frontend.rest;

import com.alexkoveckiy.common.isonline.IsOnlineService;
import com.alexkoveckiy.common.protocol.Request;
import com.alexkoveckiy.common.protocol.Response;
import com.alexkoveckiy.common.protocol.ResponseStatus;
import com.alexkoveckiy.common.protocol.RoutingData;
import com.alexkoveckiy.common.router.api.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import static com.alexkoveckiy.common.protocol.ResponseFactory.Status.BAD_REQUEST;

/**
 * Created by alex on 24.02.17.
 */

@RestController
@RequestMapping(method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE,
        path = "server/private")
public class PrivateRestController {

    @Autowired
    private Handler firstRouter;

    @Autowired
    private IsOnlineService isOnlineService;

    @RequestMapping
    public Response<?> processPrivateRequest(@RequestBody final Request<?> request, HttpSession session) {
        try {
            RoutingData routingData = (RoutingData) session.getAttribute("routing_data");
            request.setRoutingData(routingData);
            isOnlineService.checkOnline(routingData.getProfileId());

            return firstRouter.handle(request);
        } catch (Exception e) {
            return ResponseFactory.createResponse(request, BAD_REQUEST);
        }
    }
}
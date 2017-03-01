package com.alex_koveckiy.authorization.impl.router;

import com.alex_koveckiy.authorization.api.router.AuthorizationRouterHandler;
import com.alex_koveckiy.common.protocol.Request;
import com.alex_koveckiy.common.router.api.AbstractRouterHandler;
import org.springframework.stereotype.Component;

/**
 * Created by alex on 23.02.17.
 */

@Component
public class AuthorizationRouter extends AbstractRouterHandler<AuthorizationRouterHandler> {

    public String getName() {
        return "authorization";
    }

    @Override
    public String getRouteKey(Request<?> msg) {
        return msg.getHeader().getCommand();
    }
}

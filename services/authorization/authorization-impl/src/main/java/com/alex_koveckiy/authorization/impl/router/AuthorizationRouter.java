package com.alex_koveckiy.authorization.impl.router;

import com.alex_koveckiy.authorization.api.router.AuthorizationRouterHandler;
import com.alex_koveckiy.common.router.api.AbstractByCommandRouterHandler;
import org.springframework.stereotype.Component;

/**
 * Created by alex on 23.02.17.
 */

@Component
public class AuthorizationRouter extends AbstractByCommandRouterHandler<AuthorizationRouterHandler> {

    @Override
    public String getName() {
        return "authorization";
    }
}

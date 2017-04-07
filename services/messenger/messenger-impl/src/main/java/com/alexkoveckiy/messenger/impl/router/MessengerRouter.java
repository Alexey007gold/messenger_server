package com.alexkoveckiy.messenger.impl.router;

import com.alexkoveckiy.common.router.api.AbstractRouterHandler;
import com.alexkoveckiy.common.router.api.ByTypeRouterHandler;
import com.alexkoveckiy.common.router.api.HandlerFactory;
import com.alexkoveckiy.messenger.api.router.MessengerRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by alex on 30.03.17.
 */

@Component
public class MessengerRouter extends AbstractRouterHandler<MessengerRequestHandler> implements ByTypeRouterHandler {

    @Autowired
    private HandlerFactory messengerHandlerFactory;

    @Override
    public String getName() {
        return "messenger";
    }

    @Override
    protected HandlerFactory<MessengerRequestHandler> getHandlerFactory() {
        return messengerHandlerFactory;
    }
}

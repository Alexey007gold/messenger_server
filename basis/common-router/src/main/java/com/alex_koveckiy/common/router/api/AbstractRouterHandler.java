package com.alex_koveckiy.common.router.api;

import com.alex_koveckiy.common.protocol.Request;
import com.alex_koveckiy.common.protocol.Response;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractRouterHandler<T extends Handler> implements RouterHandler {

    @Autowired
    private HandlerFactory<T> handlerFactory;

    @Override
	public Response<?> handle(Request<?> msg) {
		return handlerFactory.getHandler(getRouteKey(msg)).handle(msg);
	}
}

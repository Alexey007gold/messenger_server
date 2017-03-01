package com.alex_koveckiy.common.router.impl;

import com.alex_koveckiy.common.protocol.Request;
import com.alex_koveckiy.common.router.api.AbstractRouterHandler;
import com.alex_koveckiy.common.router.api.CommonRouterHandler;
import org.springframework.stereotype.Component;

/**
 * Created by alex on 25.02.17.
 */

@Component
public class FirstRouter extends AbstractRouterHandler<CommonRouterHandler> {

    @Override
    public String getName() {
        return "first-router";
    }

    @Override
    public String getRouteKey(Request<?> msg) {
        return msg.getHeader().getType();
    }
}

package com.alex_koveckiy.common.router.api;

import com.alex_koveckiy.common.protocol.Request;

/**
 * Created by alex on 02.03.17.
 */
public abstract class AbstractByCommandRouterHandler<T extends Handler> extends AbstractRouterHandler<T> {

    @Override
    public String getRouteKey(Request<?> msg) {
        return msg.getHeader().getCommand();
    }
}

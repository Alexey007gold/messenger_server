package com.alex_koveckiy.profile.impl.router;

import com.alex_koveckiy.common.protocol.Request;
import com.alex_koveckiy.common.router.api.AbstractRouterHandler;
import com.alex_koveckiy.profile.api.router.ProfileRouterHandler;
import org.springframework.stereotype.Component;

/**
 * Created by alex on 26.02.17.
 */

@Component
public class ProfileRouter extends AbstractRouterHandler<ProfileRouterHandler> {

    public String getName() {
        return "profile";
    }

    @Override
    public String getRouteKey(Request<?> msg) {
        return msg.getHeader().getCommand();
    }
}

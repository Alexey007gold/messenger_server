package com.alex_koveckiy.profile.impl.router;

import com.alex_koveckiy.common.router.api.AbstractByCommandRouterHandler;
import com.alex_koveckiy.profile.api.router.ProfileRouterHandler;
import org.springframework.stereotype.Component;

/**
 * Created by alex on 26.02.17.
 */

@Component
public class ProfileRouter extends AbstractByCommandRouterHandler<ProfileRouterHandler> {

    @Override
    public String getName() {
        return "profile";
    }
}

package com.alex_koveckiy.frontend.rest.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

/**
 * Created by alex on 16.02.17.
 */

@Configuration
@ComponentScan(basePackages = "com.alex_koveckiy.frontend.rest",
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class)
)
@Import({com.alex_koveckiy.common.datamapper.configuration.DataMapperConfig.class,
        com.alex_koveckiy.common.router.configuration.CommonRouterConfig.class,
        com.alex_koveckiy.authorization.impl.configuration.AuthorizationImplConfig.class,
        com.alex_koveckiy.profile.impl.configuration.ProfileImplConfig.class
})
public class RestApplicationConfiguration {
}

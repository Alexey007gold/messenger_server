package com.softgroup.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * Created by alex on 16.02.17.
 */

@Configuration
@ComponentScan(basePackages = "com.softgroup",
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class)
)
public class RestApplicationConfiguration {
}

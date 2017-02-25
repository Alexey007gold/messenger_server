package com.softgroup.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by alex on 16.02.17.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.softgroup"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class)
)
public class WebConfiguration extends WebMvcConfigurerAdapter {
}

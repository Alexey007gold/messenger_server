package com.alex_koveckiy.common.router.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by alex on 01.03.17.
 */

@Configuration
@ComponentScan(basePackages = "com.alex_koveckiy.common.router")
public class CommonRouterConfig {
}

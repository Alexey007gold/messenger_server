package com.alexkoveckiy.common.dto.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by alex on 01.03.17.
 */

@Configuration
@ComponentScan(basePackages = "com.alexkoveckiy.common.dto")
public class CommonDtoConfig {
}

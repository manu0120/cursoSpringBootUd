package com.manuel.springboot.webapp.springboot_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
// @PropertySource("classpath:values.properties")
// @PropertySource("values.properties")
@PropertySources({
    @PropertySource(value = "classpath:values.properties", encoding = "UTF-8"),
    @PropertySource("classpath:application.properties")
})
public class ValuesConfig {
    
}

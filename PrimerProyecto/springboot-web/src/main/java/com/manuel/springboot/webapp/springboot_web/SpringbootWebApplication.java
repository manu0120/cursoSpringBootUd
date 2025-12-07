package com.manuel.springboot.webapp.springboot_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
// @PropertySource("classpath:values.properties")
// @PropertySource("values.properties")
@PropertySources({
    @PropertySource("values.properties"),
    @PropertySource("application.properties")
})
public class SpringbootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebApplication.class, args);
	}

}

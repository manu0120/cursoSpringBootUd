package com.manuel.springboot.di.app.springboot_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.manuel.springboot.di.app.springboot_di.repositories.ProductRepository;
import com.manuel.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;

@Configuration

@PropertySource("classpath:values.properties")
public class ValuesConfig {
    @Bean
    ProductRepository productRepositoryJson(){
        return new ProductRepositoryJson();
    }
}

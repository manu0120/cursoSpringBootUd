package com.manuel.curso.springboot.app.interceptor.springboot_interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier("timeInterceptor")
    private HandlerInterceptor timeInterceptor;

    /* Se podría también hacer de esta forma: 

    @Qualifier("timeInterceptor")
    private final HandlerInterceptor timeInterceptor;

    MvcConfig(HandlerInterceptor timeInterceptor) {
        this.timeInterceptor = timeInterceptor;
    }
    */
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // paths included:
        // registry.addInterceptor(timeInterceptor).addPathPatterns("/app/bar", "/app/foo");
        // registry.addInterceptor(timeInterceptor).addPathPatterns("/app/bar", "/app/**");
        
        // paths excluded:
        registry.addInterceptor(timeInterceptor).excludePathPatterns("/app/baz");
    }
    
}

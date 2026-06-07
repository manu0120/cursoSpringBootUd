package com.manuel.curso.springboot.error.springboot_error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.manuel.curso.springboot.error.springboot_error.models.domain.User;

@Configuration
public class AppConfig {

    @Bean
    public List<User> users() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Manuel", "Perez"));
        users.add(new User(2L, "Ana", "Gomez"));
        users.add(new User(3L, "Luis", "Rodriguez"));
        users.add(new User(4L, "Maria", "Lopez"));
        users.add(new User(5L, "Carlos", "Martinez"));
        users.add(new User(6L, "Sofia", "Sanchez"));
        users.add(new User(7L, "Javier", "Diaz"));
        users.add(new User(8L, "Lucia", "Torres"));
        users.add(new User(9L, "Pedro", "Flores"));
        return users;
    }
}

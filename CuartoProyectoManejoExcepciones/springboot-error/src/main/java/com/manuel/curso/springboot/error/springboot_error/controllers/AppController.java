package com.manuel.curso.springboot.error.springboot_error.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manuel.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.manuel.curso.springboot.error.springboot_error.models.domain.User;
import com.manuel.curso.springboot.error.springboot_error.services.UserService;

@RestController
@RequestMapping("/app")
public class AppController {
    @Autowired
    private UserService userService;
    @GetMapping
    public String index() {
        // int value = 100 / 0;
        int value = Integer.parseInt("100x");
        System.out.println(value);
        return "ok 200";
    }

    @GetMapping("/show/{id}")
    private User show(@PathVariable(name = "id") Long id) {
        // User user = userService.findById(id).orElseThrow(() -> new UserNotFoundException("Error, El usuario no existe"));
        Optional<User> optionalUser = userService.findById(id);
        if(optionalUser.isEmpty()) {
            throw new UserNotFoundException("Error, El usuario no existe");
        }
        /* Otra forma posible:
        if (!optionalUser.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalUser.get());
        // return ResponseEntity.ok(optionalUser.orElseThrow());
        */
        User user = optionalUser.get(); 
        
        return user;
    }
}

package com.manuel.curso.springboot.app.aop.springboot_aop.controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manuel.curso.springboot.app.aop.springboot_aop.services.GreetingService;

@RestController
public class GreetingController {
    @Autowired
    private GreetingService greetingSvce;

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting() {
        return ResponseEntity.ok(Collections.singletonMap("greeting", greetingSvce.sayHello("Alcayata", "Hello, what's up?")));
    }
    @GetMapping("/greetingError")
    public ResponseEntity<?> greetingError() {
        return ResponseEntity.ok(Collections.singletonMap("greeting", greetingSvce.sayHelloError("Alcayata", "Hello, what's up?")));
    }
}

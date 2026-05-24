package com.manuel.curso.springboot.error.springboot_error.controllers;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.manuel.curso.springboot.error.springboot_error.models.Error;

@ControllerAdvice
public class HandlerExceptionController {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Error> divisionByZero(Exception e) {
        Error error = new Error();
        error.setError("¡Error división por cero!");
        error.setMessage(e.getMessage());
        error.setStatus(500);
        //error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setDate(new Date());
        // return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(500).body(error);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundEx(NoHandlerFoundException e) {
        Error error = new Error();
        error.setError("¡Api REST no encontrada!");
        error.setMessage(e.getMessage());
        error.setStatus(404);
        //error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setDate(new Date());
        return ResponseEntity.status(404).body(error);
    }
}

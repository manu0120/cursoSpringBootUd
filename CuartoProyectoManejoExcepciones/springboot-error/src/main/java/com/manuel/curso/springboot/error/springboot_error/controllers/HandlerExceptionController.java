package com.manuel.curso.springboot.error.springboot_error.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.manuel.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.manuel.curso.springboot.error.springboot_error.models.Error;

@RestControllerAdvice
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

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> numberFormatEx(NumberFormatException e) {
        Map<String, String> error= new HashMap<>();
        error.put("error", "¡Error conversión de número!");
        error.put("message", e.getMessage());
        error.put("status", "400");
        error.put("date", new Date().toString());
        return error;
    }
    @ExceptionHandler({NullPointerException.class, HttpMessageNotWritableException.class, UserNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> userNotFoundEx(Exception e) {
        Map<String, String> error= new HashMap<>();
        error.put("error", "¡El usuario o rol no existe!");
        error.put("message", e.getMessage());
        error.put("status", "400");
        error.put("date", new Date().toString());
        return error;
    }
    /* Forma más recomendada:

    public ResponseEntity<Error> numberFormatEx(NumberFormatException e) {
        Error error = new Error();
        error.setError("¡Error conversión de número!");
        error.setMessage(e.getMessage());
        error.setStatus(400);
        error.setDate(new Date());
        return ResponseEntity.status(400).body(error);
    }    
    */

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

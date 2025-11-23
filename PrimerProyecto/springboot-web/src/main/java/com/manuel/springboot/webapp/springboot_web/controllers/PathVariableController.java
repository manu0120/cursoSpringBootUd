package com.manuel.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.manuel.springboot.webapp.springboot_web.models.User;
import com.manuel.springboot.webapp.springboot_web.models.dto.ParamMixDto;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/path-variable")
public class PathVariableController {

    @GetMapping("/baz/{param}")
    // podría ser también: @PathVariable(name="param") String paramAux
    public ParamMixDto getMethodName(@PathVariable String param) {
        ParamMixDto paramDto = new ParamMixDto();
        paramDto.setMessage(param);
        return paramDto;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {
        LinkedHashMap<String, Object> object = new LinkedHashMap<>();
        object.put("product", product);
        object.put("id", id);
        return object;
    }    

    /* -------------------------------------------------------------
     Métodos POST */

    // para que funcione, es necesario que el parámetro 'user' que se va a pasar en el body sea un objeto User con los atributos que tiene la clase User (no hay que pasar todos los atributos, solo los que se necesitan)
    @PostMapping("/create")
    public User create(@RequestBody User user) {
        user.setName(user.getName().toUpperCase());
        return user;
    }
    
}

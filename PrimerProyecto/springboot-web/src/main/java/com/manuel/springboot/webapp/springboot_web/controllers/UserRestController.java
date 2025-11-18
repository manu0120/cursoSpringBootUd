package com.manuel.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manuel.springboot.webapp.springboot_web.models.User;
import com.manuel.springboot.webapp.springboot_web.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {

    /* Esto sería lo mismo: 
     * @RequestMapping(path = "/api/details", method = RequestMethod.GET)
     * 
     * También se puede hacer así: 
     * @GetMapping(path = "/details") */
    @GetMapping("/details")
	public UserDto details() {
        UserDto userDto = new UserDto();
        userDto.setTitle("Hola mundo spring boot");
        User user = new User("Manuel", "Rios");
        userDto.setUser(user);
        return userDto;
    }
    @GetMapping("/list")
    public List<User> list() {
        // return List.of(
        //     new User("Andrés", "González"),
        //     new User("Juan", "Perez"),
        //     new User("Luis", "Gomez"),
        //     new User("Ana", "Martinez")
        // );

        /*
        User user = new User("Andrés", "González");
        User user2 = new User("Juan", "Perez");
        User user3 = new User("Luis", "Gomez");
        User user4 = new User("Ana", "Martinez");

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        */
        // si quitamos el new ArrayList<>(), funciona igual pero no podremos agregar más usuarios ni eliminar usuarios de la lista
        List<User> users = new ArrayList<>(Arrays.asList(
            new User("Andrés", "González"),
            new User("Juan", "Perez"),
            new User("Luis", "Gomez"),
            new User("Ana", "Martinez")
        ));

        return users;
    }

    @GetMapping("/details-map")
	public Map<String, Object> detailsMap() {
        User user = new User("Manuel", "Rios");
        Map<String, Object> body = new HashMap<>();
        body.put("title", "Hola mundo spring boot");
        body.put("user", user);
        return body;
    }
}

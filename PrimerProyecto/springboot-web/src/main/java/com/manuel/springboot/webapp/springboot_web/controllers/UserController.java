package com.manuel.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.manuel.springboot.webapp.springboot_web.models.User;

@Controller
public class UserController {
    @GetMapping("/details")
	public String details(Model model) {
        User user = new User("Manuel", "Rios");
        model.addAttribute("title", "Hola mundo spring boot");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("title", "Lista de usuarios");
        return "list";
    }
    @ModelAttribute("users")
    public List<User> userModel(){
        List<User> users = new ArrayList<>();

        users.add(new User("Andrés", "González"));
        users.add(new User("Juan", "Perez", "juan.perez@example.com"));
        users.add(new User("Luis", "Gomez", "luis.gomez@example.com"));
        users.add(new User("Ana", "Martinez", "ana.martinez@example.com"));
        return users;
    }
}

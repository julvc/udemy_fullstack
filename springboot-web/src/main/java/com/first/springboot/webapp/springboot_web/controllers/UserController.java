package com.first.springboot.webapp.springboot_web.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.first.springboot.webapp.springboot_web.models.User;


@Controller
public class UserController {

    @GetMapping("/details2")
    public String details(Model model) {
        User user = new User("Julio", "VC");
        user.setEmail("julio@correo.com");
        model.addAttribute("title","Hola Mundo SpringBoot");
        model.addAttribute("user",user);
        return "details2";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        

        // model.addAttribute("users",users);
        model.addAttribute("title","Listado de Usuarios");
        return "list";
    }

    @ModelAttribute("users")
    public List<User> usersModel(){
        return Arrays.asList(
            new User("Pepa","Pig"), 
            new User("Julio","VC"), 
            new User("User", "Admin", "email@correo.com"),
            new User("AdminJr", "UserJr","email@correo.com"));
    }
    
    
}

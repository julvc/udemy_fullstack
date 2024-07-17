package com.first.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.springboot.webapp.springboot_web.models.User;

import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/details")
    public Map<String, Object> details(Model model) {
        User user = new User("Julio", "VC");
        Map<String, Object> body = new HashMap<>();
        body.put("title","Hola Mundo SpringBoot");
        body.put("user", user);
        return body;
    }

}

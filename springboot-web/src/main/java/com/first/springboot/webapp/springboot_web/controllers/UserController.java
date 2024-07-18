package com.first.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.springboot.webapp.springboot_web.models.User;
import com.first.springboot.webapp.springboot_web.models.dto.UserDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/details")
    public UserDto details(Model model) {
        UserDto userDto = new UserDto();
        User user = new User("Julio", "VC");
        userDto.setUser(user);
        userDto.setTitle("Hola Mundo SpringBoot");
        // Map<String, Object> body = new HashMap<>();
        // body.put("title","Hola Mundo SpringBoot");
        // body.put("user", user);
        return userDto;
    }

    @GetMapping("/list")
    public List<User> list(){
        User user = new User("John", "Wall");
        User user2 = new User("Mike", "Wall");
        User user3 = new User("Milhouse", "Wall");

        // List<User> users = new ArrayList<>();
        // users.add(user);
        // users.add(user2);
        // users.add(user3);

        List<User> users = Arrays.asList(user,user2,user3);
        return users;
    }
}

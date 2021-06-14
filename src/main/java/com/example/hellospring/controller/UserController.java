package com.example.hellospring.controller;

import com.example.hellospring.entity.Credential;
import com.example.hellospring.entity.User;
import com.example.hellospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    // create
    @RequestMapping( method = RequestMethod.GET)
    public String create (){
        User user = new User();
        user.setUserName("meo");
        user.setPassword("123");
        user.setRole(2);
        userService.save(user);
        return "demo";
    }

    // register
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register (
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam int role){

        userService.register(username, password, role);
        return "demo";
    }

    // login
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login (
            @RequestParam String username,
            @RequestParam String password){

        Credential credential = userService.login(username, password);

        return "demo";
    }
}

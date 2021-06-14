package com.example.hellospring.controller;

import com.example.hellospring.entity.User;
import com.example.hellospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/register")
public class UserController {
    @Autowired
    private UserService userService;

    // create
    @RequestMapping( method = RequestMethod.GET)
    public String create (){
        User user = new User();
        user.setUserName("meo");
        user.setPassword("123");
        userService.save(user);
        return "demo";
    }
}

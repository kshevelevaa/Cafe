package com.example.cafe.controller;

import com.example.cafe.entity.impl.User;
import com.example.cafe.service.Test;
import com.example.cafe.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

//    @PostMapping("/save")
//    public String save() {
//        User user = new User  ( "nikita", "password", "email", "111222" );
//        userService.saveEntity(user);
//        return "cart";
//    }
//
//    @GetMapping("/cart")
//    public String cart(){
//        return "cart";
//    }
//
}

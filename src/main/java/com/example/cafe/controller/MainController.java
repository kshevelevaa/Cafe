package com.example.cafe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/index")
    public String showIndex() {
        return "vytf";
    }

//    @GetMapping("/register")
//    public String showRegister(Model model){
//        User user = new User();
//        model.addAttribute("user", user);
//        return "register";
//    }
}

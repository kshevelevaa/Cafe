package com.example.cafe.controller;

import com.example.cafe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/save")
    public String save() {
        userService.save();
        return "register";
    }

//    @PostMapping("/register")
//    public String registerUser(@ModelAttribute("user") User user, Model model){
//        if (user.getPassword().length() < 4){
//            System.out.println("password mast be more than 5 characters");
//            return "register";
//        }
//
//        if (userService.findUserByUsername(user.getUsername())!=null){
//            System.out.println("user is already exist");
//            return "register";
//        }
//
//        if (user.getNumber().length() < 6){
//            System.out.println("number mast be more than 5 characters");
//            return "register";
//        }
//
//        try{
//            userService.saveUser(user);
//            return "redirect:/login";
//        }catch (Exception e){
//            System.out.println("stranger error");
//            return "register";
//        }
//
//    }
}

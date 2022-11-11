package com.example.cafe.controller;

import com.example.cafe.entity.impl.BookingTable;
import com.example.cafe.entity.impl.Order;
import com.example.cafe.entity.impl.User;
import com.example.cafe.service.impl.BookingTableService;
import com.example.cafe.service.impl.OrderService;
import com.example.cafe.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private OrderService orderService;
    @Autowired
    BookingTableService bookingTableService;

    @GetMapping("/register")
    public String showRegister(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {

        if (user.getPassword().length() < 5) {
            System.out.println("password error");
            return "register";
        }

        if (userService.findByUsername(user.getUsername()) != null) {
            System.out.println("user exist error");
            return "register";
        }
        if (!user.getEmail().contains("@")) {
            System.out.println("email");
            return "register";
        }

        if (user.getNumber().length() < 6) {
            System.out.println("number error");
            return "register";
        }
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.saveEntity(user);
            return "redirect:/login";
        } catch (Exception e) {
            System.out.println("Abnormal error");
            return "register";
        }

    }
}

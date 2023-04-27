package com.example.cafe.controller;

import com.example.cafe.entity.impl.Dish;
import com.example.cafe.entity.impl.User;
import com.example.cafe.service.impl.DishInOrderService;
import com.example.cafe.service.impl.DishService;
import com.example.cafe.service.impl.OrderService;
import com.example.cafe.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private DishService dishService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private DishInOrderService dishInOrderService;

    @GetMapping("/index")
    public String index(Model model) {
        try {
            List<Dish> dishes = dishService.findAll();
            System.out.println(dishes);
            model.addAttribute("dishes", dishes);
        } catch (Exception e) {
        }
//        Long id = Long.valueOf(1);
//        System.out.println(dishInOrderService.findTotalPrice(id));
        return "index";
    }

    @GetMapping("/shop")
    public String menu(Model model) {
        model.addAttribute("user", userService.getUserAuth().getUsername());
        model.addAttribute("order", orderService.getLastOrder(userService.getUserAuth().getId()));
        return "shop";
    }

    @GetMapping("/product-details")
    public String users() {
        return "product-details";
    }

    @GetMapping("/cart")
    public String cart(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("order", orderService.getLastOrder(user.getId()));
        return "cart";
    }
}

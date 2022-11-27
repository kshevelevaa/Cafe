package com.example.cafe.controller;

import com.example.cafe.service.impl.DishInOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/details")
public class CartController {

    @Autowired
    private DishInOrderService dishInOrderService;

    @GetMapping("/item")
    public Map<String, Object> getCartItem(@RequestParam(value = "order_id") Long order_id){
        return dishInOrderService.getCartItem(order_id);
    }
}

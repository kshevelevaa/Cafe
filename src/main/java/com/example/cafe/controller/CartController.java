package com.example.cafe.controller;

import com.example.cafe.entity.impl.Dish;
import com.example.cafe.entity.impl.DishInOrder;
import com.example.cafe.entity.impl.User;
import com.example.cafe.service.impl.DishInOrderService;
import com.example.cafe.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private DishInOrderService dishInOrderService;

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<DishInOrder> getAll(@AuthenticationPrincipal User user){
        return dishInOrderService.findDishByOrderId(orderService.getLastOrder(user.getId()).getId());
    }

    @DeleteMapping("/delete")
    public void deleteDishInOrder(@RequestParam(value = "id", required = false) Long id){
        dishInOrderService.deleteById(id);
    }

    @PutMapping("/change")
    public DishInOrder changeDishCount(@RequestParam(value = "change") String change,
                                       @RequestParam(value = "dish_id") Long dish_id,
                                       @RequestParam(value = "order_id") Long order_id){
        if (change.equals("plus")){
            return dishInOrderService.addDish(dish_id, order_id);
        }else if (change.equals("minus")){
            return dishInOrderService.minusDish(dish_id, order_id);
        }
        return null;
    }
}

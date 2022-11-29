package com.example.cafe.controller;

import com.example.cafe.entity.impl.DishInOrder;
import com.example.cafe.entity.impl.Order;
import com.example.cafe.entity.impl.User;
import com.example.cafe.service.impl.DishInOrderService;
import com.example.cafe.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

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

    @PutMapping("/send")
    public Order finishOrder(@RequestParam(value = "order_id") Long order_id,
                             @AuthenticationPrincipal User user){
        Order currentOrder = orderService.findById(order_id);
        currentOrder.setSend(true);
        System.out.println(currentOrder);
        orderService.updateEntity(currentOrder, order_id);
        Order newOrder = new Order();
        newOrder.setUser_id(user.getId());
        orderService.saveEntity(newOrder);
        return currentOrder;
    }
}

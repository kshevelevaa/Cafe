package com.example.cafe.controller;

import com.example.cafe.entity.impl.Dish;
import com.example.cafe.service.impl.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping("")
    public List<Dish> showDishes() {
        return dishService.findAll();
    }

    @PostMapping
    public Dish addDish(@RequestBody Dish dish) {
        return dishService.saveEntity(dish);
    }

    @DeleteMapping("/{id}")
    public void deleteDish(@PathVariable(value = "id") Long id) {
        dishService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Dish updateDish(@PathVariable(value = "id") Long id,
                          @RequestBody Dish dish) {
        return  dishService.updateEntity(dish, id);
    }

}

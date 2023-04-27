package com.example.cafe.controller;

import com.example.cafe.entity.impl.Dish;
import com.example.cafe.service.impl.CategoryService;
import com.example.cafe.service.impl.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public List<Dish> showDishes(@RequestParam(value = "sort", required = false) String sort) {
        if (sort == null) {
            return dishService.findAll();
        }
        switch (sort) {
            case "price": {
                return dishService.sortByPrice();
            }
            case "title": {
                return dishService.sortByTitle();
            }
            default:
                return dishService.findAll();
        }
    }

    @GetMapping("/select")
    public List<Dish> selectDishes(@RequestParam(value = "category", required = false) String category) {

        if (category == null) {
            return dishService.findAll();
        }
        switch (category) {
            case "breakfast": {
                return dishService.selectBreakfast();
            }
            case "lunch": {
                return dishService.selectLunch();
            }
            case "dinner": {
                return dishService.selectDinner();
            }
            case "drink": {
                return dishService.selectDrink();
            }
            default:
                return dishService.findAll();
        }
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
        return dishService.updateEntity(dish, id);
    }

    @GetMapping("/find")
    public List<Dish> findDishes(@RequestParam(value = "template", required = false) String template) {
        if (template == null || template.isEmpty()) {
            return dishService.findAll();
        } else {
            return dishService.findDishes(template);
        }
    }
}

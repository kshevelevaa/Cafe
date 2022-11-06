package com.example.cafe.service.impl;

import com.example.cafe.Dao.impl.DishDao;
import com.example.cafe.entity.impl.Dish;
import com.example.cafe.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishService extends AbstractService<Dish, DishDao> {
    @Autowired
    private final DishDao dishDao;

    public DishService(DishDao dishDao) {
        super(dishDao);
        this.dishDao = dishDao;
    }
}

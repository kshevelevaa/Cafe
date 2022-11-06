package com.example.cafe.service.impl;

import com.example.cafe.Dao.impl.DishInOrderDao;
import com.example.cafe.entity.impl.DishInOrder;
import com.example.cafe.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishInOrderService extends AbstractService<DishInOrder, DishInOrderDao> {
    @Autowired
    private final DishInOrderDao dishInOrderDao;

    public DishInOrderService(DishInOrderDao dishInOrderDao) {
        super(dishInOrderDao);
        this.dishInOrderDao = dishInOrderDao;
    }
}

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

    public boolean deleteByOrderId(Long order_id) {
        if (currentDao.findByOrderId(order_id) == null) {
            return false;
        }
        currentDao.deleteByOrderId(order_id);
        return true;
    }

    public boolean deleteByDishId(Long dish_id) {
        if (currentDao.findByDishId(dish_id) == null) {
            return false;
        }
        currentDao.deleteByDishId(dish_id);
        return true;
    }
}

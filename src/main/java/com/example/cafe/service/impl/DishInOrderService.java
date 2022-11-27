package com.example.cafe.service.impl;

import com.example.cafe.Dao.impl.DishInOrderDao;
import com.example.cafe.entity.impl.Dish;
import com.example.cafe.entity.impl.DishInOrder;
import com.example.cafe.entity.impl.Order;
import com.example.cafe.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        currentDao.deleteById(dish_id);
        return true;
    }

    public DishInOrder addDish(Long dish_id, Long order_id) {
        List<DishInOrder> allDishes = dishInOrderDao.findDishByOrderId(order_id);
        for (DishInOrder currentDish : allDishes) {
            if (currentDish.getDish_id() == dish_id) {
                currentDish.setDishCount(currentDish.getDishCount() + 1);
                dishInOrderDao.update(currentDish, currentDish.getId());
                return currentDish;
            }
        }
        DishInOrder newDishInOrder = new DishInOrder(dish_id, order_id, 1);
        dishInOrderDao.save(newDishInOrder);
        return newDishInOrder;
    }

    public void deleteByDishIdAndOrderId(Dish dish, Order order) {
        List<DishInOrder> allDishes = dishInOrderDao.findDishByOrderId(order.getId());
        for (DishInOrder currentDish : allDishes) {
            if (currentDish.getDish_id() == dish.getId()) {
                dishInOrderDao.deleteById(currentDish.getId());
                return;
            }
        }
    }

    public DishInOrder minusDish(Long dish_id, Long order_id) {
        List<DishInOrder> allDishes = dishInOrderDao.findDishByOrderId(order_id);
        for (DishInOrder currentDish : allDishes) {
            if (currentDish.getDish_id() == dish_id) {
                if (currentDish.getDishCount() > 1) {
                    currentDish.setDishCount(currentDish.getDishCount() - 1);
                    dishInOrderDao.update(currentDish, currentDish.getId());
                    return currentDish;
                } else {
                    dishInOrderDao.deleteById(currentDish.getId());
                    return null;
                }
            }
        }
        return null;
    }

    public List<DishInOrder> findDishByOrderId(Long order_id) {
        return dishInOrderDao.findDishByOrderId(order_id);
    }

    public Map<String, Object> getCartItem(Long order_id){
        Map<String, Object> cartItem= new HashMap<>();
        cartItem.put("dish", dishInOrderDao.findDishInDishInOrder(order_id));
        cartItem.put("dishInOrder", dishInOrderDao.findByOrderId(order_id));
        return cartItem;
    }
}

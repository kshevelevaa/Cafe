package com.example.cafe.service.impl;

import com.example.cafe.Dao.impl.OrderDao;
import com.example.cafe.entity.impl.Order;
import com.example.cafe.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService extends AbstractService<Order, OrderDao> {
    @Autowired
    private final OrderDao orderDao;

    @Autowired
    private DishInOrderService dishInOrderService;
    @Autowired
    private UserService userService;

    public OrderService(OrderDao orderDao) {
        super(orderDao);
        this.orderDao = orderDao;
    }

    public Order getLastOrder(Long user_id) {
        List<Order> allOrders = orderDao.findByUserId(user_id);
        if (allOrders.isEmpty()){
            Order order = new Order();
            order.setUser_id(user_id);
            order.setSend(false);
            Long order_id = orderDao.saveOrder(order);
            return orderDao.findById(order_id);
        }
        return allOrders.get(allOrders.size() - 1);
    }

    public boolean deleteByUserId(Long user_id) {
        if (currentDao.findByUserId(user_id) == null) {
            return false;
        }
        currentDao.deleteByUserId(user_id);
        return true;
    }

    public boolean deleteWithNestedEntities(Long id) {
        boolean deleteEntity = deleteById(id);
        boolean deleteDishInOrder = dishInOrderService.deleteByOrderId(id);

        if (deleteDishInOrder == false) {
            System.out.println("there were no dishInOrders");
        } else {
            System.out.println("dishInOrders successfully deleted");
        }

        if (deleteEntity == false) {
            return false;
        } else {
            return true;
        }
    }

}

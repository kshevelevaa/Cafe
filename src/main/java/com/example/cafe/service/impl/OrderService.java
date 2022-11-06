package com.example.cafe.service.impl;

import com.example.cafe.Dao.impl.OrderDao;
import com.example.cafe.entity.impl.Order;
import com.example.cafe.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends AbstractService<Order, OrderDao> {
    @Autowired
    private final OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        super(orderDao);
        this.orderDao = orderDao;
    }
}

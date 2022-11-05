package com.example.cafe.service;

import com.example.cafe.Dao.impl.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AbstractService<T> {
    @Autowired
    UserDao userDao;

    @Autowired
    BookingTableDao bookingTableDao;

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    CookDao cookDao;

    @Autowired
    DishDao dishDao;

    @Autowired
    DishInOrderDao dishInOrderDao;

    @Autowired
    OrderDao orderDao;

    public void saveEntity(T entity) {
    }

    public void updateEntity(T entity, Long id) {
    }

    public void deleteEntity(T entity, Long id) {
    }

    public T findEntityById(Long id) {
        return null;
    }

    public List<T> findAll() {
        return null;
    }

    public void deleteAll() {
    }
}

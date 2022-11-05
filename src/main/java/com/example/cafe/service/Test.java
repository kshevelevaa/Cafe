package com.example.cafe.service;

import com.example.cafe.Dao.impl.*;
import com.example.cafe.entity.impl.User;
import com.example.cafe.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class Test implements UserDetailsService {

    @Autowired
    UserDao userDao;
    @Autowired
    CategoryDao categoryDao;

    @Autowired
    CookDao cookDao;

    @Autowired
    BookingTableDao bookingTableDao;

    @Autowired
    DishDao dishDao;

    @Autowired
    DishInOrderDao dishInOrderDao;

    @Autowired
    OrderDao orderDao;

    @Autowired
    UserService userService;

    public void save() {
//        User user = new User("anna", "1234567", "email", "number");
//        boolean save = userDao.save(user);
//        System.out.println(save);
//        Long id = Long.valueOf(1);
//        boolean delete = userDao.deleteById(id);
//        System.out.println(delete);
//
//        Long newId = Long.valueOf(3);
//        User newUser = new User("newName", "newPassword", "newEmail", "newNumber");
//        boolean update = userDao.update(newUser, newId);
//        User getUser = userDao.findById(newId);
//        System.out.println(getUser.toString());

//        Category category = new Category(CategoryName.BREAKFAST, "eggs, porridge, sandwich");
//        boolean save = categoryDao.save(category);
//        System.out.println(save);

//        Long id = Long.valueOf(1);
//        boolean update = categoryDao.update(category, id);
//        Category getCategory = categoryDao.findById(id);
//        System.out.println(getCategory.toString());
//
//        boolean delete = categoryDao.deleteById(id);

//        Cook cook1 = new Cook("Ivan Ivanov", CategoryName.BREAKFAST);
//        Cook cook2 = new Cook("Anna", CategoryName.BREAKFAST);
//        Cook cook3  = new Cook("Igor", CategoryName.DINNER);
//        Long id = Long.valueOf(2);
////        boolean save1 = cookDao.save(cook1);
//        boolean save2 = cookDao.save(cook2);
//        boolean update2= cookDao.update(cook3, id);
//        System.out.println(cookDao.findById(id).toString());
//        LocalDate localDate = LocalDate.now();
//        LocalTime localTime= LocalTime.now();
//        Long id = Long.valueOf(3);
//        User user = userDao.findById(id);
//        BookingTable bookingTable = new BookingTable(id, localDate, localTime, 6 );
//        bookingTableDao.save(bookingTable);
//        bookingTableDao.save(bookingTable);
//        bookingTableDao.save(bookingTable);
//        bookingTableDao.update(bookingTable, id);
//        BookingTable bt=bookingTableDao.findById(id);
//        System.out.println(bt);
        Long id = Long.valueOf(4);
//        Dish dish = new Dish("porridge", 150,id, id );
//        Dish newDish = new Dish("porridge", 350,id, id);
//        dishDao.save(dish);
//        dishDao.save(dish);
//        dishDao.update(newDish, id);
//        System.out.println(dishDao.findById(id));

//        DishInOrder dishInOrder  = new DishInOrder(id, id, 2 );
//        DishInOrder dishInOrder2  = new DishInOrder(id, id, 8 );
//        dishInOrderDao.save(dishInOrder);
//        dishInOrderDao.save(dishInOrder);
//        dishInOrderDao.update(dishInOrder2, id);
//        System.out.println(dishInOrderDao.findById(id));
//        dishInOrderDao.deleteById(id);
//        Order order = new Order(id, "moscow");
//        Order order1 = new Order(id, "piter");
//        orderDao.save(order);
//        orderDao.save(order);
//        orderDao.save(order);
//        orderDao.update(order1, id);
//        System.out.println(orderDao.findById(id));
//        orderDao.deleteById(id);
        System.out.println(userService.findAll());
        System.out.println(userService.findById(id));

        userService.updateEntity(new User("katya", "password", "email", "67866"), id);
        System.out.println(userService.findById(id));
        userService.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

}

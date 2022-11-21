package com.example.cafe.service.impl;

import com.example.cafe.Dao.impl.UserDao;
import com.example.cafe.entity.impl.User;
import com.example.cafe.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<User, UserDao> implements UserDetailsService {
    @Autowired
    private final UserDao userDao;

    @Autowired
    BookingTableService bookingTableService;

    @Autowired
    OrderService orderS;

    public UserService(UserDao userDao) {
        super(userDao);
        this.userDao = userDao;
    }

    public boolean deleteWithNestedEntities(Long id){
        boolean deleteEntity = deleteById(id);
        boolean deleteBookingTable = bookingTableService.deleteByUserId(id);
        boolean deleteOrder =  orderS.deleteByUserId(id);

        if (deleteOrder == false){
            System.out.println("there were no orders");
        }else {
            System.out.println("orders successfully deleted");
        }

        if (deleteBookingTable == false ){
            System.out.println("there were no booking tables");
        }else {
            System.out.println("booking tables successfully deleted");
        }

        if (deleteEntity == false ){
            return false;
        }else {
           return true;
        }
    }

    public User findByUsername(String name){
        return userDao.findByUsername(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
    public User getUserAuth() {

        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}

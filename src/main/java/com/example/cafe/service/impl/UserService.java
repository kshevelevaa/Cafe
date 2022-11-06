package com.example.cafe.service.impl;

import com.example.cafe.Dao.impl.UserDao;
import com.example.cafe.entity.impl.User;
import com.example.cafe.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService<User, UserDao> {
    @Autowired
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        super(userDao);
        this.userDao = userDao;
    }
}

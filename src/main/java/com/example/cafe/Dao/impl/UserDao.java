package com.example.cafe.Dao.impl;

import com.example.cafe.Dao.AbstractDao;
import com.example.cafe.entity.impl.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends AbstractDao<User> {
    public UserDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
        tableName = TableName.users;
    }

    @Override
    public boolean save(User user1) {
        jdbcTemplate.update("INSERT INTO users (email, number, password, username)VALUES (?,?,?,?)",
                user1.getEmail(),
                user1.getNumber(),
                user1.getPassword(),
                user1.getUsername());
        return true;
    }

    @Override
    public boolean update(User newUser, Long id) {
        jdbcTemplate.update(
                "UPDATE users SET email=?, number=?, password=?, username=? WHERE id =? ",
                newUser.getEmail(),
                newUser.getNumber(),
                newUser.getPassword(),
                newUser.getUsername(),
                id);
        return false;
    }
}

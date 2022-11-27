package com.example.cafe.Dao.impl;

import com.example.cafe.Dao.AbstractDao;
import com.example.cafe.entity.impl.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao extends AbstractDao<User> {
    @Autowired
    SimpleJdbcCall simpleJdbcCall;

    public UserDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
        tableName = TableName.users;
    }

    @Override
    public void save(User user1) {
        jdbcTemplate.update("INSERT INTO users (email, number, password, username)VALUES (?,?,?,?)",
                user1.getEmail(),
                user1.getNumber(),
                user1.getPassword(),
                user1.getUsername());
    }

    @Override
    public void update(User newUser, Long id) {
        jdbcTemplate.update(
                "UPDATE users SET email=?, number=?, password=?, username=? WHERE id =? ",
                newUser.getEmail(),
                newUser.getNumber(),
                newUser.getPassword(),
                newUser.getUsername(),
                id);
    }

    public User findByUsername(String username) {
        String request = "SELECT * FROM " + tableName + " WHERE username= ?";
        return jdbcTemplate.query(request, new Object[]{username}, new BeanPropertyRowMapper<>(User.class)).stream()
                .findAny()
                .orElse(null);
    }
}

package com.example.cafe.Dao.impl;

import com.example.cafe.Dao.AbstractDao;
import com.example.cafe.entity.impl.Order;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao extends AbstractDao<Order> {
    public OrderDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
        tableName = TableName.orders;
    }

    @Override
    public boolean save(Order order) {
        jdbcTemplate.update("INSERT INTO orders (user_id, address) VALUES (?,?)",
                order.getUser_id(),
                order.getAddress()
        );
        return false;
    }

    @Override
    public boolean update(Order order, Long id) {
        jdbcTemplate.update(
                "UPDATE orders SET user_id=?, address=? WHERE id =? ",
                order.getUser_id(),
                order.getAddress(),
                id);
        return false;
    }

//    @Override
//    public Order findById(Long id) {
//        String request = "SELECT * FROM " + tableName + " WHERE id= ?";
//        return jdbcTemplate.query(request, new Object[]{id}, new BeanPropertyRowMapper<>(Order.class)).stream()
//                .findAny()
//                .orElse(null);
//    }
}
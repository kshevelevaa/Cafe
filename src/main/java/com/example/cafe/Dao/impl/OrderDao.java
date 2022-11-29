package com.example.cafe.Dao.impl;

import com.example.cafe.Dao.AbstractDao;
import com.example.cafe.entity.impl.BookingTable;
import com.example.cafe.entity.impl.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDao extends AbstractDao<Order> {
    SimpleJdbcInsert simpleJdbcInsert;

    public OrderDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
        tableName = TableName.orders;
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("orders").usingGeneratedKeyColumns("id");
    }


    public Long saveOrder(Order order) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("user_id", order.getUser_id());
        parameters.put("address", order.getAddress());
        parameters.put("is_send", order.isSend());
        Number newId = simpleJdbcInsert.executeAndReturnKey(parameters);
        return (long) newId;
    }


    @Override
    public void save(Order order) {
        jdbcTemplate.update("INSERT INTO orders (user_id, address, is_send) VALUES (?,?,?)",
                order.getUser_id(),
                order.getAddress(),
                order.isSend()
        );
    }

    @Override
    public void update(Order order, Long id) {
        jdbcTemplate.update(
                "UPDATE orders SET user_id=?, address=?, is_send=? WHERE id =? ",
                order.getUser_id(),
                order.getAddress(),
                order.isSend(),
                id);
    }

    public void deleteByUserId(Long user_id){
        String request = "DELETE FROM " + tableName + " WHERE user_id= ?";
        jdbcTemplate.update(request, user_id);
    }

    public List<Order> findByUserId(Long user_id){
        String request = "SELECT * FROM " + tableName + " WHERE user_id= ?";
        return jdbcTemplate.query(request, new Object[]{user_id}, new BeanPropertyRowMapper<>(Order.class));
    }

}

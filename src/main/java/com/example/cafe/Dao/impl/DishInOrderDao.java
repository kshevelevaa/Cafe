package com.example.cafe.Dao.impl;

import com.example.cafe.Dao.AbstractDao;
import com.example.cafe.entity.impl.DishInOrder;
import com.example.cafe.entity.impl.Order;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DishInOrderDao extends AbstractDao<DishInOrder> {

    public DishInOrderDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
        tableName = TableName.dish_in_order;
    }

    @Override
    public void save(DishInOrder dishInOrder) {
        jdbcTemplate.update("INSERT INTO dish_in_order (dish_id, order_id, dish_count) VALUES (?,?,?)",
                dishInOrder.getDish_id(),
                dishInOrder.getOrder_id(),
                dishInOrder.getDishCount()
        );
    }

    @Override
    public void update(DishInOrder dishInOrder, Long id) {
        jdbcTemplate.update(
                "UPDATE dish_in_order SET dish_id=?, order_id=?, dish_count=? WHERE id =? ",
                dishInOrder.getDish_id(),
                dishInOrder.getOrder_id(),
                dishInOrder.getDishCount(),
                id);
    }

    public void deleteByOrderId(Long user_id) {
        String request = "DELETE FROM " + tableName + " WHERE order_id= ?";
        jdbcTemplate.update(request, user_id);
    }

    public Order findByOrderId(Long user_id) {
        String request = "SELECT * FROM " + tableName + " WHERE order_id= ?";
        return jdbcTemplate.query(request, new Object[]{user_id}, new BeanPropertyRowMapper<>(Order.class)).stream()
                .findAny()
                .orElse(null);
    }

    public Order findByDishId(Long user_id) {
        String request = "SELECT * FROM " + tableName + " WHERE dish_id= ?";
        return jdbcTemplate.query(request, new Object[]{user_id}, new BeanPropertyRowMapper<>(Order.class)).stream()
                .findAny()
                .orElse(null);
    }

    public List<DishInOrder> findDishByOrderId(Long order_id) {
        String request = "SELECT * FROM " + tableName + " WHERE order_id= ?";
        return jdbcTemplate.query(request, new Object[]{order_id}, new BeanPropertyRowMapper<>(DishInOrder.class));
    }

    public List findDishInDishInOrder(Long order_id) {
        String request = "SELECT * FROM dish_in_order join dish on dish_in_order.dish_id=dish.id WHERE order_id= ?";
        return jdbcTemplate.queryForList(request, new Object[]{order_id});
    }

    public int findDishCount(Long order_id, Long dish_id) {
        String request = "SELECT dish_count FROM " + tableName + " WHERE order_id= ? AND dish_id=?";
        return jdbcTemplate.update(request);
    }

}

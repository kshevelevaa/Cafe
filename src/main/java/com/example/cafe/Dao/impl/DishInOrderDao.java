package com.example.cafe.Dao.impl;

import com.example.cafe.Dao.AbstractDao;
import com.example.cafe.entity.impl.DishInOrder;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DishInOrderDao extends AbstractDao<DishInOrder> {

    public DishInOrderDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
        tableName = TableName.dish_in_order;
    }

    @Override
    public boolean save(DishInOrder dishInOrder) {
        jdbcTemplate.update("INSERT INTO dish_in_order (dish_id, order_id, dish_count) VALUES (?,?,?)",
                dishInOrder.getDish_id(),
                dishInOrder.getOrder_id(),
                dishInOrder.getDishCount()
        );
        return false;
    }

    @Override
    public boolean update(DishInOrder dishInOrder, Long id) {
        jdbcTemplate.update(
                "UPDATE dish_in_order SET dish_id=?, order_id=?, dish_count=? WHERE id =? ",
                dishInOrder.getDish_id(),
                dishInOrder.getOrder_id(),
                dishInOrder.getDishCount(),
                id);
        return false;
    }

//    @Override
//    public DishInOrder findById(Long id) {
//        String request = "SELECT * FROM " + tableName + " WHERE id= ?";
//        return jdbcTemplate.query(request, new Object[]{id}, new BeanPropertyRowMapper<>(DishInOrder.class)).stream()
//                .findAny()
//                .orElse(null);
//    }


}

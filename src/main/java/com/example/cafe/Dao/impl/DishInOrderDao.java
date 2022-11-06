package com.example.cafe.Dao.impl;

import com.example.cafe.Dao.AbstractDao;
import com.example.cafe.entity.impl.DishInOrder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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

}

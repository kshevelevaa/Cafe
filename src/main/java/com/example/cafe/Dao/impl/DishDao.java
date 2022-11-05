package com.example.cafe.Dao.impl;

import com.example.cafe.Dao.AbstractDao;
import com.example.cafe.entity.impl.Dish;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DishDao extends AbstractDao<Dish> {

    public DishDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
        tableName = TableName.dish;
    }

    @Override
    public boolean save(Dish dish) {
        jdbcTemplate.update("INSERT INTO dish (title, price, category_id, cook_id) VALUES (?,?,?,?)",
                dish.getTitle(),
                dish.getPrice(),
                dish.getCategory_id(),
                dish.getCook_id());
        return false;
    }

    @Override
    public boolean update(Dish dish, Long id) {
        jdbcTemplate.update(
                "UPDATE dish SET title=?, price=?, category_id=?, cook_id=? WHERE id =? ",
                dish.getTitle(),
                dish.getPrice(),
                dish.getCategory_id(),
                dish.getCook_id(),
                id);
        return false;
    }

}

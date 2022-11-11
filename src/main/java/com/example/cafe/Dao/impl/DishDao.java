package com.example.cafe.Dao.impl;

import com.example.cafe.Dao.AbstractDao;
import com.example.cafe.entity.impl.Dish;
import com.example.cafe.entity.impl.Order;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DishDao extends AbstractDao<Dish> {

    public DishDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
        tableName = TableName.dish;
    }

    @Override
    public void save(Dish dish) {
        jdbcTemplate.update("INSERT INTO dish (title, price, category_id, cook_id) VALUES (?,?,?,?)",
                dish.getTitle(),
                dish.getPrice(),
                dish.getCategory_id(),
                dish.getCook_id());
    }

    @Override
    public void update(Dish dish, Long id) {
        jdbcTemplate.update(
                "UPDATE dish SET title=?, price=?, category_id=?, cook_id=? WHERE id =? ",
                dish.getTitle(),
                dish.getPrice(),
                dish.getCategory_id(),
                dish.getCook_id(),
                id);
    }

    public void deleteByCookId(Long cook_id){
        String request = "DELETE FROM " + tableName + " WHERE cook_id= ?";
        jdbcTemplate.update(request, cook_id);
    }

    public Order findByCookId(Long cook_id){
        String request = "SELECT * FROM " + tableName + " WHERE cook_id= ?";
        return jdbcTemplate.query(request, new Object[]{cook_id}, new BeanPropertyRowMapper<>(Order.class)).stream()
                .findAny()
                .orElse(null);
    }

}

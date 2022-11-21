package com.example.cafe.Dao.impl;

import com.example.cafe.Dao.AbstractDao;
import com.example.cafe.entity.impl.Dish;
import com.example.cafe.entity.impl.Order;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public void deleteByCookId(Long cook_id) {
        String request = "DELETE FROM " + tableName + " WHERE cook_id= ?";
        jdbcTemplate.update(request, cook_id);
    }

    public Order findByCookId(Long cook_id) {
        String request = "SELECT * FROM " + tableName + " WHERE cook_id= ?";
        return jdbcTemplate.query(request, new Object[]{cook_id}, new BeanPropertyRowMapper<>(Order.class)).stream()
                .findAny()
                .orElse(null);
    }

    public List<Dish> sortByTitle() {
        String sql = "SELECT * FROM " + tableName + " ORDER BY title";
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper(Dish.class));
    }

    public List<Dish> sortByPrice() {
        String sql = "SELECT * FROM " + tableName + " ORDER BY price";
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper(Dish.class));
    }

    public List<Dish> selectBreakfast() {
        String sql = "SELECT * FROM " + tableName + " WHERE category_id = 2";
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper(Dish.class));
    }

    public List<Dish> selectLunch() {
        String sql = "SELECT * FROM " + tableName + " WHERE category_id = 3";
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper(Dish.class));
    }

    public List<Dish> selectDinner() {
        String sql = "SELECT * FROM " + tableName + " WHERE category_id = 4";
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper(Dish.class));
    }

    public List<Dish> selectDrink() {
        String sql = "SELECT * FROM " + tableName + " WHERE category_id = 5";
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper(Dish.class));
    }

    public List<Dish> findDishes(String template) {
        template = template + "%";
        String sql = "SELECT * FROM " + tableName + " WHERE title LIKE ?";
        return jdbcTemplate.query(
                sql,
                new Object[]{template},
                new BeanPropertyRowMapper(Dish.class));
    }

}

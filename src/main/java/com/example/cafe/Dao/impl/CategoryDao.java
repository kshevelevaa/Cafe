package com.example.cafe.Dao.impl;

import com.example.cafe.Dao.AbstractDao;
import com.example.cafe.entity.impl.Category;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao extends AbstractDao<Category> {
    public CategoryDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
        tableName = TableName.category;
    }

    @Override
    public boolean save(Category category) {
        jdbcTemplate.update("INSERT INTO category (name, description)VALUES (?,?)",
                category.getName().name(),
                category.getDescription());
        return false;
    }

    @Override
    public boolean update(Category newCategory, Long id) {
        jdbcTemplate.update(
                "UPDATE category SET name=?, description=? WHERE id =? ",
                newCategory.getName().toString(),
                newCategory.getDescription(),
                id);
        return false;
    }

//    @Override
//    public Category findById(Long id) {
//        String request = "SELECT * FROM category WHERE id= ?";
//        return jdbcTemplate.query(request, new Object[]{id}, new BeanPropertyRowMapper<>(Category.class)).stream()
//                .findAny()
//                .orElse(null);
//    }
}
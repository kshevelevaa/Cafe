package com.example.cafe.Dao.impl;

import com.example.cafe.Dao.AbstractDao;
import com.example.cafe.entity.impl.Category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao extends AbstractDao<Category> {
    public CategoryDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
        tableName = TableName.category;
    }

    @Override
    public void save(Category category) {
        jdbcTemplate.update("INSERT INTO category (name, description)VALUES (?,?)",
                category.getName().name(),
                category.getDescription());
    }

    @Override
    public void update(Category newCategory, Long id) {
        jdbcTemplate.update(
                "UPDATE category SET name=?, description=? WHERE id =? ",
                newCategory.getName().toString(),
                newCategory.getDescription(),
                id);
    }

}

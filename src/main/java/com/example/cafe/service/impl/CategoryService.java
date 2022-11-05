package com.example.cafe.service.impl;

import com.example.cafe.Dao.impl.CategoryDao;
import com.example.cafe.entity.impl.Category;
import com.example.cafe.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends AbstractService<Category, CategoryDao> {
    @Autowired
    private final CategoryDao categoryDao;

    public CategoryService(CategoryDao categoryDao) {
        super(categoryDao);
        this.categoryDao = categoryDao;
    }
}

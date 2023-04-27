package com.example.cafe.service.impl;

import com.example.cafe.Dao.impl.CookDao;
import com.example.cafe.entity.impl.Cook;
import com.example.cafe.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookService extends AbstractService<Cook, CookDao> {
    @Autowired
    private final CookDao cookDao;

    @Autowired
    private DishService dishService;

    public CookService(CookDao cookDao) {
        super(cookDao);
        this.cookDao = cookDao;
    }

    public boolean deleteWithNestedEntities(Long id) {
        boolean deleteEntity = deleteById(id);
        boolean deleteDish = dishService.deleteByCookId(id);

        if (deleteDish == false) {
            System.out.println("there were no dish");
        } else {
            System.out.println("dishs successfully deleted");
        }

        if (deleteEntity == false) {
            return false;
        } else {
            return true;
        }
    }
}

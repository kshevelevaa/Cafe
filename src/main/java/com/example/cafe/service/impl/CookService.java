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

    public CookService(CookDao cookDao) {
        super(cookDao);
        this.cookDao = cookDao;
    }
}

package com.example.cafe.service;

import com.example.cafe.Dao.AbstractDao;
import com.example.cafe.entity.AbstractEntity;

import java.util.List;

public abstract class AbstractService<T extends AbstractEntity, D extends AbstractDao> {
    protected D currentDao;

    protected AbstractService(D currentDao) {
        this.currentDao = currentDao;
    }

    public AbstractService() {
    }

    public T saveEntity(T entity) {
        List<T> entities = currentDao.findAll();
        for (T existEntity : entities) {
            if (existEntity.equals(entity)) {
                return null;
            }
        }
        currentDao.save(entity);
        return entity;
    }

    public T updateEntity(T entity, Long id) {
        if (currentDao.findById(id) == null) {
            return null;
        }
        currentDao.update(entity, id);
        return findById(id);
    }

    public boolean deleteById(Long id) {
        if (currentDao.findById(id) == null) {
            return false;
        }
        currentDao.deleteById(id);
        return true;
    }

    public T findById(Long id) {
        return (T) currentDao.findById(id);
    }

    public List<T> findAll() {
        return (List<T>) currentDao.findAll();
    }


//    public void deleteAll() {
//    }
}

package com.example.cafe.Dao;

import com.example.cafe.Dao.impl.TableName;
import com.example.cafe.entity.AbstractEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDao<T extends AbstractEntity> {
    public final JdbcTemplate jdbcTemplate;
    public TableName tableName;
    public static DataSource dataSource;

    public AbstractDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        dataSource = jdbcTemplate.getDataSource();
    }

    public abstract void save(T entity);

    public abstract void update(T entity, Long id);

    public T findById(Long id) {
        String request = "SELECT * FROM " + tableName + " WHERE id= ?";
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class<?> clazz = (Class<?>) pt.getActualTypeArguments()[0];
        return (T) jdbcTemplate.query(request, new Object[]{id}, new BeanPropertyRowMapper<>(clazz)).stream()
                .findAny()
                .orElse(null);
    }

    public List<T> findAll() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class<?> clazz = (Class<?>) pt.getActualTypeArguments()[0];
        String sql = "SELECT * FROM " + tableName;
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper(clazz));
    }

    public void deleteById(Long id) {
        String request = "DELETE FROM " + tableName + " WHERE id= ?";
        jdbcTemplate.update(request, id);
    }
}

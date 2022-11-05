package com.example.cafe.Dao.impl;

import com.example.cafe.Dao.AbstractDao;
import com.example.cafe.entity.impl.Cook;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CookDao extends AbstractDao<Cook> {

    public CookDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
        tableName = TableName.cook;
    }

    @Override
    public boolean save(Cook cook) {
        jdbcTemplate.update("INSERT INTO cook (name, specialization) VALUES (?,?)",
                cook.getName(),
                cook.getSpecialization().toString());
        return false;
    }

    @Override
    public boolean update(Cook newCook, Long id) {
        jdbcTemplate.update(
                "UPDATE cook SET name=?, specialization=? WHERE id =? ",
                newCook.getName(),
                newCook.getSpecialization().toString(),
                id);
        return false;
    }

//    @Override
//    public Cook findById(Long id) {
//        String request = "SELECT * FROM cook WHERE id= ?";
//        return jdbcTemplate.query(request, new Object[]{id}, new BeanPropertyRowMapper<>(Cook.class)).stream()
//                .findAny()
//                .orElse(null);
//    }
}

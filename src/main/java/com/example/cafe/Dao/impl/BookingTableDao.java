package com.example.cafe.Dao.impl;

import com.example.cafe.Dao.AbstractDao;
import com.example.cafe.entity.impl.BookingTable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;

@Repository
public class BookingTableDao extends AbstractDao<BookingTable> {
    public BookingTableDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
        tableName = TableName.booking_table;
    }

    @Override
    public void save(BookingTable bookingTable) {
        jdbcTemplate.update("INSERT INTO booking_table (user_id, date, time, people_count) VALUES (?,?,?,?)",
                bookingTable.getUser_id(),
                bookingTable.getDate(),
                bookingTable.getTime(),
                bookingTable.getPeopleCount());
    }

    @Override
    public void update(BookingTable newBookingTable, Long id) {
        jdbcTemplate.update(
                "UPDATE booking_table SET user_id=?, date=?, time=?, people_count=? WHERE id =? ",
                newBookingTable.getUser_id(),
                newBookingTable.getDate(),
                newBookingTable.getTime(),
                newBookingTable.getPeopleCount(),
                id);
    }

    public void deleteByUserId(Long user_id){
            String request = "DELETE FROM " + tableName + " WHERE user_id= ?";
            jdbcTemplate.update(request, user_id);
    }

    public BookingTable findByUserId(Long user_id){
            String request = "SELECT * FROM " + tableName + " WHERE user_id= ?";
            return jdbcTemplate.query(request, new Object[]{user_id}, new BeanPropertyRowMapper<>(BookingTable.class)).stream()
                    .findAny()
                    .orElse(null);
    }
}

package com.example.cafe.Dao.impl;

import com.example.cafe.Dao.AbstractDao;
import com.example.cafe.entity.impl.BookingTable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingTableDao extends AbstractDao<BookingTable> {
    public BookingTableDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
        tableName = TableName.booking_table;
    }

    @Override
    public boolean save(BookingTable bookingTable) {
        jdbcTemplate.update("INSERT INTO booking_table (user_id, date, time, people_count) VALUES (?,?,?,?)",
                bookingTable.getUser_id(),
                bookingTable.getDate(),
                bookingTable.getTime(),
                bookingTable.getPeopleCount());
        return false;
    }

    @Override
    public boolean update(BookingTable newBookingTable, Long id) {
        jdbcTemplate.update(
                "UPDATE booking_table SET user_id=?, date=?, time=?, people_count=? WHERE id =? ",
                newBookingTable.getUser_id(),
                newBookingTable.getDate(),
                newBookingTable.getTime(),
                newBookingTable.getPeopleCount(),
                id);
        return false;
    }

//    @Override
//    public BookingTable findById(Long id) {
//        String request = "SELECT * FROM booking_table WHERE id= ?";
//        return jdbcTemplate.query(request, new Object[]{id}, new BeanPropertyRowMapper<>(BookingTable.class)).stream()
//                .findAny()
//                .orElse(null);
//    }




}

package com.example.cafe.service.impl;

import com.example.cafe.Dao.impl.BookingTableDao;
import com.example.cafe.entity.impl.BookingTable;
import com.example.cafe.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingTableService extends AbstractService<BookingTable, BookingTableDao> {
    @Autowired
    private final BookingTableDao bookingTableDao;

    public BookingTableService(BookingTableDao bookingTableDao) {
        super(bookingTableDao);
        this.bookingTableDao = bookingTableDao;
    }
}

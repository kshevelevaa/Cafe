package com.example.cafe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Getter
@Setter
@Table (name = "booking_table")
public class BookingTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;
    private Date date;
    private Time time;
    private int peopleCount;

    public BookingTable() {
    }

    public BookingTable(Long id_user, Date date, Time time, int peopleCount) {
        this.date = date;
        this.time = time;
        this.peopleCount = peopleCount;
    }

}

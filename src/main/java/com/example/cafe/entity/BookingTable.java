package com.example.cafe.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
public class BookingTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long id_user;
    private Date date;
    private Time time;
    private int peopleCount;

    public BookingTable() {
    }

    public BookingTable(Long id_user, Date date, Time time, int peopleCount) {
        this.id_user = id_user;
        this.date = date;
        this.time = time;
        this.peopleCount = peopleCount;
    }


    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

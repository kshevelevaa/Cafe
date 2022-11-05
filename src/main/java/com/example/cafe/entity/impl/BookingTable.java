package com.example.cafe.entity.impl;

import com.example.cafe.entity.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name = "booking_table")
@NoArgsConstructor
@ToString
public class BookingTable extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long user_id;
    private LocalDate date;
    private LocalTime time;
    private int peopleCount;

    public BookingTable(Long user_id, LocalDate date, LocalTime time, int peopleCount) {
        this.user_id = user_id;
        this.date = date;
        this.time = time;
        this.peopleCount = peopleCount;
    }

}

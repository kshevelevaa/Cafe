package com.example.cafe.entity.impl;

import com.example.cafe.entity.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingTable that = (BookingTable) o;
        return Objects.equals(id, that.id) && Objects.equals(user_id, that.user_id) && Objects.equals(date, that.date) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, date, time, peopleCount);
    }
}

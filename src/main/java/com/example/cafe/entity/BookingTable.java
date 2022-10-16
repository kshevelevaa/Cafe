package com.example.cafe.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name = "booking_table")
@NoArgsConstructor
public class BookingTable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;
    //    @Temporal(TemporalType.DATE)
    private LocalDate date;

    //    @Temporal(TemporalType.TIME)
    private LocalTime time;
    private int peopleCount;

    public BookingTable(User user, LocalDate date, LocalTime time, int peopleCount) {
        this.user = user;
        this.date = date;
        this.time = time;
        this.peopleCount = peopleCount;
    }
}

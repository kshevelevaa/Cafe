package com.example.cafe.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cook")
@Getter
@Setter
@NoArgsConstructor
public class Cook {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryName specialization;

    public Cook(String name, CategoryName specialization) {
        this.name = name;
        this.specialization = specialization;
    }

}

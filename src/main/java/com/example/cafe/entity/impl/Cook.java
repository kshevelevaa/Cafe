package com.example.cafe.entity.impl;

import com.example.cafe.entity.AbstractEntity;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "cook")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Cook  extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

package com.example.cafe.entity.impl;

import com.example.cafe.entity.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cook cook = (Cook) o;
        return Objects.equals(id, cook.id) && Objects.equals(name, cook.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, specialization);
    }
}

package com.example.cafe.entity.impl;

import com.example.cafe.entity.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Getter
@Setter
@Table(name = "dish")
@NoArgsConstructor
@ToString
public class Dish  extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private int price;
    private Long category_id;
    private Long cook_id;

    public Dish(String title, int price, Long category_id, Long cook_id) {
        this.title = title;
        this.price = price;
        this.category_id = category_id;
        this.cook_id = cook_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return  Objects.equals(id, dish.id) && Objects.equals(title, dish.title) && Objects.equals(category_id, dish.category_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, category_id, cook_id);
    }
}

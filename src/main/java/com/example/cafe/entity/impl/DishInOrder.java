package com.example.cafe.entity.impl;

import com.example.cafe.entity.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Getter
@Setter
@Table(name = "dish_in_order")
@NoArgsConstructor
@ToString
public class DishInOrder extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long dish_id;
    private Long order_id;
    private int dishCount;

    public DishInOrder(Long dish_id, Long order_id, int dishCount) {
        this.dish_id = dish_id;
        this.order_id = order_id;
        this.dishCount = dishCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishInOrder that = (DishInOrder) o;
        return Objects.equals(id, that.id) && Objects.equals(dish_id, that.dish_id) && Objects.equals(order_id, that.order_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dish_id, order_id, dishCount);
    }
}

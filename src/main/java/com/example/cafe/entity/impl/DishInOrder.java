package com.example.cafe.entity.impl;

import com.example.cafe.entity.AbstractEntity;
import lombok.*;

import javax.persistence.*;


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
}

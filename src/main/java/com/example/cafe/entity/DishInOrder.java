package com.example.cafe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "dish_in_order")
public class DishInOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long idDishInOrder;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "dish_id")
    private Dish dish;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "order_id")
    private Order order;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "cook_id")
    private Cook cook;

    private int dishCount;

    public DishInOrder() {
    }

}

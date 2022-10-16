package com.example.cafe.entity;

import javax.persistence.*;

@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private int price;
    private Long id_category;

    public Dish() {
    }

    public Dish(String title, int price, Long id_category) {
        this.title = title;
        this.price = price;
        this.id_category = id_category;
    }

}

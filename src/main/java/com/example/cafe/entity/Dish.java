package com.example.cafe.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "dish")
@NoArgsConstructor
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private int price;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "category_id")
    private Category category;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "cook_id")
    private Cook cook;

    public Dish(String title, int price, Category category, Cook cook) {
        this.title = title;
        this.price = price;
        this.category = category;
        this.cook = cook;
    }
}

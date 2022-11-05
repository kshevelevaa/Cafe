package com.example.cafe.entity.impl;

import com.example.cafe.entity.AbstractEntity;
import lombok.*;

import javax.persistence.*;


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
    //    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(nullable = false, name = "category_id")
//    private Category category;
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(nullable = false, name = "cook_id")
//    private Cook cook;
}

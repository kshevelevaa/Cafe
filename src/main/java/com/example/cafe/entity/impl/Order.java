package com.example.cafe.entity.impl;

import com.example.cafe.entity.AbstractEntity;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "orders")
@NoArgsConstructor
@ToString
public class Order extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long user_id;
    private String address;

    public Order(Long user_id, String address) {
        this.user_id = user_id;
        this.address = address;
    }
}

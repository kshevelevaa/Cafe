package com.example.cafe.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "order_id", nullable = false)
    private Long idOrder;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    private String address;

    public Order() {
    }

    public Order(User user, Cook cook, String address) {
        this.user = user;
        this.address = address;
    }
}
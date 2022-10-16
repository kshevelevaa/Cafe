package com.example.cafe.entity;

import javax.persistence.*;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long idOrder;

    private Long idUser;
    private Long idCook;

    private String address;

    public Order() {
    }

    public Order(Long idOrder, Long idUser, Long idCook, String address) {
        this.idOrder = idOrder;
        this.idUser = idUser;
        this.idCook = idCook;
        this.address = address;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdCook() {
        return idCook;
    }

    public void setIdCook(Long idCook) {
        this.idCook = idCook;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   }

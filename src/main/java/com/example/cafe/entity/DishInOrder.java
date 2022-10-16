package com.example.cafe.entity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
public class DishInOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long idDishInOrder;

    private Long idDish;
    private Long idOrder;
//    private Long idCook;
//    private Long idUser;
    private int dishCount;

    public DishInOrder() {
    }

    public DishInOrder(Long idDish, Long idOrder, Long idCook, Long idUser, int dishCount) {
        this.idDish = idDish;
        this.idOrder = idOrder;
//        this.idCook = idCook;
//        this.idUser = idUser;
        this.dishCount = dishCount;
    }

    public Long getIdDishInOrder() {
        return idDishInOrder;
    }

    public void setIdDishInOrder(Long idDishInOrder) {
        this.idDishInOrder = idDishInOrder;
    }

    public Long getIdDish() {
        return idDish;
    }

    public void setIdDish(Long idDish) {
        this.idDish = idDish;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

//    public Long getIdCook() {
//        return idCook;
//    }
//
//    public void setIdCook(Long idCook) {
//        this.idCook = idCook;
//    }
//
//    public Long getIdUser() {
//        return idUser;
//    }
//
//    public void setIdUser(Long idUser) {
//        this.idUser = idUser;
//    }

    public int getDishCount() {
        return dishCount;
    }

    public void setDishCount(int dishCount) {
        this.dishCount = dishCount;
    }

    }

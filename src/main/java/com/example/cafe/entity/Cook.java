package com.example.cafe.entity;

import javax.persistence.*;

@Entity
@Table(name = "cook")
public class Cook {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private CategoryName specialization;

    public Cook() {
    }

    public Cook(String name, CategoryName specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryName getSpecialization() {
        return specialization;
    }

    public void setSpecialization(CategoryName specialization) {
        this.specialization = specialization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

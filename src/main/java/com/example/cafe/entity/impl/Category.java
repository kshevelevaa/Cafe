package com.example.cafe.entity.impl;

import com.example.cafe.entity.AbstractEntity;
import lombok.*;


import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "category")
@NoArgsConstructor
@ToString
public class Category  extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Enumerated(EnumType.STRING)
    private CategoryName name;
    private String description;

    public Category(CategoryName name, String description) {
        this.name = name;
        this.description = description;
    }
}

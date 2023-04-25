package com.example.springjparelationlivelecture230425.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;

    @OneToMany(mappedBy = "food")
    private List<Order> orderList = new ArrayList<>();

    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

}

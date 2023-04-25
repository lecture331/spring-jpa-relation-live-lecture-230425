package com.example.springjparelationlivelecture230425.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

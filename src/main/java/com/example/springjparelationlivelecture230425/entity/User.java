package com.example.springjparelationlivelecture230425.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(mappedBy = "user")
    private Food food;

    public User(String name) {
        this.name = name;
    }

    public void setFood(Food food) {
        this.food = food;
        // 외래 키를 추가합니다.
        food.setUser(this);
    }
}

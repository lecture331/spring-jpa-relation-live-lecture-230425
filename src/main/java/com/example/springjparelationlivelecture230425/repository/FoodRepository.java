package com.example.springjparelationlivelecture230425.repository;

import com.example.springjparelationlivelecture230425.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}

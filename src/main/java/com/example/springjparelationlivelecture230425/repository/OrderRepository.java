package com.example.springjparelationlivelecture230425.repository;

import com.example.springjparelationlivelecture230425.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

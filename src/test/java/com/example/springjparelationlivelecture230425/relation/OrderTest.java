package com.example.springjparelationlivelecture230425.relation;

import com.example.springjparelationlivelecture230425.entity.Food;
import com.example.springjparelationlivelecture230425.entity.Order;
import com.example.springjparelationlivelecture230425.entity.User;
import com.example.springjparelationlivelecture230425.repository.FoodRepository;
import com.example.springjparelationlivelecture230425.repository.OrderRepository;
import com.example.springjparelationlivelecture230425.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class OrderTest {
    @Autowired
    FoodRepository foodRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;

    @Test
    @Rollback(value = false)
    @DisplayName("중간 테이블 Order Entity 테스트")
    void test1() {

        User user = new User("Robbie");
        userRepository.save(user);

        Food food = new Food("후라이드 치킨", 15000);
        foodRepository.save(food);

        // 주문 저장
        Order order = new Order();
        order.setUser(user); // 외래 키(연관 관계) 설정
        order.setFood(food); // 외래 키(연관 관계) 설정
        orderRepository.save(order);
    }

    @Test
    @DisplayName("중간 테이블 Order Entity 조회")
    void test2() {
        // 1번 주문 조회
        Order order = orderRepository.findById(1L).orElseThrow(NullPointerException::new);

        // order 객체를 사용하여 고객 정보 조회
        User user = order.getUser();
        System.out.println("user.getName() = " + user.getName());

        // order 객체를 사용하여 음식 정보 조회
        Food food = order.getFood();
        System.out.println("food.getName() = " + food.getName());
        System.out.println("food.getPrice() = " + food.getPrice());

        System.out.println("order.getOrderDate() = " + order.getOrderDate());
    }
}

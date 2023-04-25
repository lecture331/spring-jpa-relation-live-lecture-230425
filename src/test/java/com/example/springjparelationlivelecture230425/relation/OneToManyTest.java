package com.example.springjparelationlivelecture230425.relation;

import com.example.springjparelationlivelecture230425.entity.Food;
import com.example.springjparelationlivelecture230425.entity.User;
import com.example.springjparelationlivelecture230425.repository.FoodRepository;
import com.example.springjparelationlivelecture230425.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@SpringBootTest
public class OneToManyTest {

    @Autowired
    FoodRepository foodRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    @Rollback(value = false)
    @DisplayName("1대N 단방향 테스트")
    void test1() {
        User user = new User("Robbie");
        userRepository.save(user);

        User user2 = new User("Robert");
        userRepository.save(user2);

        Food food = new Food("후라이드 치킨", 15000);
        foodRepository.save(food);

        food.addUserList(user);
        food.addUserList(user2);
    }

    @Test
    @DisplayName("1대N 조회 테스트")
    void test2() {
        Food food = foodRepository.findById(1L).orElseThrow(NullPointerException::new);
        System.out.println("food.getName() = " + food.getName());

        // 해당 음식을 주문한 고객 정보 조회
        List<User> userList = food.getUserList();
        for (User user : userList) {
            System.out.println("user.getName() = " + user.getName());
        }
    }
}

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

@Transactional
@SpringBootTest
public class ManyToOneTest {

    @Autowired
    FoodRepository foodRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    @Rollback(value = false)
    @DisplayName("N대1 단방향 테스트")
    void test1() {
        Food food = new Food("후라이드 치킨", 15000);
        foodRepository.save(food);
        Food food2 = new Food("양념 치킨", 20000);
        foodRepository.save(food2);

        User user = new User("Robbie");
        userRepository.save(user);

//        food.setUser(user);
//        food2.setUser(user);
    }

    @Test
    @Rollback(value = false)
    @DisplayName("N대1 양방향 테스트")
    void test2() {
        Food food = new Food("후라이드 치킨", 15000);
        foodRepository.save(food);
        Food food2 = new Food("양념 치킨", 20000);
        foodRepository.save(food2);

        User user = new User("Robbie");
        userRepository.save(user);

        // User Entity 를 통해 Food Entity 를 참조해보겠습니다.
//        user.addFoodList(food);
//        user.addFoodList(food2);
    }
}

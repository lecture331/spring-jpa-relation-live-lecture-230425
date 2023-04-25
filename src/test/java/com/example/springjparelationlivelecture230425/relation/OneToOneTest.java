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
public class OneToOneTest {

    @Autowired
    FoodRepository foodRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    @Rollback(value = false) // 테스트에서는 @Transactional 에 의해 자동 rollback 됨으로 false 설정해준다.
    @DisplayName("1대1 단방향 테스트")
    void test1() {
        Food food = new Food("후라이드 치킨", 15000);
        foodRepository.save(food);

        User user = new User("Robbie");
        userRepository.save(user);

        // 외래 키의 주인인 Food Entity user 필드에 user 객체를 추가해 줍니다.
        food.setUser(user);
    }

    @Test
    @Rollback(value = false)
    @DisplayName("1대1 양방향 테스트")
    void test2() {
        Food food = new Food("후라이드 치킨", 15000);
        foodRepository.save(food);

        User user = new User("Robbie");
        userRepository.save(user);

        // 이번에는 반대로 외래 키의 주인이 아닌 곳에서 참조해봅니다.
//        user.setFood(food);

    }

}

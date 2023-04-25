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

    @Test
    @DisplayName("N대1 조회 : Food 기준 user 정보 조회")
    void test3() {
        Food food = foodRepository.findById(1L).orElseThrow(NullPointerException::new);
        // 음식 정보 조회
        System.out.println("food.getName() = " + food.getName());

        // 음식을 주문한 고객 정보 조회
//        System.out.println("food.getUser().getName() = " + food.getUser().getName());
    }

    @Test
    @DisplayName("N대1 조회 : User 기준 food 정보 조회")
    void test4() {
        User user = userRepository.findById(1L).orElseThrow(NullPointerException::new);
        // 고객 정보 조회
        System.out.println("user.getName() = " + user.getName());

        // 해당 고객이 주문한 음식 정보 조회
//        List<Food> foodList = user.getFoodList();
//        for (Food food : foodList) {
//            System.out.println("food.getName() = " + food.getName());
//            System.out.println("food.getPrice() = " + food.getPrice());
//        }
    }
}

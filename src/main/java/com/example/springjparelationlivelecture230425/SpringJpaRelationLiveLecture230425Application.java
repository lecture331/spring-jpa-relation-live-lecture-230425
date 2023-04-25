package com.example.springjparelationlivelecture230425;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringJpaRelationLiveLecture230425Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaRelationLiveLecture230425Application.class, args);
    }

}

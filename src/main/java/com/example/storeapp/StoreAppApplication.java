package com.example.storeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StoreAppApplication {

    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(StoreAppApplication.class, args);
        UserService userService = context.getBean(UserService.class);
        User user1 = new User(1L, "John", "Doe", "john.doe@example.com");
        userService.registerUser(user1);

        User user2 = new User(2L, "Jane", "Smith", "jane.smith@example.com");
        userService.registerUser(user2);

        User user3 = new User(3L, "John", "Doe", "john.doe@example.com");
        userService.registerUser(user3);
    }

}

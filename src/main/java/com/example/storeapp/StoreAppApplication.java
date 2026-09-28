package com.example.storeapp;

import com.example.storeapp.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StoreAppApplication {

    public static void main(String[] args) {
        // ApplicationContext context =  SpringApplication.run(StoreAppApplication.class, args);
        User user = User.builder()
                .id(1L)
                .name("John Doe")
                .email("hello@example.com")
                .password("password")
                .build();
        System.out.println(user);
    }

}

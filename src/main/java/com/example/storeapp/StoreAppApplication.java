package com.example.storeapp;

import com.example.storeapp.entities.Address;
import com.example.storeapp.entities.Tag;
import com.example.storeapp.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StoreAppApplication {

    public static void main(String[] args) {
        // ApplicationContext context =  SpringApplication.run(StoreAppApplication.class, args);
        User user = new User(1L, "John Doe", "hello@example.com", "password");
        System.out.println(user);

        Address address = new Address(1L, "123 Main St", "Anytown", "CA", "12345");
        System.out.println(address);

        user.addAddress(address);
        System.out.println("User after adding address: " + user);

        Tag tag = new Tag(1L, "VIP");
        System.out.println(tag);

        user.addTag(tag);
        System.out.println("User after adding tag: " + user);
    }

}

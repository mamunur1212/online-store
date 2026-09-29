package com.example.storeapp;

import com.example.storeapp.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class StoreAppApplication {

    public static void main(String[] args) {
        // ApplicationContext context =  SpringApplication.run(StoreAppApplication.class, args);
//        User user = new User(1L, "John Doe", "hello@example.com", "password");
//        System.out.println(user);
//
//        Address address = new Address(1L, "123 Main St", "Anytown", "CA", "12345");
//        System.out.println(address);
//
//        user.addAddress(address);
//        System.out.println("User after adding address: " + user);
//
//        Tag tag = new Tag(1L, "VIP");
//        System.out.println(tag);
//
//        user.addTag(tag);
//        System.out.println("User after adding tag: " + user);
//
//        Profile profile = new Profile(1L, "This is a bio", "123-456-7890", LocalDate.of(1990, 1, 1), 100);
//        System.out.println(profile);
//
//        user.addProfile(profile);
//        System.out.println("User after adding profile: " + user);

        Category category = new Category((byte) 1, "Electronics");
        System.out.println(category);

        Product product = new Product(1L, "Smartphone", new BigDecimal("699.99"));
        System.out.println(product);

        category.addProduct(product);
        System.out.println("Category after adding product: " + category);
    }

}

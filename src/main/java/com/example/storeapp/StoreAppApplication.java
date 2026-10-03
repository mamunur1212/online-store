package com.example.storeapp;

import com.example.storeapp.entities.*;
import com.example.storeapp.repositories.UserRepository;
import com.example.storeapp.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class StoreAppApplication {

    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(StoreAppApplication.class, args);

        var service =  context.getBean(UserService.class);
        service.updateProductPrice();


        // User user = new User("John Doe", "hello1@example.com", "password");
        // System.out.println(user);

        // UserRepository userRepository = context.getBean(UserRepository.class);
        // userRepository.save(user);

//        User user1 = userRepository.findById(1L).orElse(null);
//        System.out.println(user1.getEmail());

//        Iterable<User> users = userRepository.findAll();
//        users.forEach(user1 -> System.out.println(user1.getEmail()));

       // userRepository.deleteById(1L);

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

//        Category category = new Category((byte) 1, "Electronics");
//        System.out.println(category);
//
//        Product product = new Product(1L, "Smartphone", new BigDecimal("699.99"), "A high-end smartphone with a great camera.");
//        System.out.println(product);
//
//        category.addProduct(product);
//        System.out.println("Category after adding product: " + category);
//
//        user.addProduct(product);
//        System.out.println("User after adding product: " + user);
    }

}

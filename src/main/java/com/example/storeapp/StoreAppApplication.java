package com.example.storeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StoreAppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =  SpringApplication.run(StoreAppApplication.class, args);
        OrderService orderService = context.getBean(OrderService.class);
        OrderService orderService2 = context.getBean(OrderService.class);
        orderService.placeOrder();
        context.close();
    }

}

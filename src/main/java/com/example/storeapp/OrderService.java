package com.example.storeapp;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

public class OrderService {
    private final PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        System.out.println("------------- OrderService initialized with " + paymentService.getClass().getSimpleName());
        this.paymentService = paymentService;
    }

    @PostConstruct
    public void initialize() {
        System.out.println("------------- OrderService PostConstruct " + paymentService.getClass().getSimpleName());
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("------------- OrderService PreDestroy " + paymentService.getClass().getSimpleName());
    }

    public void placeOrder() {
        paymentService.processPayment(20.5);
    }
}

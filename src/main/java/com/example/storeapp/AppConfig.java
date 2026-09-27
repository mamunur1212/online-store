package com.example.storeapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AppConfig {

    @Value("${payment-gateway}:stripe")
    private String paymentGateway;

    @Bean
    @Lazy
    public PaymentService stripe() {
        return new StripePaymentService();
    }

    @Bean
    @Lazy
    public PaymentService paypal() {
        return new PayPalPaymentService();
    }
    @Bean
    @Lazy
    public OrderService orderService() {
        if (paymentGateway.equals("stripe")) {
            return new OrderService(stripe());
        } else {
            return new OrderService(paypal());
        }
    }
}

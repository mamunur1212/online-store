package com.example.storeapp;

public class StripePaymentService implements PaymentService {
    @Override
    public void processPayment(double amount) {
        // Implement Stripe payment processing logic here
        System.out.println("Processing payment of $" + amount + " through Stripe.");
    }
}

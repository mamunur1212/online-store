package com.example.storeapp;

public class PayPalPaymentService  implements PaymentService {
    @Override
    public void processPayment(double amount) {
        // Implement PayPal payment processing logic here
        System.out.println("Processing payment of $" + amount + " through PayPal.");
    }
}

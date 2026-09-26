package com.example.storeapp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("paypal")
@Primary
public class PayPalPaymentService  implements PaymentService {
    @Override
    public void processPayment(double amount) {
        // Implement PayPal payment processing logic here
        System.out.println("Processing payment of $" + amount + " through PayPal.");
    }
}

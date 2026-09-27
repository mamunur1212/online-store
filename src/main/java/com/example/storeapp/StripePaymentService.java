package com.example.storeapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stripe")
public class StripePaymentService implements PaymentService {

    @Value("${stripe.apiUrl}")
    private String stripeUrl;

    @Value("${stripe.enabled}")
    private boolean isStripeEnabled;

    @Value("${stripe.timeout:5000}")
    private int timeout;

    @Value("${stripe.supported-currencies}")
    private List<String> supportedCurrencies;
    @Override
    public void processPayment(double amount) {
        // Implement Stripe payment processing logic here
        System.out.println("Processing payment of $" + amount + " through Stripe.");
        System.out.println("Stripe API URL: " + stripeUrl);
        System.out.println("Stripe Enabled: " + isStripeEnabled);
        System.out.println("Stripe Timeout: " + timeout + " seconds");
        System.out.println("Supported Currencies: " + supportedCurrencies);
    }
}

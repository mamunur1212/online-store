package com.example.storeapp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("email")
@Primary
public class EmailNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        // Logic to send email notification
        System.out.println("Sending email notification: " + message);
    }
}

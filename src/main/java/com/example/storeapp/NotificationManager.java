package com.example.storeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificationManager {
    private final NotificationService notificationService;

    @Autowired
    public NotificationManager(@Qualifier("sms") NotificationService notificationService) {
        System.out.println("NotificationManager initialized with " + notificationService.getClass().getSimpleName());
        this.notificationService = notificationService;
    }

    public void sendNotification(String message) {
        notificationService.send(message);
    }
}

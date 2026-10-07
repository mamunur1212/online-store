package com.example.storeapp.controllers;

import com.example.storeapp.entities.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @RequestMapping("/message")
    public Message getMessage() {
        return new Message("Hello from StoreApp!");
    }
}

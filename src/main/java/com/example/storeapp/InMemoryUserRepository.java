package com.example.storeapp;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private final Map<String, User> userMap = new HashMap<>();

    @Override
    public void save(User user) {
        userMap.put(user.getEmail(), user);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userMap.containsKey(email);
    }
}

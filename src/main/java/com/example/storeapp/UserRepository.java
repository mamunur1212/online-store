package com.example.storeapp;

public interface UserRepository {
    void save(User user);
    boolean existsByEmail(String email);
}

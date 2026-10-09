package com.example.storeapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterUserRequest {
    private String name;
    private String email;
    private String password;
}

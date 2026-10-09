package com.example.storeapp.mappers;

import com.example.storeapp.dtos.RegisterUserRequest;
import com.example.storeapp.dtos.UpdateUserRequest;
import com.example.storeapp.dtos.UserDto;
import com.example.storeapp.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);
    void update(UpdateUserRequest request, @MappingTarget User user);
}

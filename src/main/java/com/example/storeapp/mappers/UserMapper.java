package com.example.storeapp.mappers;

import com.example.storeapp.dtos.UserDto;
import com.example.storeapp.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
}

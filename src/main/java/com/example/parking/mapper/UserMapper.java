package com.example.parking.mapper;

import com.example.parking.dto.UserDTO;
import com.example.parking.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User entity);

    User toEntity(UserDTO dto);
}
package com.example.computer_shop.mappers;

import com.example.computer_shop.dto.UserRequestDto;
import com.example.computer_shop.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User mapToModel(UserRequestDto requestDto);
}

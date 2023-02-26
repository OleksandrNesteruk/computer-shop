package com.example.computer_shop.mappers;

import com.example.computer_shop.dto.ComputerDto;
import com.example.computer_shop.dto.OrderResponseDto;
import com.example.computer_shop.model.Order;
import com.example.computer_shop.model.computer_types.Computer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class OrderMapper {
    @Autowired
    protected ComputerMapper computerMapper;

    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "computers", source = "computers")
    @Mapping(target = "totalPrice", source = "totalPrice")
    public abstract OrderResponseDto mapToDto(Order order);

    protected List<ComputerDto> map(List<Computer> value) {
        return value.stream()
                .map(computerMapper::mapToSimplifiedDto)
                .toList();
    }
}

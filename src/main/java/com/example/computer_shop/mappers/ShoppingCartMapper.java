package com.example.computer_shop.mappers;

import com.example.computer_shop.dto.ComputerDto;
import com.example.computer_shop.dto.ShoppingCartResponseDto;
import com.example.computer_shop.model.ShoppingCart;
import com.example.computer_shop.model.computer_types.Computer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Mapper(componentModel = "spring" )
public abstract class ShoppingCartMapper {
    @Autowired
    protected ComputerMapper computerMapper;

    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "computers", source = "computers")
    @Mapping(target = "totalPrice", source = "totalPrice")
    public abstract ShoppingCartResponseDto mapToDto(ShoppingCart shoppingCart);

   protected List<ComputerDto> map(List<Computer> value) {
       return value.stream()
               .map(computerMapper::mapToSimplifiedDto)
               .toList();
   }
}

package com.example.computer_shop.mappers;

import com.example.computer_shop.dto.*;
import com.example.computer_shop.model.computer_types.Computer;
import com.example.computer_shop.model.computer_types.GamingComputer;
import com.example.computer_shop.model.computer_types.HomeComputer;
import com.example.computer_shop.model.computer_types.OfficeComputer;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.SubclassMapping;

import static org.mapstruct.SubclassExhaustiveStrategy.RUNTIME_EXCEPTION;

@Mapper(componentModel = "spring")
public abstract class ComputerMapper {
    @Mapping(target = "powerModule", source = "powerModule")
    @Mapping(target = "computerCase", source = "computerCase")
    @SubclassMapping(source = GamingComputer.class, target = GamingComputerResponseDto.class)
    @SubclassMapping(source = HomeComputer.class, target = HomeComputerResponseDto.class)
    @SubclassMapping(source = OfficeComputer.class, target = OfficeComputerResponseDto.class)
    @BeanMapping(subclassExhaustiveStrategy = RUNTIME_EXCEPTION)
    public abstract ComputerResponseDto mapToDto(Computer computer);

    public abstract ComputerDto mapToSimplifiedDto(Computer computer);
}

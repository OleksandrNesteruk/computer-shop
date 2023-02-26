package com.example.computer_shop.controller;

import com.example.computer_shop.dto.ComputerResponseDto;
import com.example.computer_shop.mappers.ComputerMapper;
import com.example.computer_shop.model.computer_types.Computer;
import com.example.computer_shop.service.ComputerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/computers")
public class ComputerController {
    private final ComputerService computerService;
    private final ComputerMapper computerMapper;

    @GetMapping
    public List<ComputerResponseDto> findAll() {
        List<Computer> computers = computerService.findAll();
        return computers.stream()
                .map(computerMapper::mapToDto)
                .toList();
    }
}

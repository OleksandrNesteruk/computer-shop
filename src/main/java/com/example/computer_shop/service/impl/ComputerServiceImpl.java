package com.example.computer_shop.service.impl;

import com.example.computer_shop.model.computer_types.Computer;
import com.example.computer_shop.repository.computer_parts.ComputerRepository;
import com.example.computer_shop.service.ComputerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComputerServiceImpl implements ComputerService {
    private final ComputerRepository computerRepository;

    @Override
    public void add(Computer computer) {
        computerRepository.save(computer);
    }

    @Override
    public Computer findById(Long id) {
        return computerRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Computer> findAll() {
        return computerRepository.findAll();
    }
}

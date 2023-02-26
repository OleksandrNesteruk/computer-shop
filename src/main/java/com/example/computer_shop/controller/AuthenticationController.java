package com.example.computer_shop.controller;

import com.example.computer_shop.dto.UserRequestDto;
import com.example.computer_shop.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping
    public void register(@RequestBody @Valid UserRequestDto requestDto) {
        authenticationService
                .register(requestDto.getEmail(),
                        requestDto.getPassword());
    }
}

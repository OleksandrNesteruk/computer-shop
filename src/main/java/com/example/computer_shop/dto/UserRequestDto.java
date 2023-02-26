package com.example.computer_shop.dto;

import com.example.computer_shop.lib.FieldsValueMatch;
import com.example.computer_shop.lib.ValidEmail;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@FieldsValueMatch(field = "password", fieldMatch = "repeatPassword",
        message = "Password do not match")
@Getter
@Setter
public class UserRequestDto {
    @ValidEmail
    private String email;
    @NotBlank
    @Size(min = 8, max = 40, message =" invalid password length")
    private String password;
    private String repeatPassword;
}
package com.example.user.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Setter
@Getter
public class UserDto {


    @NotBlank
    @Length(min = 4, max = 30)
    private String username;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    @Length(min = 4, max = 30)
    private String password;
}

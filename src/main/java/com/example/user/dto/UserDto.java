package com.example.user.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    private  Long id;
    private String username;
    private String password;
}

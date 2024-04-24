package com.example.user.controller;

import com.example.mapper.UserMapper;
import com.example.user.dto.UserDto;
import com.example.user.entity.User;
import com.example.user.model.UserModel;
import com.example.user.service.UserService;
import jakarta.validation.Valid;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    private final UserMapper mapper;

    @GetMapping("/users")
    public List<UserModel> getAllUsers() {
        return mapper.toListUserModel(userService.getAllUsers());
    }

    @PostMapping("/user")
    public UserModel createUser(@Valid @RequestBody UserDto user) {
        return mapper.toUserModel(userService.saveUser(user));
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable("id") long userId) {
        userService.deleteUser(userId);
    }

    @PutMapping("/user/{id}")
    public UserModel updateUser(@PathVariable("id") long userId, @Valid @RequestBody UserDto user) throws NotFoundException {
        return mapper.toUserModel(userService.updateUser(userId, user));
    }
}

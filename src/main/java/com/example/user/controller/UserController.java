package com.example.user.controller;

import com.example.mapper.UserMapper;
import com.example.user.dto.UserDto;
import com.example.user.entity.User;
import com.example.user.model.UserModel;
import com.example.user.service.UserService;
//import jakarta.validation.Valid;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;
    private final UserMapper mapper;

    @GetMapping("/users")
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return ResponseEntity.ok(mapper.toListUserModel(userService.getAllUsers()));
    }

    @PostMapping("/user")
    public ResponseEntity<UserModel> createUser(@Valid @RequestBody UserDto user) {
        return ResponseEntity.ok(mapper.toUserModel(userService.saveUser(user)));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable("id") long userId, @Valid @RequestBody UserDto user) throws NotFoundException {
        return ResponseEntity.ok(mapper.toUserModel(userService.updateUser(userId, user)));
    }
}

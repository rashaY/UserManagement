package com.example.user.controller;

import com.example.user.entity.User;
import com.example.user.service.UserService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping( "/users")
        public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable("id") long userId) {
        userService.deleteUser(userId);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable("id") long userId, @RequestBody User user) throws NotFoundException {
        return userService.updateUser(userId,user);
    }
}

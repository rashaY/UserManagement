package com.example.user.service;

import com.example.mapper.UserMapper;
import com.example.user.dto.UserDto;
import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

    public User saveUser(UserDto user) {
        return userRepository.save(mapper.toUserEntity(user));
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User updateUser(Long userId, UserDto updatedUser) throws NotFoundException {
        Optional<User> oldUser = userRepository.findById(userId);
        if (!oldUser.isPresent()) {
            throw new NotFoundException("User not found with id " + userId);
        }

        User newUser=mapper.toUserEntity(updatedUser);
        newUser.setId(userId);
        return userRepository.save(newUser);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

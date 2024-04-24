package com.example.user.service;

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

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User updateUser(Long userId, User updatesdUser) throws NotFoundException {
        Optional<User> oldUser = userRepository.findById(userId);
        if (!oldUser.isPresent()) {
            throw new NotFoundException("User not found with id " + userId);
        }
        updatesdUser.setId(userId);
        return userRepository.save(updatesdUser);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

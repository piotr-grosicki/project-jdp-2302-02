package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exception.userNotFoundException;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.dto.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Random;

@RestController
    @RequestMapping("/ecommercee/users")
    @RequiredArgsConstructor
    public class UserController {
    @Autowired
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "{userId}")
    public ResponseEntity<Void> banUser(@PathVariable Long userId) throws userNotFoundException {
        User banedUser = userRepository.findById(userId).get();
        banedUser.setActive(false);
        userRepository.save(banedUser);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "{userId}")
    public ResponseEntity<Integer> generateKey(@PathVariable Long userId) throws userNotFoundException {
        User activeUser = userRepository.findById(userId).get();
        activeUser.setExpiryDate(LocalDateTime.now());
        activeUser.setKey(new Random().nextInt(99999999));
        activeUser.setActive(true);
        userRepository.save(activeUser);
        return ResponseEntity.ok(userRepository.findById(userId).get().getKey());
    }
}
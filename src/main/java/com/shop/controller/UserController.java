package com.shop.controller;

import com.shop.domain.User;
import com.shop.domain.dto.UsersDto;
import com.shop.mapper.UserMapper;
import com.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
    @RequestMapping()
    @RequiredArgsConstructor
    @CrossOrigin()
    public class UserController {


        private final UserService userService;
        private final UserMapper userMapper;


        @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Void> createUser(@RequestBody UsersDto usersDto) {
            User user = userMapper.mapToUser(usersDto);
            userService.saveUser(user);
            return ResponseEntity.ok().build();
        }

        @PutMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<UsersDto> banUser(@RequestBody UsersDto usersDto) {
            User user = userMapper.mapToUser(usersDto);
            User banedUser = user.banUser(user);
            userService.saveUser(banedUser);
            return ResponseEntity.ok(userMapper.mapToUserDto(banedUser));
        }

        @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity generateKey(@RequestBody UsersDto usersDto) {
            User user = userMapper.mapToUser(usersDto);
            User userWithKey = user.generateKey(user);
            userService.saveUser(userWithKey);
            return ResponseEntity.ok(userMapper.mapToUserDto(userWithKey));
        }

    }

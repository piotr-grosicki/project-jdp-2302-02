package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/ecommercee/users")
    @RequiredArgsConstructor
    public class UserController {


        @PostMapping
        public void createUser(@RequestBody UserDto usersDto) {
        }

        @PutMapping
        public UserDto banUser(@RequestBody UserDto usersDto) {
            return new UserDto(1, "zbanowanyUser", false, 123456L);
        }

        @GetMapping
        public UserDto generateKey(@RequestBody UserDto usersDto) {
            return new UserDto(1, "userZKluczem", true, 123456L);
        }
    }

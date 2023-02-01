package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Key;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.dto.UsersDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.repository.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;




@RestController
    @RequestMapping("/ecommercee/users")
    @RequiredArgsConstructor
    public class UserController {


        private final UserService userService;
        private final UserMapper userMapper;


        @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
        public void createUser(@RequestBody UsersDto usersDto) {
        }

        @PutMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
        public UsersDto banUser(@RequestBody UsersDto usersDto) {
            User user = userMapper.mapToUser(usersDto);
            User banedUser = user.banUser(user);
            UsersDto banedUserDto = userMapper.mapToUserDto(banedUser);
            return banedUserDto;
        }

        @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
        public UsersDto generateKey(@RequestBody UsersDto usersDto) {
    User user= new User(1, "zkluczem");
       Key key = new Key();
            return new UsersDto(1, "userZKluczem", true, key.activeKey(key)  );
        }

    }

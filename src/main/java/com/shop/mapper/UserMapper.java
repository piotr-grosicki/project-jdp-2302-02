package com.shop.mapper;

import com.shop.domain.User;
import com.shop.domain.dto.UsersDto;

public class UserMapper {

    public User mapToUser(final UsersDto usersDto) {
        return new User( usersDto.getId(), usersDto.getName());
    }

    public UsersDto mapToUserDto(final User user) {
        return new UsersDto(  user.getId(),  user.getName());
    }
}

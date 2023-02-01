package com.shop.service;

import com.shop.domain.User;
import com.shop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

public User saveUser(final User user){
    return userRepository.save(user);
}

}

package com.shop.repository;

import com.shop.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User,Integer > {

    @Override
    User save (User user);
}

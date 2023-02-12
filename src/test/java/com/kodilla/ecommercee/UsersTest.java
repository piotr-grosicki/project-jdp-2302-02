package com.kodilla.ecommercee;



import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersTest {


    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUsersRepositoryPost() {
        //Given
        User user1 = new User("Tomek");
        User user2 = new User("Romek");
        User user3 = new User("Atomek");
        User user4 = new User("Bolek");
        User user5 = new User("Olek");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);

        //When
        long usersRepositorySize = userRepository.count();

        //  Then
        Assert.assertEquals(5, usersRepositorySize);

        //CleanUp
        userRepository.deleteAll();
    }

    @Test
    public void testUsersRepositoryGet() {
        //Given
        User user1 = new User("Tomek");
        User user2 = new User("Romek");
        User user3 = new User("Atomek");
        User user4 = new User("Bolek");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);

        //When
        List<User> testUser = userRepository.findAll();

        //Then
        Assert.assertEquals(4, testUser.size());

        //CleanUp
        userRepository.deleteAll();
    }

    @Test
    public void testUsersRepositoryPut() {
        //Given
        User user1 = new User("Tomek");
        User user2 = new User("Romek");
        User user3 = new User("Atomek");
        User user4 = new User("Bolek");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);

        //When
        User editedUser = userRepository.findById(user3.getUserId()).get();
        editedUser.setName("Matolek");
        userRepository.save(editedUser);

        //Then
        Assert.assertEquals("Matolek", userRepository.findById(user3.getUserId()).get().getName());

        //CleanUp
        userRepository.deleteAll();
    }

    @Test
    public void testUsersRepositoryDelete() {
        //Given
        User user1 = new User("Tomek");
        User user2 = new User("Romek");
        User user3 = new User("Atomek");
        User user4 = new User("Bolek");
        User user5 = new User("Olek");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);

        //When
        userRepository.deleteAll();
        long userRepositorySize = userRepository.count();

        //Then
        Assert.assertEquals(0, userRepositorySize);

        //CleanUp
        userRepository.deleteAll();
    }
}
package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
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
public class CartTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartRepository cartRepository;

    @Test
    public void tesCartRepositoryPost() {
        //Given
        User user1 = new User("Tomek");
        User user2 = new User("Romek");
        User user3 = new User("Atomek");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        Cart cart1 = new Cart(user1);
        Cart cart2 = new Cart(user1);
        Cart cart3 = new Cart(user2);
        Cart cart4 = new Cart(user2);
        Cart cart5 = new Cart(user3);
        cartRepository.save(cart1);
        cartRepository.save(cart2);
        cartRepository.save(cart3);
        cartRepository.save(cart4);
        cartRepository.save(cart5);

        //When
        long cartRepositorySize = cartRepository.count();

        //Then
        Assert.assertEquals(5, cartRepositorySize);

        //CleanUp
        userRepository.deleteAll();
        cartRepository.deleteAll();
    }

    @Test
    public void testCartRepositoryGet() {
        //Given
        User user1 = new User("Tomek");
        User user2 = new User("Romek");
        User user3 = new User("Atomek");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        Cart cart1 = new Cart(user1);
        Cart cart2 = new Cart(user1);
        Cart cart3 = new Cart(user2);
        Cart cart4 = new Cart(user2);
        cartRepository.save(cart1);
        cartRepository.save(cart2);
        cartRepository.save(cart3);
        cartRepository.save(cart4);

        //When
        List<Cart> testCart = cartRepository.findAll();

        //Then
        Assert.assertEquals(4, testCart.size());

        //CleanUp
        userRepository.deleteAll();
        cartRepository.deleteAll();
    }

    @Test
    public void testCartRepositoryPut() {
        //Given
        User user1 = new User("Tomek");
        User user2 = new User("Romek");
        User user3 = new User("Atomek");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        Cart cart1 = new Cart(user1);
        Cart cart2 = new Cart(user1);
        Cart cart3 = new Cart(user2);
        Cart cart4 = new Cart(user2);
        Cart cart5 = new Cart(user3);
        cartRepository.save(cart1);
        cartRepository.save(cart2);
        cartRepository.save(cart3);
        cartRepository.save(cart4);
        cartRepository.save(cart5);

        //When
        Cart editCart = cartRepository.findById(cart5.getId()).orElse(null);
        editCart.setUser(user1);
        cartRepository.save(editCart);
        String nameOfNewUser = cartRepository.findById(cart5.getId()).get().getUser().getName();

        //Then
        Assert.assertEquals(nameOfNewUser, "Tomek");

        //CleanUp
        userRepository.deleteAll();
        cartRepository.deleteAll();
    }

    @Test
    public void testCartRepositoryDeleteOnlyCart() {
        //Given
        User user1 = new User("Tomek");
        User user2 = new User("Romek");
        User user3 = new User("Atomek");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        Cart cart1 = new Cart(user1);
        Cart cart2 = new Cart(user1);
        Cart cart3 = new Cart(user2);
        Cart cart4 = new Cart(user2);
        Cart cart5 = new Cart(user3);
        cartRepository.save(cart1);
        cartRepository.save(cart2);
        cartRepository.save(cart3);
        cartRepository.save(cart4);
        cartRepository.save(cart5);

        //When
        cartRepository.deleteAll();

        //Then
        Assert.assertEquals(3L, userRepository.count());
        Assert.assertEquals(0L, cartRepository.count());

        //CleanUp
        userRepository.deleteAll();
        cartRepository.deleteAll();
    }

    @Test
    public void testCartRepositoryDeleteUser() {
        //Given
        User user1 = new User("Tomek");
        User user2 = new User("Romek");
        User user3 = new User("Atomek");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);

        Cart cart1 = new Cart(user1);
        Cart cart2 = new Cart(user1);
        Cart cart3 = new Cart(user2);
        Cart cart4 = new Cart(user2);
        Cart cart5 = new Cart(user3);
        cartRepository.save(cart1);
        cartRepository.save(cart2);
        cartRepository.save(cart3);
        cartRepository.save(cart4);
        cartRepository.save(cart5);

        //When
        userRepository.deleteAll();

        //Then
        Assert.assertEquals(0L, userRepository.count());
        Assert.assertEquals(0L, cartRepository.count());

        //CleanUp
        userRepository.deleteAll();
        cartRepository.deleteAll();
    }
}
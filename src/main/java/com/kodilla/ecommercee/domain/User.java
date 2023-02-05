package com.kodilla.ecommercee.domain;

import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;



@Entity
@Table(name = "USERS")
@Data
public class User {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "USER_ID")
    long userId;

    @NotNull
    @Column(name = "NAME")
    String name;

    @Column(name = "IS_ACTIVE")
    boolean isActive;

    @Column(name = "KEY1")
    LocalDateTime expiryDate = null;

    @Column(name = "KEY2")
    int key = -1;

    @OneToMany(
            targetEntity = Cart.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    List<Cart> carts;
}
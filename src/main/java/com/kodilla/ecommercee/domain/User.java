package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
@Data
public class User {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "USER_ID", unique = true)
    private long userId;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @Column(name = "IS_ACTIVE")
    private boolean isActive;

    @Column(name = "KEY1")
    private LocalDateTime expiryDate = null;

    @Column(name = "KEY2")
    private int key = -1;

    @OneToMany(
            targetEntity = Cart.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Cart> carts;
}
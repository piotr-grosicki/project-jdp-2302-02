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

    @Id()
    @GeneratedValue
    @NotNull
    @Column(name = "USER_ID")
    int UserId;

    @NotNull
    @Column(name = "NAME")
    String name;

    @Column(name = "IS_ACTIVE"  )
    boolean isActive;

    @Transient
   RandomKey randomKey = new RandomKey();

    @Column(name = "KEY1")
  LocalDateTime key1 =randomKey.getKey1();

    @Column(name = "KEY2")
  int key2 = randomKey.getKey2();

    @OneToMany(
            targetEntity = Cart.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    List <Cart> carts;

}










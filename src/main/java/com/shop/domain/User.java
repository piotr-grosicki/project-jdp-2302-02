package com.shop.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Random;

@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {
    public int id;
    public String name;
    public boolean isActive;
    public Key key;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.isActive = false;
        this.key = new Key();
    }

    public User banUser(User user) {
        user.isActive = false;
        return user;
    }

    public User generateKey(User user) {
        user.isActive = true;
        user.key.key1 = LocalDateTime.now();
        user.key.key2 = new Random().nextInt(999999);
        return user;
    }

    @Id()
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @Column(name = "IS_ACTIVE")
    public boolean isActive() {
        return isActive;
    }

    @Column(name = "KEY_1")
    public LocalDateTime getKey1() {
        return key.getKey1();
    }

    @Column(name = "KEY_2")
    public int getKey2() {
        return key.getKey2();
    }


    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setActive(boolean active) {
        isActive = active;
    }

    private void setKey1(LocalDateTime localDateTime) {
        key.setKey1(localDateTime);
    }

    private void setKey2(int key2) {
        key.setKey2(key2);
    }

    private  void setKey(Key key) {
        this.key = key;
    }
}

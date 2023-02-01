package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.Key;
import lombok.Data;

import java.time.LocalTime;


@Data
public class UsersDto {
    public int id;
    public String name;
    public  boolean isActive;
    public Key key;


    public UsersDto (int id, String name) {
        this.id = id;
        this.name = name;
        this.isActive = false;
        this.key = new Key();
    }

    public UsersDto (int id, String name, boolean isActive, Key key) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.key = key;
    }



}

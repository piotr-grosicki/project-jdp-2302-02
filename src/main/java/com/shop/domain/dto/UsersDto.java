package com.shop.domain.dto;

import com.shop.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
public class UsersDto {
    public int id;
    public String name;
    public  boolean isActive;
    public LocalTime key;

    public UsersDto (int id, String name) {
        this.id=id;
        this.name=name;
        isActive=false;
    }





}

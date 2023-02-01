package com.kodilla.ecommercee.domain;

import lombok.Data;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class Key {
    LocalDate date1 = LocalDate.of(1990, 1, 1);
    LocalTime date2 = LocalTime.of(1, 1);
    LocalDateTime key1;
    int key2;

    public Key() {
        this.key1 = LocalDateTime.of(date1, date2);
        this.key2 = -1;
    }

    public Key activeKey(Key key) {
        key.setKey1(LocalDateTime.now());
        key.setKey2(999);
        return key;
    }

}

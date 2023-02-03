package com.kodilla.ecommercee.domain;


import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

@Data
public class RandomKey {
    LocalDate date1 = LocalDate.of(1990, 1, 1);
    LocalTime date2 = LocalTime.of(1, 1);
    LocalDateTime key1;
    int key2;

    public RandomKey() {
        this.key1 = LocalDateTime.of(date1, date2);
        this.key2 = -1;
    }

    public RandomKey activateKey(RandomKey randomKey) {
        randomKey.setKey1(LocalDateTime.now());
        randomKey.setKey2(new Random().nextInt(999999));
        return randomKey;
    }
}
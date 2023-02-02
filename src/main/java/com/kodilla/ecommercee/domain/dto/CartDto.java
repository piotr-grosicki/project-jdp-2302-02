package com.kodilla.ecommercee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CartDto {
    private Long id;
    private int quantity;
    private Long userId;
    private Long productId;
}

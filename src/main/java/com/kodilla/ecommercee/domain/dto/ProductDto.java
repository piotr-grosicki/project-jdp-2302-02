package com.kodilla.ecommercee.domain.dto;


public class ProductDto {
    private Long id;
    private String name;
    private double price;
    private Long groupId;

    public ProductDto(Long id, String name, double price, Long groupId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.groupId = groupId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Long getGroupId() {
        return groupId;
    }
}

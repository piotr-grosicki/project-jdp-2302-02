package com.kodilla.ecommercee.domain;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Cart {


    @ManyToOne
    @JoinColumn(name="USERS_CARTS")
private User user;


    @Id()
    @GeneratedValue
    @NotNull
    @Column(name = "CART_ID")
    private int CartId;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Product> productList = new ArrayList<>();
}

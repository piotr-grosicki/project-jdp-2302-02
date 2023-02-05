package com.kodilla.ecommercee.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "CARTS")
public class Cart {

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "CART_ID", unique = true)
    private Long cartId;

    @Column(name = "QUANTITY")
    private int productQuantity = 0;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_CARTS_PRODUCTS",
            joinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")}
    )
    private List<Product> productList = new ArrayList<>();

    public Cart(User user) {
        this.user = user;
    }
}

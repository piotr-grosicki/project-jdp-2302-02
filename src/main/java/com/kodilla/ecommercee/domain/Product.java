package com.kodilla.ecommercee.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column
    private String name;

    @NotNull
    @Column
    private double price;

    @ManyToOne
    @NotNull
    @JoinColumn
    private Group group;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "productList")
    private List<Cart> cartList = new ArrayList<>();
}

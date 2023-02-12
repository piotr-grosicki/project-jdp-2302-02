package com.kodilla.ecommercee.domain;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCTS")
@Data
public class Product {

    public Product( Group group, String name, BigDecimal price) {
        this.name = name;
        this.price = price;
        this.group = group;
    }

    @Id
    @NotNull
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "PRICE")
    private BigDecimal price;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "GROUP_ID")
    private Group group;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "productList")
    private List<Cart> cartList = new ArrayList<>();

    public Product(String name, BigDecimal price, Group group) {
        this.name = name;
        this.price = price;
        this.group = group;
    }
}

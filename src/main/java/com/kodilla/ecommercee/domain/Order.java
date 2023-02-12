package com.kodilla.ecommercee.domain;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "ORDERS")
public class Order {


    @Id
    @NotNull
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "ID",unique = true)
    private Long id;
    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDERS_CART")
    private Cart cart;

    public Order(String name,Cart cart){
        this.name = name;
        this.cart = cart;
    }

}
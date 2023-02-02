package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.dto.ProductDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ecommerce/carts")
public class CartController {

    @GetMapping(value = "{cartId}")
    public List<ProductDto> getAllProductsFromCart(@PathVariable Long cartId) {
        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(new ProductDto(1L, "TestProductList", 10.0, 1L, 1L));

        return productDtoList;
    }

    @GetMapping(value = "{cartId}/{productId}")
    public ProductDto getProduct(@PathVariable Long cartId, @PathVariable Long productId) {
        return new ProductDto(cartId, "TestProduct", 10.0, 1L, productId);
    }

    @DeleteMapping(value = "{cartId}/{productId}")
    public void deleteProduct(@PathVariable Long cartId, @PathVariable Long productId) {

    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "{cartId}")
    public List<ProductDto> addProductToCart(@PathVariable Long cartId ,@RequestBody List<ProductDto> productDtoList) {
        return productDtoList;
    }

    @PostMapping(value = "/new/order/{cartId}")
    public void createOrder(@PathVariable Long cartId)  {

    }

    @PostMapping(value = "/new/cart/{userId}")
    public void createEmptyCart(@PathVariable Long userId)  {

    }
}

package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.ProductDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ecommerce/products")
public class ProductController {

    @GetMapping
    public List<ProductDto> getProducts() {
        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(new ProductDto());

        return productDtoList;
    }

    @GetMapping(value = "{cartId}")
    public ProductDto getProduct(@PathVariable Long cartId) {
        return new ProductDto();
    }

    @DeleteMapping(value = "{cartId}")
    public void deleteProduct(@PathVariable Long cartId) {

    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return productDto;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody ProductDto productDto)  {

    }

}

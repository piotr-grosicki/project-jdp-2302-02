package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.ProductDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ecommerce/products")
public class ProductController {

    @GetMapping
    public List<ProductDto> getProducts() {
        List<ProductDto> productDtoList = new ArrayList<>();
        productDtoList.add(new ProductDto(1L, "TestProductList", 10.0, 1L, 1L));

        return productDtoList;
    }

    @GetMapping(value = "{id}")
    public ProductDto getProduct(@PathVariable Long id) {
        return new ProductDto(1L, "TestProduct", 10.0, 1L, 1L);
    }

    @DeleteMapping(value = "{id}")
    public void deleteProduct(@PathVariable Long id) {

    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return productDto;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody ProductDto productDto)  {

    }

}

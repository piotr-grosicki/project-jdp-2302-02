package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ecommercee/orders")
@RequiredArgsConstructor
public class OrderController {

    @GetMapping
    public List<OrderDto> getOrders(){
        List<OrderDto> orderDtoList = new ArrayList<>();
        orderDtoList.add(new OrderDto(1L, "zwrot wszytkich orderow"));
        return orderDtoList;
    }

    @GetMapping(value = "{id}")
    public OrderDto getOrder(@PathVariable long id){

        return new OrderDto(2L, "zwrot pojedynczego orderu");
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
    public List<OrderDto> addOrder(@PathVariable Long id,@RequestBody OrderDto orderDto) {
        List<OrderDto> orderDtoList= new ArrayList<>();
        orderDtoList.add(orderDto);
        return orderDtoList;
    }

    @PutMapping
    public OrderDto editOrder(@RequestBody OrderDto OrderDto){

        return new OrderDto(3L, "test edycji orderu");
    }

    @DeleteMapping("{id}")
    public void deleteOrder(@PathVariable Long id) {
    }
}

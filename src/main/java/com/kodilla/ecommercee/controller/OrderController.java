package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import lombok.RequiredArgsConstructor;
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
        orderDtoList.add(new OrderDto(1L,"test"));
        return orderDtoList;

    }
    @GetMapping(value = "{orderId}")
    public OrderDto getOrder(@PathVariable long orderId){
        return new OrderDto(1L,"test");
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return order;
    }

    @PutMapping
    public OrderDto editOrder(OrderDto orderDto){
        return new OrderDto(1L,"test");
    }


    @DeleteMapping("{orderId}")
    public void deleteOrder(@PathVariable Long oderId) {

    }

}

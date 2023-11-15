package com.northwind.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.northwind.api.dto.OrderDto;
import com.northwind.api.entities.Order;
import com.northwind.api.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @GetMapping("/{id}")
    public OrderDto findById(@PathVariable("id") Long id) {

        Order order = service.findById(id);
        return order.convertToDto();

    }

    @GetMapping
    public List<Order> findAll() {
        return service.findAllEntity();
    }

}

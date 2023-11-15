package com.northwind.api.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.*;
import lombok.Setter;
import lombok.Getter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.northwind.api.dto.OrderDetailDto;
import com.northwind.api.dto.OrderDto;

@Entity
@Table(name = "orders")
@Setter
@Getter
public class Order {

    @Id
    @Column(name = "orderid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name = "orderdate")
    private LocalDateTime orderDate;

    @Column(name = "shipname")
    private String shipName;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "\"Order Details\"",
        joinColumns = @JoinColumn(name = "orderid"),
        inverseJoinColumns = @JoinColumn(name = "productid")
    )
    private List<Product> products;

    public OrderDto convertToDto(){

        List<OrderDetailDto> orderDetailsDto = orderDetails.stream().map(item -> item.convertToDto()).collect(Collectors.toList());
        return OrderDto.builder()
        .orderId(orderId)
        .orderDate(orderDate)
        .shipName(shipName)
        .orderDetails(orderDetailsDto)
        .build();
    }
     
}

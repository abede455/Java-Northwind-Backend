package com.northwind.api.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.northwind.api.dto.OrderDto;
import com.northwind.api.entities.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto map(Order order);
    List<OrderDto> map(List<Order> orders);
    
}

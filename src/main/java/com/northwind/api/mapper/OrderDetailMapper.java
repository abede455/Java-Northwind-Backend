package com.northwind.api.mapper;

import org.mapstruct.Mapper;

import com.northwind.api.dto.OrderDetailDto;
import com.northwind.api.entities.OrderDetail;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {

    OrderDetailDto map(OrderDetail orderDetail);
    
}

package com.northwind.api.mapper;

import com.northwind.api.dto.CustomerDto;
import com.northwind.api.entities.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto map(Customer customer);
    Customer map(CustomerDto customerDto);
    List<CustomerDto> map(List<Customer> customers);
}

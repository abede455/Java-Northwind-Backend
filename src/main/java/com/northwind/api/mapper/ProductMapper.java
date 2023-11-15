package com.northwind.api.mapper;

import com.northwind.api.dto.ProductName;
import com.northwind.api.entities.Product;

public interface ProductMapper {

    ProductName map(Product product);
    
}

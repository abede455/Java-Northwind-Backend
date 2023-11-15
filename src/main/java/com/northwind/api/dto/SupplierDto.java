package com.northwind.api.dto;

import java.util.Set;

import lombok.Data;

@Data
public class SupplierDto {
    
    private Long supplierId;

    private String companyName;

    private String city;
    
    private Set<ProductDto> products;
    
}

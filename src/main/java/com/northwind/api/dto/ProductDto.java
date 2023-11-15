package com.northwind.api.dto;

import java.util.List;



import lombok.Data;


@Data
public class ProductDto {
    private Long productId;

    private String productName;

    private Double unitPrice;

    private List<OrderDetailDto> orderDetails;

}

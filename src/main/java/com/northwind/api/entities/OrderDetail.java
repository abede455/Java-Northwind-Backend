package com.northwind.api.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.northwind.api.dto.OrderDetailDto;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "\"Order Details\"")
public class OrderDetail {

    @EmbeddedId
    private OrderDetailId id;

    @Column(name = "unitprice")
    private Double unitPrice;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "discount")
    private Double discount;

    @ManyToOne
    @JoinColumn(name = "productid", insertable = false, updatable = false)
    private Product product;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "orderid", insertable = false, updatable = false)
    private Order order;

    public OrderDetailDto convertToDto(){
        return OrderDetailDto.builder()
        .unitPrice(unitPrice)
        .quantity(quantity)
        .discount(discount)
        .productName(product.getProductName())
        .build();
    }

}

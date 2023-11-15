package com.northwind.api.entities;

import java.io.Serializable;
import lombok.Getter;

import javax.persistence.*;

@Embeddable
@Getter
public class OrderDetailId implements Serializable {

    @Column(name = "orderid", nullable = false)
    private Long orderId;

    @Column(name = "productid", nullable = false)
    private Long productId;
    
}

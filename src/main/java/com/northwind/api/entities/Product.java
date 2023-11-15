package com.northwind.api.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "products", schema = "dbo")
public class Product {
    @Id
    @Column(name = "productid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "productname")
    private String productName;

    @Column(name = "unitprice")
    private Double unitPrice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplierid")
    @JsonIgnore
    private Supplier supplier;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryid")
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

    @OneToMany(mappedBy = "product")
    private List<ProductPhoto> productPhotos;

}

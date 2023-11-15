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
@Table(name = "suppliers", schema = "dbo")
public class Supplier {
    @Id
    @Column(name = "supplierid", updatable = false, nullable = false)
    private Long supplierId;

    @Column(name = "companyname")
    private String companyName;

    @Column(name = "city")
    private String city;

    @JsonIgnore
    @OneToMany(mappedBy = "supplier")
    private List<Product> products;
}

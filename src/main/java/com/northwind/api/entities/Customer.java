package com.northwind.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="customers",schema="dbo")
public class Customer {
    @Id
    @Column(name="customerid",updatable = false, nullable = false)
    private String customerId;

    @Column(name="companyname")
    private String companyName;

    @Column(name="contactname")
    private String contactName;

    @Column(name="contacttitle")
    private String contactTitle;

    @Column(name="address")
    private String address;

    @Column(name="city")
    private String city;

    @Column(name="country")
    private String country;
}

package com.northwind.api.service;

import com.northwind.api.entities.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findCustomersByCountry(String country);

    Customer findById(String id);

    Customer updateCustomerContact(String contact, String customerId);
}

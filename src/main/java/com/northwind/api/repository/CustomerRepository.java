package com.northwind.api.repository;

import com.northwind.api.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query(value = "SELECT * FROM dbo.customers where lower(country)=:country", nativeQuery = true)
    List<Customer> findCustomersByCountry(String country);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update dbo.customers  set contacttitle=:contact where customerid=:customerId", nativeQuery = true)
    int updateCustomerContact(String contact,String customerId);

}

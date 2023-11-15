package com.northwind.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.northwind.api.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
    
}

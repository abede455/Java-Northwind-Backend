package com.northwind.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.northwind.api.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}

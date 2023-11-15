package com.northwind.api.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.northwind.api.entities.Order;
import com.northwind.api.exception.EntityNotFoundException;
import com.northwind.api.repository.OrderRepository;
import com.northwind.api.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    @Override
    public Optional<Order> createEntity(Order Entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createEntity'");
    }

    @Override
    public List<Order> findAllEntity() {
        return repository.findAll(); 
    }

    @Override
    public Order findById(Long id) {
        return repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Order not found"));
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
    
}

package com.northwind.api.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.northwind.api.entities.Product;
import com.northwind.api.exception.EntityNotFoundException;
import com.northwind.api.repository.ProductRepository;
import com.northwind.api.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public Optional<Product> createEntity(Product Entity) {
        return Optional.of(repository.save(Entity));
    }

    @Override
    public List<Product> findAllEntity() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllEntity'");
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("product not found"));
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

}

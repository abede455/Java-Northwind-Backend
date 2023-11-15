package com.northwind.api.service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.northwind.api.entities.Supplier;
import com.northwind.api.exception.EntityNotFoundException;
import com.northwind.api.repository.SupplierRepository;
import com.northwind.api.service.SupplierService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository repository;


    @Override
    public Optional<Supplier> createEntity(Supplier Entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createEntity'");
    }

    @Override
    public List<Supplier> findAllEntity() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllEntity'");
    }

    @Override
    public Supplier findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Supplier Not Found"));
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
    
}

package com.northwind.api.controller;

import com.northwind.api.entities.Supplier;
import com.northwind.api.repository.SupplierRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    private final SupplierRepository repository;

    public SupplierController(SupplierRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Supplier> getAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Supplier getById(@PathVariable("id") Long id){
        return repository.findById(id).get();
    }

    @GetMapping("/search")
    public Page<Supplier> getAllOrByCity(
        @RequestParam(name = "city", defaultValue = "") String city,
        @RequestParam(name = "page", defaultValue = "0") int page,
        @RequestParam(name = "size", defaultValue = "10") int size,
        @RequestParam(name = "sort", defaultValue = "city") String sort
    ){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        if(!city.isEmpty()){
            return repository.findByCityIgnoreCase(city, pageable);
        }
        return repository.findAll(pageable);
    }



}

package com.northwind.api.controller;

import com.northwind.api.dto.CustomerDto;
import com.northwind.api.dto.CustomerUpdateContactDto;
import com.northwind.api.entities.Customer;
import com.northwind.api.mapper.CustomerMapper;
import com.northwind.api.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;
    private final CustomerMapper mapper;

    public CustomerController(CustomerService service, CustomerMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }
    @GetMapping("/search")
    public ResponseEntity<?> findAllCustomerByCountry(@QueryParam("country") String country){
        List<CustomerDto> categoriesDto =mapper.map(service.findCustomersByCountry(country.toLowerCase()));
        return new ResponseEntity<>(categoriesDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerUpdateContactDto data){
        Customer customer = service.updateCustomerContact(data.getContact(), data.getCustomerId());
        CustomerDto customerDto = mapper.map(customer);
        return ResponseEntity.ok(customerDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getById(@PathVariable("id") String id){
        Customer customer = service.findById(id);
        return ResponseEntity.ok(mapper.map(customer));
    }
}

package com.northwind.api.service.implementations;

import com.northwind.api.entities.Customer;
import com.northwind.api.exception.EntityNotFoundException;
import com.northwind.api.repository.CustomerRepository;
import com.northwind.api.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> findCustomersByCountry(String country) {
        return repository.findCustomersByCountry(country);
    }

    @Override
    public Customer findById(String id) {
        return repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Customer Not Found"));
    }

    @Override
    public Customer updateCustomerContact(String contact, String customerId) {
        int result = repository.updateCustomerContact(contact, customerId);
        if (result == 0){
            throw new EntityNotFoundException("Customer Not Found");
        }
        return findById(customerId);
    }
}

package com.northwind.api.service.implementations;

import com.northwind.api.entities.Category;
import com.northwind.api.exception.EntityNotFoundException;
import com.northwind.api.repository.CategoryRepository;
import com.northwind.api.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository){
        this.repository = repository;
    }
    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }
    @Override
    public Optional<Category> createEntity(Category Entity) {
        Optional<Category> category = Optional.of(repository.save(Entity));
        return category;
    }
    @Override
    public List<Category> findAllEntity() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllEntity'");
    }
    @Override
    public Category findById(Long id) {
        return repository.findById(id).orElseThrow(()->new EntityNotFoundException("Category Not Found"));
    }
    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
   
}

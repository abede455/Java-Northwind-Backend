package com.northwind.api.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID> {
    Optional<T> createEntity(T Entity);
    List<T> findAllEntity();
    T findById(ID id);
    void deleteById(ID id);  
}

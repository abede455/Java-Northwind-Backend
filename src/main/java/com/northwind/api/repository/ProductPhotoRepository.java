package com.northwind.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.northwind.api.entities.ProductPhoto;

public interface ProductPhotoRepository extends JpaRepository<ProductPhoto, Long> {
    
}

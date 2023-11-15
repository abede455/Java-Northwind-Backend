package com.northwind.api.service;

import org.springframework.web.multipart.MultipartFile;

import com.northwind.api.entities.Product;
import com.northwind.api.entities.ProductPhoto;

public interface ProductPhotoService extends BaseService<ProductPhoto, Long> {

    ProductPhoto createEntity(MultipartFile file, Product product);

    void init();
    
}

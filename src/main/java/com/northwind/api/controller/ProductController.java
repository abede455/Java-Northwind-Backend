package com.northwind.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.northwind.api.dto.FormUploadDto;
import com.northwind.api.entities.Category;
import com.northwind.api.entities.Product;
import com.northwind.api.entities.ProductPhoto;
import com.northwind.api.entities.Supplier;
import com.northwind.api.service.CategoryService;
import com.northwind.api.service.ProductPhotoService;
import com.northwind.api.service.ProductService;
import com.northwind.api.service.SupplierService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final SupplierService supplierService;
    private final CategoryService categoryService;
    private final ProductService productService;
    private final ProductPhotoService productPhotoService;

    @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Product uploadProductPhoto(@ModelAttribute FormUploadDto formUpload) {

        Supplier supplier = supplierService.findById(formUpload.getSupplierId());
        Category category = categoryService.findById(formUpload.getCategoryId());
        Product product = new Product();
        product.setProductName(formUpload.getProductName());
        product.setUnitPrice(formUpload.getUnitPrice());
        product.setSupplier(supplier);
        product.setCategory(category);
        product = productService.createEntity(product).get();

        for (MultipartFile file : formUpload.getFilename()) {
            productPhotoService.createEntity(file, product);
        }
        // product.setProductPhotos(productPhotos);
        return productService.findById(product.getProductId());

    }

    @GetMapping("{id}")
    public Product getById(@PathVariable("id") Long id) {
        return productService.findById(id);
    }

}

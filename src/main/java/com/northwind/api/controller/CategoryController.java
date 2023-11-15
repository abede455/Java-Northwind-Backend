package com.northwind.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.northwind.api.dto.CategoryDto;
import com.northwind.api.entities.Category;
import com.northwind.api.mapper.CategoryMapper;
import com.northwind.api.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final Logger logger = LoggerFactory.getLogger(CategoryController.class);
    private final CategoryService service;
    private final CategoryMapper mapper;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<CategoryDto> categoriesDto = mapper.map(service.findAll());
        logger.debug("Resource : get categories");
        return new ResponseEntity<>(categoriesDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createEntity(@Valid @RequestBody CategoryDto categoryDto) {
        Category category = mapper.map(categoryDto);
        category = service.createEntity(category).get();
        categoryDto = mapper.map(category);
        return new ResponseEntity<>(categoryDto, HttpStatus.CREATED);

    }

}

package com.northwind.api.service;

import com.northwind.api.entities.Category;

import java.util.List;

public interface CategoryService extends BaseService<Category, Long> {

    List<Category> findAll();
}

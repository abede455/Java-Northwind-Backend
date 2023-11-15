package com.northwind.api.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.northwind.api.dto.CategoryDto;
import com.northwind.api.entities.Category;

@Mapper(componentModel="spring")
public interface CategoryMapper {

    CategoryDto map(Category category);

    Category map(CategoryDto categoryDto);

    List<CategoryDto> map(List<Category> categories);
    
}

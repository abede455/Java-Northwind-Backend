package com.northwind.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CategoryDto {

    private Long categoryId;

    @Size(max = 55, message = "size max 55")
    @NotBlank
    private String categoryName;

}

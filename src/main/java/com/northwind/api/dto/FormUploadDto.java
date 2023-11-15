package com.northwind.api.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormUploadDto {
    private String productName;
    private Long supplierId;
    private Long categoryId;
    private Double unitPrice;
    private List<MultipartFile> filename;
}

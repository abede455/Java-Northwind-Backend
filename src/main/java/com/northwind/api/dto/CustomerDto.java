package com.northwind.api.dto;

import lombok.Setter;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CustomerDto {
    @Size(max = 5)
    @NotBlank
    private String customerId;
    @NotBlank
    @Size(max = 40)
    private String companyName;
    @Size(max = 30)
    private String contactName;
    @Size(max = 30)
    private String contactTitle;
    @Size(max = 60)
    private String address;
    @Size(max = 15)
    private String city;
    @Size(max = 15)
    private String country;
}

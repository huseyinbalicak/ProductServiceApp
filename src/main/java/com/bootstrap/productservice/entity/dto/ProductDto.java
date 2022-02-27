package com.bootstrap.productservice.entity.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {
    private String name;
    private String desc;
    private Double price;
}

package com.bootstrap.productservice.entity.mapper;


import com.bootstrap.productservice.entity.Product;
import com.bootstrap.productservice.entity.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

    public ProductDto toProductDto(Product product){
        return new ProductDto(product.getName(), product.getDesc(), product.getPrice());
    }

    public List<ProductDto> toProductDtos(List<Product> list){
        return list.stream().map(this::toProductDto).collect(Collectors.toList());
    }

}

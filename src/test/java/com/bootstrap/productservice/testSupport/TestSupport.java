package com.bootstrap.productservice.testSupport;

import com.bootstrap.productservice.entity.Product;
import com.bootstrap.productservice.entity.dto.ProductDto;

import java.util.Arrays;
import java.util.List;

public class TestSupport {

    public Product generateProduct(){
        return new Product("test","test",12.5);
    }

    public ProductDto generateProductDto(){
        return new ProductDto("testDto","testDto",100.0);
    }

    public List<Product> generateProductList(){
        return Arrays.asList(generateProduct());
    }

    public List<ProductDto> generateProductDtoList(){
        return Arrays.asList(generateProductDto());
    }

}

package com.bootstrap.productservice.service;

import com.bootstrap.productservice.entity.Product;
import com.bootstrap.productservice.entity.dto.ProductDto;
import com.bootstrap.productservice.entity.mapper.Mapper;
import com.bootstrap.productservice.exception.ProductNotFoundException;
import com.bootstrap.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final Mapper mapper;

    public ProductService(ProductRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ProductDto> getAllProducts(){
        return mapper.toProductDtos(repository.findAll());
    }

    public ProductDto createProduct(Product product){
        Product savedProduct = repository.save(product);
        return mapper.toProductDto(savedProduct);
    }

    public ProductDto updateProduct(Product product, Long id){
        Product existProduct = getProductById(id);
        Product updatedProduct = new Product(existProduct.getId(), product.getName(), product.getDesc(), product.getPrice());
        return mapper.toProductDto(repository.save(updatedProduct));
    }

    public String deleteProductById(Long id){
        repository.delete(getProductById(id));
        return "product deleted id:"+id;
    }

    public Product getProductById(Long id){
        return repository.findById(id).orElseThrow(()->new ProductNotFoundException("product not found id"+id));
    }


}

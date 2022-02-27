package com.bootstrap.productservice.api;


import com.bootstrap.productservice.entity.Product;
import com.bootstrap.productservice.entity.dto.ProductDto;
import com.bootstrap.productservice.service.ProductService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(service.createProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody Product product, @PathVariable  Long id){
        return new ResponseEntity<>(service.updateProduct(product,id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String > deleteProductById(@PathVariable Long id){
        return new ResponseEntity<>(service.deleteProductById(id),HttpStatus.OK);
    }

}

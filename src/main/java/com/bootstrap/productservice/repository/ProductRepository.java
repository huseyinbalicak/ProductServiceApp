package com.bootstrap.productservice.repository;

import com.bootstrap.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

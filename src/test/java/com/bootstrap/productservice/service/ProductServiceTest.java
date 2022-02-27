package com.bootstrap.productservice.service;

import com.bootstrap.productservice.entity.Product;
import com.bootstrap.productservice.entity.dto.ProductDto;
import com.bootstrap.productservice.entity.mapper.Mapper;
import com.bootstrap.productservice.repository.ProductRepository;
import com.bootstrap.productservice.testSupport.TestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest extends TestSupport {

    private ProductRepository repository;
    private Mapper mapper;

    private ProductService service;

    @BeforeEach
    void setUp() {

        repository = mock(ProductRepository.class);
        mapper = mock(Mapper.class);

        service = new ProductService(repository,mapper);

    }

    @Test
    void testGetAllProducts_itShouldReturnListProductDto() {

        List<Product> products = generateProductList();
        List<ProductDto> productDtos = generateProductDtoList();

        when(repository.findAll()).thenReturn(products);
        when(mapper.toProductDtos(products)).thenReturn(productDtos);

        List<ProductDto> result = service.getAllProducts();
        assertEquals(result,productDtos);

        verify(repository).findAll();
        verify(mapper).toProductDtos(products);

    }

    @Test
    void testCreateProduct_whenCalledValidProduct_itShouldReturnProductEntity() {

        Product product = generateProduct();
        ProductDto productDto = generateProductDto();

        when(repository.save(product)).thenReturn(product);
        when(mapper.toProductDto(product)).thenReturn(productDto);

        ProductDto result = service.createProduct(product);

        assertEquals(result,productDto);

        verify(repository).save(product);
        verify(mapper).toProductDto(product);
    }

    @Test
    void testUpdateProduct_whenCalledValidRequest_itShouldReturnProductEntity() {

        Product product = generateProduct();
        ProductDto productDto = generateProductDto();

        when(repository.findById(anyLong())).thenReturn(Optional.of(product));
        when(repository.save(product)).thenReturn(product);
        when(mapper.toProductDto(product)).thenReturn(productDto);

        ProductDto result = service.updateProduct(product,anyLong());

        assertEquals(result,productDto);

        verify(repository).findById(anyLong());
        verify(repository).save(product);
        verify(mapper).toProductDto(product);

    }

    @Test
    void testDeleteProductById_whenProductIdExist_itShouldReturnString() {

        Product product = generateProduct();

        when(repository.findById(anyLong())).thenReturn(Optional.of(product));

        String result = service.deleteProductById(anyLong());

        assertEquals("product deleted id:0",result);

        verify(repository).findById(anyLong());


    }

    @Test
    void getProductById() {

        Product product = generateProduct();

        when(repository.findById(anyLong())).thenReturn(Optional.of(product));

        Product result = service.getProductById(anyLong());
        assertEquals(result,product);

        verify(repository).findById(anyLong());

    }
}
package com.example.shop;


import com.example.shop.domain.Product;
import com.example.shop.repository.ProductRepository;
import com.example.shop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProductServiceIntegrationTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void reserveProduct_Success() {
        // Arrange
        Long id = 1L;
        int quantity = 5;
        Product product = new Product();
        product.setId(id);
        product.setQuantity(quantity);

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.save(product)).thenReturn(product);

        // Act
        productService.reserveProduct(id, quantity);

        // Assert
        verify(productRepository).save(product);
        assertEquals(product.getQuantity(), quantity - 5);
    }

}

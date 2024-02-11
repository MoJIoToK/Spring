package com.example.shop.service;

import com.example.shop.domain.Product;
import com.example.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Класс ProductService. Сервис для работы с продуктами.
 *
 * @author Nick
 * @version 1.0
 */
@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    /**
     * Метод позволяет получить список всех продуктов.
     *
     * @return List список всех продуктов
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Метод позволяет получить продукт по идентификатору.
     *
     * @param id идентификатор продукта
     * @return Product найденный продукт
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    /**
     * Метод позволяет зарезервировать определенное количество продукта по идентификатору.
     *
     * @param id       идентификатор продукта
     * @param quantity количество для резервации
     */
    public void reserveProduct(Long id, int quantity) {
        Product product = getProductById(id);
        if (product.getQuantity() >= quantity) {
            product.setQuantity(product.getQuantity() - quantity);
            productRepository.save(product);
        } else {
            throw new RuntimeException("Not enough quantity");
        }
    }

    /**
     * Метод позволяет создать новый продукт.
     *
     * @param product новый продукт
     * @return Product созданный продукт
     */
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Метод позволяет обновить информацию о продукте.
     *
     * @param updatedProduct обновленная информация о продукте
     * @return Product обновленный продукт
     */
    public Product updateProduct(Product updatedProduct) {
        Long id = updatedProduct.getId();
        Product existingProduct = getProductById(id);
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setQuantity(updatedProduct.getQuantity());
        return productRepository.save(existingProduct);
    }

    /**
     * Метод позволяет удалить продукт по идентификатору.
     *
     * @param id идентификатор продукта для удаления
     */
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}


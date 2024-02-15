package com.example.shop.controller;

import com.example.shop.domain.Product;
import com.example.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Класс ProductController. Контроллер продуктов позволяет обрабатывать запросы, связанные с продуктами.
 *
 * @author Nick
 * @version 1.0
 */
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    /**
     * Метод получает список всех продуктов.
     *
     * @return List список всех продуктов
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    /**
     * Метод получает продукт по идентификатору.
     *
     * @param id идентификатор продукта
     * @return Product найденный продукт
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    /**
     * Метод позволяет зарезервировать продукт определенного количества по идентификатору.
     *
     * @param id       идентификатор продукта
     * @param quantity количество для резервации
     * @return статус ответа
     */
    @PostMapping("/{id}/reserve")
    public ResponseEntity<?> reserveProduct(@PathVariable Long id,
                                            @RequestParam int quantity) {
        try {
            productService.reserveProduct(id, quantity);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    /**
     * Метод позволяет создать новый продукт.
     *
     * @param product новый продукт
     * @return Product созданный продукт
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    /**
     * Метод позволяет обновить информацию о продукте.
     *
     * @param updatedProduct обновленная информация о продукте
     * @return Product обновленный продукт
     */
    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product updatedProduct) {
        return ResponseEntity.ok(productService.updateProduct(updatedProduct));
    }

    /**
     * Метод позволяет удалять продукт по идентификатору.
     *
     * @param id идентификатор продукта для удаления
     * @return статус ответа
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

}


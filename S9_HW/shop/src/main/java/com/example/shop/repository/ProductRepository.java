package com.example.shop.repository;

import com.example.shop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс ProductRepository. Позволяет использовать методы для работы с БД.
 *
 * @author Nick
 * @version 1.0
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

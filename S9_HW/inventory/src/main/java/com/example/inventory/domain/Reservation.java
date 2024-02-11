package com.example.inventory.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс Reservation. Класс представляет зарезервированный продукт.
 *
 * @author Nick
 * @version 1.0
 */
@Entity
@Table(name = "reservations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Идентификатор продукта.
     */
    @Column(name = "product_id", nullable = false)
    private Long productId;

    /**
     * Количество зарезервированных продуктов.
     */
    @Column(nullable = false)
    private int quantity;

    /**
     * Идентификатор платежа.
     */
    @Column(name = "payment_id")
    private Long paymentId;

}


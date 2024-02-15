package com.example.payment.repository;

import com.example.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс PaymentRepository. Интерфейс содержит методы для работы с оплатой товаров.
 *
 * @author Nick
 * @version 1.0
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

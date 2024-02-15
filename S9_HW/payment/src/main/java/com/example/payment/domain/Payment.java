package com.example.payment.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Класс Payment. Класс представляет собой платёж.
 *
 * @author Nick
 * @version 1.0
 */
@Entity
@Table(name = "payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Идентификатор учетной записи, от кого поступил платеж.
     */
    @Column(name = "account_id", nullable = false)
    private Long accountId;

    /**
     * Сумма платежа.
     */
    @Column(nullable = false)
    private BigDecimal amount;

    /**
     * Идентификатор зарезервированной покупки, по которой идет платеж.
     */
    @Column(name = "reservation_id")
    private Long reservationId;
}

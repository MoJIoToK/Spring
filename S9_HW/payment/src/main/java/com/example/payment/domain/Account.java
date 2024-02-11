package com.example.payment.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


/**
 * Класс Account. Класс представляет тип учётной записи счета.
 *
 * @author Nick
 * @version 1.0
 */
@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private BigDecimal balance;
}







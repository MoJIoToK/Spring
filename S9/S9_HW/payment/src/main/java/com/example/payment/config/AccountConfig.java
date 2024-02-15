package com.example.payment.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Класс AccountConfig. Конфигурация учетных записей.
 *
 * @author Nick
 * @version 1.0
 */
@Configuration
@Data
public class AccountConfig {
    /**
     * Идентификатор счета получателя по умолчанию для shop.
     */
    @Value("${toAccount.id}")
    private String toAccountId;

}



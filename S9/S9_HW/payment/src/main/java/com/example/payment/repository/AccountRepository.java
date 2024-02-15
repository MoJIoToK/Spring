package com.example.payment.repository;

import com.example.payment.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс AccountRepository. Интерфейс содержит методы для работы с учетными записями.
 *
 * @author Nick
 * @version 1.0
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}

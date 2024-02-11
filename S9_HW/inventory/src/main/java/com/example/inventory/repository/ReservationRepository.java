package com.example.inventory.repository;

import com.example.inventory.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Интерфейс ReservationRepository. Интерфейс содержит методы для работы с БД.
 *
 * @author Nick
 * @version 1.0
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByProductId(Long productId);
}

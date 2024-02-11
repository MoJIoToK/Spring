package com.example.inventory.controller;

import com.example.inventory.domain.Reservation;
import com.example.inventory.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Класс ReservationController. Контроллер для обработки запросов, связанных с резервированием продуктов.
 *
 * @author Nick
 * @version 1.0
 */
@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    /**
     * Метод получает список всех резервов.
     *
     * @return List список всех резервов
     */
    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }

    /**
     * Метод получает список резервов для определенного продукта.
     *
     * @param productId идентификатор продукта
     * @return List список резервов для данного продукта
     */
    @GetMapping("/products/{productId}")
    public ResponseEntity<List<Reservation>> getReservationsByProductId(@PathVariable Long productId) {
        return ResponseEntity.ok(reservationService.getReservationsByProductId(productId));
    }

    /**
     * Метод резервирует продукт.
     *
     * @param productId идентификатор продукта
     * @param quantity  количество продукта для резерва
     * @return созданный резерв
     */
    @PostMapping("/products/{productId}")
    public ResponseEntity<?> createReservation(@PathVariable Long productId,
                                               @RequestParam int quantity) {
        try {
            Reservation reservation = reservationService.createReservation(productId, quantity);
            return ResponseEntity.ok(reservation);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    /**
     * Метод обновляет идентификатор платежа для резерва.
     *
     * @param reservationId идентификатор резерва
     * @param paymentId     идентификатор платежа
     * @return статус ответа
     */
    @PutMapping("/{reservationId}/payment/{paymentId}")
    public ResponseEntity<Void> updatePaymentId(@PathVariable Long reservationId,
                                                @PathVariable Long paymentId) {
        reservationService.updateReservationPaymentId(reservationId, paymentId);
        return ResponseEntity.ok().build();
    }

}

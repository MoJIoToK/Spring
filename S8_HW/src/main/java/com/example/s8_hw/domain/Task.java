package com.example.s8_hw.domain;

/**
 * Класс Task задач со свойствами id, description, status, timeSet.
 *
 * @author Nick
 * @version 1.0
 */

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
public class Task {

    /**
     * id - идентификационный номер задачи.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * description - описание задачи.
     */
    @Column(nullable = false)
    private String description;

    /**
     * status - статус задачи.
     *
     * @see TaskStatus
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    /**
     * timeSet - время начала задачи.
     */
    @Column(nullable = false)
    private LocalDateTime timeSet;

}

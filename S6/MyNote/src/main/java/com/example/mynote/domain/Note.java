package com.example.mynote.domain;

/**
 * Класс Note со свойствами id, title, desription, dateTime.
 *
 * @author Nick
 * @version 1.0
 */

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "notes")
@Data
public class Note {

    /**
     * id - идентификационный номер заметки.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * title - название заметки.
     */
    @Column(nullable = false)
    private String title;

    /**
     * description - описание заметки.
     */
    @Column(nullable = false)
    private String desription;

    /**
     * dateTime - дата создания/обновления заметки.
     */
    private LocalDateTime dateTime;

}


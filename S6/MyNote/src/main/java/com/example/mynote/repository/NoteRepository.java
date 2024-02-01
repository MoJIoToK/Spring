package com.example.mynote.repository;

/**
 * Интерфейс NoteRepository репозиторий заметок.
 *
 * @author Nick
 * @version 1.0
 */

import com.example.mynote.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    /**
     * Кастомная функция, с помощью которой Spring Data составит запрос к БД для поиска данных по id.
     *
     * @param id
     * @return Note
     */
    Optional<Note> findById(Long id);
}

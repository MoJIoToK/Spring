package com.example.mynote.service;

/**
 * Класс TaskServiceImpl сервис для работы с задачами.
 *
 * @author Nick
 * @version 1.0
 */

import com.example.mynote.domain.Note;
import com.example.mynote.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService {

    /**
     * Репозиторий для хранения данных о заметках.
     */
    private final NoteRepository repository;

    /**
     * Возвращает список всех заметок.
     *
     * @return List
     * @see NoteRepository#findAll
     */
    public List<Note> findAll() {
        return repository.findAll();
    }

    /**
     * Сохранение заметки в БД и её возврат.
     *
     * @param note
     * @return Note
     * @see NoteRepository#save
     */
    public Note save(Note note) {
        return repository.save(note);
    }

    /**
     * Возвращает заметку по id.
     *
     * @param id
     * @return Note
     * @see NoteRepository#findById
     */
    public Optional<Note> findById(Long id) {
        return repository.findById(id);
    }

    /**
     * Удаляет заметку по id.
     *
     * @param id
     * @see NoteRepository#deleteById
     */
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}

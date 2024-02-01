package com.example.mynote.controller;

/**
 * Класс NoteController контроллер заметок.
 *
 * @author Nick
 * @version 1.0
 */

import com.example.mynote.domain.Note;
import com.example.mynote.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {

    /**
     * Сервис для работы с заметками.
     */
    private final NoteService service;

    /**
     * Метод возвращает список всех заметок.
     *
     * @return List
     * @see NoteService#findAll
     */
    @GetMapping
    public ResponseEntity<List<Note>> getAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    /**
     * Метод возвращает заметку по id.
     *
     * @param id
     * @return Note
     * @see NoteService#findById
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Note>> getById(@PathVariable Long id) {
        Optional<Note> noteById;
        try {
            noteById = service.findById(id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Optional.of(new Note()));
        }
        return new ResponseEntity<>(noteById, HttpStatus.OK);
    }

    /**
     * Метод позволяет сохранить в БД заметку.
     *
     * @param note
     * @return Note
     * @see NoteService#save
     */
    @PostMapping
    public ResponseEntity<Note> save(@RequestBody Note note) {
        note.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(service.save(note), HttpStatus.CREATED);
    }

    /**
     * Метод обновляет заметку. Обновление происходит путем перезаписи
     * заметки с id соответствующим входному id.
     *
     * @param note
     * @param id
     * @return Note
     * @see NoteService#save
     */
    @PutMapping("/{id}")
    public ResponseEntity<Note> update(@RequestBody Note note, @PathVariable Long id) {
        note.setId(id);
        note.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(service.save(note), HttpStatus.OK);
    }

    /**
     * Метод позволяет удалить заметку по id.
     *
     * @param id
     * @see NoteService#deleteById
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}

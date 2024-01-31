package com.example.mynote.controller;

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
    private final NoteService service;

    @GetMapping
    public ResponseEntity<List<Note>> getAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Note>> getById(@PathVariable Long id){
        Optional<Note> noteById;
        try {
            noteById = service.findById(id);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Optional.of(new Note()));
        }
        return new ResponseEntity<>(noteById, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Note> save(@RequestBody Note note){
        note.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(service.save(note), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> update(@RequestBody Note note, @PathVariable Long id){
        note.setId(id);
        note.setDateTime(LocalDateTime.now());
        return new ResponseEntity<>(service.save(note), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
/**
 * 1. Добавление заметки. (Подсказка @PostMapping )
 * 2. Просмотр всех заметок.(Подсказка @GetMapping )
 * 3. Получение заметки по id. (Подсказка @GetMapping("/{id}") )
 * 4. Редактирование заметки.(Подсказка @PutMapping("/{id}") )
 * 5. Удаление заметки.(Подсказка @DeleteMapping("/{id}") )
 */
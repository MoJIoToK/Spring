package com.example.mynote.service;

import com.example.mynote.domain.Note;
import com.example.mynote.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository repository;

    public List<Note> findAll(){
        return repository.findAll();
    }

    public Note save(Note note){
        return repository.save(note);
    }

    public Optional<Note> findById(Long id){
        return repository.findById(id);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

}

/**
 * 1. Добавление заметки. (Подсказка @PostMapping )
 * 2. Просмотр всех заметок.(Подсказка @GetMapping )
 * 3. Получение заметки по id. (Подсказка @GetMapping("/{id}") )
 * 4. Редактирование заметки.(Подсказка @PutMapping("/{id}") )
 * 5. Удаление заметки.(Подсказка @DeleteMapping("/{id}") )
 */

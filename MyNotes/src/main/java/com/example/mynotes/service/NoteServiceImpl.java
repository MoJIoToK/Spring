package com.example.mynotes.service;

import com.example.mynotes.domain.Note;
import com.example.mynotes.domain.NoteEntity;
import com.example.mynotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{

    private final NoteRepository repository;

    @Autowired
    public NoteServiceImpl(NoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<NoteEntity> getAllNotes() {
        return repository.findAll();
    }

    @Override
    public NoteEntity getNoteById(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Note not found!"));
    }

    @Override
    public NoteEntity createNote(NoteEntity note) {
        return repository.save(note);
    }

    @Override
    public NoteEntity updateNote(Long id, NoteEntity note) {
        NoteEntity existNote = getNoteById(id);
        existNote.setTitle(note.getTitle());
        existNote.setContent(note.getContent());
        return repository.save(existNote);
    }

    @Override
    public void deleteNote(Long id) {
        getNoteById(id);
        repository.deleteById(id);
    }
}

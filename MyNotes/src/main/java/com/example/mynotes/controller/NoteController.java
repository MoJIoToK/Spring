package com.example.mynotes.controller;

import com.example.mynotes.domain.NoteEntity;
import com.example.mynotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<NoteEntity> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/{id}")
    public NoteEntity getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id);
    }
    @PostMapping
    public NoteEntity createNote(@RequestBody NoteEntity note) {
        return noteService.createNote(note);
    }
    @PutMapping("/{id}")
    public NoteEntity updateNote(@PathVariable Long id, @RequestBody NoteEntity note) {
        return noteService.updateNote(id, note);
    }
    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }


}

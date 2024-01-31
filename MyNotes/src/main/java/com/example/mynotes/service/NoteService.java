package com.example.mynotes.service;

import com.example.mynotes.domain.Note;
import com.example.mynotes.domain.NoteEntity;

import java.util.List;

public interface NoteService {
    List<NoteEntity> getAllNotes();
    NoteEntity getNoteById(Long id);
    NoteEntity createNote(NoteEntity note);
    NoteEntity updateNote(Long id, NoteEntity note);
    void deleteNote(Long id);
}

package com.example.mynotes.repository;

import com.example.mynotes.domain.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<NoteEntity, Long> {
    List<NoteEntity> findByAuthor(String author);
}

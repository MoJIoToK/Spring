package com.example.books_store.service;

import com.example.books_store.domain.Book;
import com.example.books_store.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id){
        return bookRepository.findById(id);
    }

    public Book save(Book book){
        return bookRepository.save(book);
    }

    public void delete(Long id){
        bookRepository.deleteById(id);
    }

}

package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository repository;

    // Constructor Injection
    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    // Setter Injection
    @Autowired
    public void setRepository(BookRepository repository) {
        this.repository = repository;
    }

    public void service() {

        System.out.println("Book Service Started...");

        repository.display();

    }
}
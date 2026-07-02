package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public void service(){

        System.out.println("Book Service Started...");

        repository.display();

    }

}
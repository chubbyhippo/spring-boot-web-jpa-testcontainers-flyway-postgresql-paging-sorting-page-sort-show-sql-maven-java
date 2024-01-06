package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface BookRepository{
    Page<Book> findAll(PageRequest pageRequest);
    void save(Book book);
}

package com.example.demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface BookRepository {
    Page<Book> findAll(PageRequest pageRequest);

    void save(Book book);
}

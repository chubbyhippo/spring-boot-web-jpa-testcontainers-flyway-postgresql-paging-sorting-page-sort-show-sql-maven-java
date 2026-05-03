package com.example.demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface BookRepository {
    Page<Book> findAll(PageRequest pageRequest);

    void saveAll(List<Book> book);
}

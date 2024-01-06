package com.example.demo.application;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Page<Book> getBooks(int page, int size) {
        return bookRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "title")));
    }

}

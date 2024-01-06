package com.example.demo.presentation;

import com.example.demo.application.BookDto;
import com.example.demo.domain.Book;
import com.example.demo.application.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/books")
    public Page<BookDto> getBooks(@RequestParam int page, @RequestParam int size) {
        return bookService.getBooks(page, size);
    }
}

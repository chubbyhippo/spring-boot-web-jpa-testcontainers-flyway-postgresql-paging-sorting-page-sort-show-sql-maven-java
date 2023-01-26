package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import com.github.javafaker.Faker;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void shouldGetPageOfBook() {
        var faker = new Faker();
        var books = List.of(new Book(1L,
                faker.number().digits(13),
                faker.name().title(),
                faker.name().fullName(),
                faker.number().randomDouble(2, 9, 999),
                faker.name().name()));

        var bookPage = new PageImpl<>(books);
        Mockito.when(bookRepository.findAll(Mockito.any(PageRequest.class))).thenReturn(bookPage);

        var result = bookService.getBooks(1, 1);
        Assertions.assertThat(result).isNotNull();


    }
}
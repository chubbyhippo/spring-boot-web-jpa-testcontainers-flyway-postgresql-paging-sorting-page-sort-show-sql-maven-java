package com.example.demo.application;

import com.example.demo.application.BookService;
import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

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
        when(bookRepository.findAll(any(PageRequest.class))).thenReturn(bookPage);

        var result = bookService.getBooks(1, 1);
        assertThat(result).isNotNull();


    }
}
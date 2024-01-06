package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.application.BookService;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

@WebMvcTest
class BookControllerTest {

    @Autowired
    private WebTestClient webTestClient;
    @MockBean
    private BookService bookService;

    @Test
    void shouldGetBooks() {
        var faker = new Faker();
        var books = List.of(new Book(1L,
                faker.number().digits(13),
                faker.name().title(),
                faker.name().fullName(),
                faker.number().randomDouble(2, 9, 999),
                faker.name().name()));

        var bookPage = new PageImpl<>(books);
        when(bookService.getBooks(anyInt(), anyInt())).thenReturn(bookPage);
        webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/api/books")
                        .queryParam("page", 1)
                        .queryParam("size", 2)
                        .build())
                .exchange()
                .expectBody()
                .jsonPath("$.numberOfElements").isEqualTo(1)
                .jsonPath("$.totalElements").isEqualTo(1);
    }
}
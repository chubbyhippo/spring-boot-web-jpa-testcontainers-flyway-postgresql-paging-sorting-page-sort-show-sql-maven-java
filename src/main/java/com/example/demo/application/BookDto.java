package com.example.demo.application;

import lombok.Builder;

@Builder
public record BookDto(
        Long id,
        String isbn,
        String title,
        String author,
        Double price,
        String publisher
) {
}

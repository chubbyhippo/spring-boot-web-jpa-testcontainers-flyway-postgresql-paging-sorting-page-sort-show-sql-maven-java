package com.example.demo.config;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class BookDataLoader implements CommandLineRunner {

    private final BookRepository bookRepository;

    @Override
    public void run(String... args) {
        var faker = new Faker();
        Stream.of(1000L).forEach(id ->
                bookRepository.save(new Book(id,
                        faker.number().digits(13),
                        faker.name().title(),
                        faker.name().fullName(),
                        faker.number().randomDouble(2, 9, 999),
                        faker.name().name()))
        );


    }
}

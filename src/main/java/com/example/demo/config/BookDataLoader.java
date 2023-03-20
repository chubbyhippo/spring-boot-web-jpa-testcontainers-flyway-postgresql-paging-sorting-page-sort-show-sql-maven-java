package com.example.demo.config;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class BookDataLoader {

    private final BookRepository bookRepository;

    @Bean
    public CommandLineRunner loadBookData() {
        return args -> {
            var faker = new Faker();
            Stream.of(1000L).map(id -> new Book(id,
                    faker.number().digits(13),
                    faker.name().title(),
                    faker.name().fullName(),
                    faker.number().randomDouble(2, 9, 999),
                    faker.name().name())).forEach(bookRepository::save);
        };
    }

}

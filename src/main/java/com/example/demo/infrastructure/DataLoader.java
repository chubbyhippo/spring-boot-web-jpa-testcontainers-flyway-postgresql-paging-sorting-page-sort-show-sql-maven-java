package com.example.demo.infrastructure;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.stream.LongStream;

@Component
@RequiredArgsConstructor
@Profile("dev")
public class DataLoader {

    private final BookRepository bookRepository;

    @PostConstruct
    public CommandLineRunner loadBookData() {
        return args -> {
            var faker = new Faker();
            LongStream.rangeClosed(1L, 100L)
                    .boxed()
                    .map(id -> new Book(id,
                            faker.number().digits(13),
                            faker.name().title(),
                            faker.name().fullName(),
                            faker.number().randomDouble(2, 9, 999),
                            faker.name().name()))
                    .forEach(bookRepository::save);
        };
    }
}

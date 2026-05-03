package com.example.demo.infrastructure;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.stream.LongStream;

@Component
@RequiredArgsConstructor
@Profile("dev")
@Slf4j
public class DataLoader implements ApplicationRunner {

    private final BookRepository bookRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        log.info("Loading Book Data...");
        var faker = new Faker();
        var booksToBeSaved = LongStream.rangeClosed(1L, 100L)
                .boxed()
                .map(id -> new Book(null,
                        faker.number().digits(13),
                        faker.name().title(),
                        faker.name().fullName(),
                        faker.number().randomDouble(2, 9, 999),
                        faker.name().name()))
                .toList();
        bookRepository.saveAll(booksToBeSaved);
        log.info("Book Data successfully loaded");
    }
}

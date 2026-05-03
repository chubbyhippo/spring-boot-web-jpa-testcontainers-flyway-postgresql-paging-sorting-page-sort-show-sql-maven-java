package com.example.demo.infrastructure;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final BookJpaRepository bookJpaRepository;

    @Override
    public Page<Book> findAll(PageRequest pageRequest) {
        return bookJpaRepository.findAll(pageRequest);
    }

    @Override
    public void saveAll(List<Book> book) {
        bookJpaRepository.saveAll(book);
    }

}

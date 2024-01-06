package com.example.demo.infrastructure;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    private final BookJpaRepository bookJpaRepository;

    @Override
    public Page<Book> findAll(PageRequest pageRequest) {
        return bookJpaRepository.findAll(pageRequest);
    }

    @Override
    public void save(Book book) {
        bookJpaRepository.save(book);
    }

}

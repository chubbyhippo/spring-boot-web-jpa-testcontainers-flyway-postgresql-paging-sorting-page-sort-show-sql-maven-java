package com.example.demo.infrastructure;

import com.example.demo.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<Book, Long> {
}

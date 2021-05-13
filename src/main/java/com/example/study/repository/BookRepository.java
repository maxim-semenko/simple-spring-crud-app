package com.example.study.repository;

import com.example.study.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Book repository.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}

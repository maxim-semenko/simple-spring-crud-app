package com.example.study.service;

import com.example.study.entity.Book;
import com.example.study.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Book service.
 */
@Service
public class BookService {

    private final BookRepository bookRepository;

    /**
     * Instantiates a new Book service.
     *
     * @param bookRepository the book repository
     */
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Find by id book.
     *
     * @param id the id
     * @return the book
     */
    public Book findById(Long id) {
        return bookRepository.getOne(id);
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    /**
     * Save.
     *
     * @param book the book
     */
    public void save(Book book) {
        bookRepository.save(book);
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

}

package com.example.study.controller;

import com.example.study.entity.Book;
import com.example.study.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The type Book controller.
 */
@Controller
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Main string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/bookList")
    public String main(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "bookList";
    }

    /**
     * Add book string.
     *
     * @param author the author
     * @param name   the name
     * @param pages  the pages
     * @param model  the model
     * @return the string
     */
    @PostMapping("/bookList")
    public String addBook(@RequestParam String author,
                          @RequestParam String name,
                          @RequestParam Integer pages,
                          Model model) {
        bookService.save(Book.builder().author(author).name(name).pages(pages).build());
        model.addAttribute("books", bookService.findAll());
        return "bookList";
    }

    /**
     * Delete book string.
     *
     * @param id the id
     * @return the string
     */
    @GetMapping("book-delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return "redirect:/bookList";
    }

    /**
     * Update book page string.
     *
     * @param id    the id
     * @param model the model
     * @return the string
     */
    @GetMapping("book-update/{id}")
    public String updateBookPage(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "/book-update";
    }

    /**
     * Update book string.
     *
     * @param book the book
     * @return the string
     */
    @PostMapping("/book-update")
    public String updateBook(Book book) {
        bookService.save(book);
        return "redirect:/bookList";
    }

}
package com.example.study.controller;

import com.example.study.entity.Book;
import com.example.study.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The type Book controller.
 */
@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

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
    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "bookList";
    }

    @GetMapping("/add")
    private String addBookPage(Model model) {
        model.addAttribute("book", new Book());
        return "book-add";
    }

    /**
     * Add book string.
     *
     * @return {@link String} page
     */
    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/books/main";
    }

    /**
     * Update book page string.
     *
     * @param id    the id
     * @param model the model
     * @return {@link String} page
     */
    @GetMapping("book-update/{id}")
    public String updateBookPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "/book-update";
    }

    /**
     * Update book string.
     *
     * @param book the book
     * @return {@link String} page
     */
    @PostMapping("/book-update")
    public String updateBook(Book book) {
        bookService.save(book);
        return "redirect:/books/main";
    }

    /**
     * Delete book string.
     *
     * @param id the id
     * @return {@link String} page
     */
    @GetMapping("book-delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return "redirect:/books/main";
    }

}
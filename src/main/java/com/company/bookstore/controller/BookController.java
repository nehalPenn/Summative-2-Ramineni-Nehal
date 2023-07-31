package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.AuthorRepository;
import com.company.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository repo;

    //A POST route that creates a new book.
    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return repo.save(book);
    }

    //A PUT route that updates an existing book.
    @PutMapping("/book")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBook(@RequestBody Book book) {
        repo.save(book);
    }

    //A DELETE route that deletes an existing book.
    @DeleteMapping("/book/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable int id) {
        repo.deleteById(id);
    }

    //READ ALL
    @GetMapping("/book")
    public List<Book> getBook() {
        return repo.findAll();
    }

    //A GET route that returns a specific book by id.
    @GetMapping("/book/{id}")
    public Book getAuthorById(@PathVariable int id) {
        Optional<Book> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

}

package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import com.company.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {

    @Autowired
    AuthorRepository repo;

    //A POST route that creates a new author.
    @PostMapping("/author")
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody Author author) {
        return repo.save(author);
    }

    //A PUT route that updates an existing author.
    @PutMapping("/author")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAuthor(@RequestBody Author author) {
        repo.save(author);
    }

    //A DELETE route that deletes an existing author.
    @DeleteMapping("/author/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable int id) {
        repo.deleteById(id);
    }

    //READ ALL
    @GetMapping("/author")
    public List<Author> getAuthor() {
        return repo.findAll();
    }

    //A GET route that returns a specific author by id.
    @GetMapping("/author/{id}")
    public Author getAuthorById(@PathVariable int id) {
        Optional<Author> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }
}

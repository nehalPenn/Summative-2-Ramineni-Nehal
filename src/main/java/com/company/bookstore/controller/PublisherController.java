package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.BookRepository;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {

    @Autowired
    PublisherRepository repo;

    //A POST route that creates a new publisher.
    @PostMapping("/publisher")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        return repo.save(publisher);
    }

    //A PUT route that updates an existing publisher.
    @PutMapping("/publisher")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePublisher(@RequestBody Publisher publisher) {
        repo.save(publisher);
    }

    //A DELETE route that deletes an existing publisher.
    @DeleteMapping("/publisher/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable int id) {
        repo.deleteById(id);
    }

    //READ ALL
    @GetMapping("/publisher")
    public List<Publisher> getPublisher() {
        return repo.findAll();
    }

    //A GET route that returns a specific author by id.
    @GetMapping("/publisher/{id}")
    public Publisher getAuthorById(@PathVariable int id) {
        Optional<Publisher> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }
}

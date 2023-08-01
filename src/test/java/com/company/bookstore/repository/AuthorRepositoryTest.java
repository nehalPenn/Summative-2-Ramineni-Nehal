package com.company.bookstore.repository;

import com.company.bookstore.model.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;

    @BeforeEach
    public void setUp() throws Exception {
        authorRepository.deleteAll();
    }

    //CREATE
    @Test
    public void shouldCreateAuthor(){
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Bobby");
        author.setStreet("123 Lincoln");
        author.setCity("Philly");
        author.setState("Pennsylvania");

        //Act...
        author = authorRepository.save(author);

        Optional<Author> author1 = authorRepository.findById(author.getId());

        assertEquals(author1.get(), author);

    }

    //Update an existing author record
    @Test
    public void shouldUpdateAuthor() {
        //Arrange...
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Bobby");
        author.setStreet("123 Lincoln");
        author.setCity("Philly");
        author.setState("Pennsylvania");

        //Act...
        author = authorRepository.save(author);

        author.setFirstName("Jameson");

        authorRepository.save(author);

        //Act...
        Optional<Author> author1 = authorRepository.findById(author.getId());

        //Assert...
        assertEquals(author1.get(), author);
    }

    //Delete an existing author record.
    @Test
    public void shouldDeleteAuthorById() {

        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Bobby");
        author.setStreet("123 Lincoln");
        author.setCity("Philly");
        author.setState("Pennsylvania");

        //Act...
        author = authorRepository.save(author);

        Optional<Author> author1 = authorRepository.findById(author.getId());

        assertEquals(author1.get(), author);

        //Act...
        authorRepository.deleteById(author.getId());

        author1 = authorRepository.findById(author.getId());

        //Assert...
        assertFalse(author1.isPresent());
    }

    //Find author record by id.
    @Test
    public void shouldGetAuthorById() {

        //Arrange...
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Bobby");
        author.setStreet("123 Lincoln");
        author.setCity("Philly");
        author.setState("Pennsylvania");

        //Act...
        author = authorRepository.save(author);

        Optional<Author> foundAuthor = authorRepository.findById(author.getId());

        //Assert...
        assertEquals(foundAuthor.get(), author);
    }

    //READ ALL
    @Test
    public void shouldGetAll() {

        //Arrange...
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Bobby");
        author.setStreet("123 Lincoln");
        author.setCity("Philly");
        author.setState("Pennsylvania");

        //Act...
        author = authorRepository.save(author);

        //Arrange...
        author = new Author();
        author.setFirstName("John");
        author.setLastName("Jermey");
        author.setStreet("123 Lincoln");
        author.setCity("Philly");
        author.setState("Pennsylvania");
        //Act...
        author = authorRepository.save(author);

        //Act...
        List<Author> lList = authorRepository.findAll();

        //Assert...
        assertEquals(lList.size(), 2);
    }
}
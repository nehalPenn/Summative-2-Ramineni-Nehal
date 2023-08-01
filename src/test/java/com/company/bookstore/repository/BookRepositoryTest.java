package com.company.bookstore.repository;

import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    AuthorRepository authorRepository;

    @BeforeEach
    public void setUp() throws Exception {
        bookRepository.deleteAll();
        publisherRepository.deleteAll();
        authorRepository.deleteAll();
    }

    //Create a new book record
    @Test
    public void shouldAddBook() {

        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Bobby");
        author.setStreet("123 Lincoln");
        author.setCity("Philly");
        author.setState("Pennsylvania");

        Publisher publisher = new Publisher();
        publisher.setName("Penguin Publishing");
        publisher.setStreet("123 Lincoln");
        publisher.setCity("Philly");
        publisher.setState("Pennsylvania");
        publisher.setPostalCode("12431");
        publisher.setPhone("1230-332-4499");
        publisher.setEmail("donny@gmail.com");

        publisher = publisherRepository.save(publisher);
        author = authorRepository.save(author);

        LocalDate date = LocalDate.now();

        Book book = new Book();
        book.setIsbn("123");
        book.setTitle("Arthur");
        book.setPrice(12);
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());
        book.setPublishDate(LocalDate.of(2010,1,5));

        //Act...
        book = bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getId());

        assertEquals(book1.get(), book);
    }

    @Test
    public void shouldUpdateBook(){
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Bobby");
        author.setStreet("123 Lincoln");
        author.setCity("Philly");
        author.setState("Pennsylvania");

        Publisher publisher = new Publisher();
        publisher.setName("Penguin Publishing");
        publisher.setStreet("123 Lincoln");
        publisher.setCity("Philly");
        publisher.setState("Pennsylvania");
        publisher.setPostalCode("12431");
        publisher.setPhone("1230-332-4499");
        publisher.setEmail("donny@gmail.com");

        publisher = publisherRepository.save(publisher);
        author = authorRepository.save(author);

        LocalDate date = LocalDate.now();

        Book book = new Book();
        book.setIsbn("123");
        book.setTitle("Arthur");
        book.setPrice(12);
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());
        book.setPublishDate(LocalDate.of(2010,1,5));

        //Act...
        book = bookRepository.save(book);

        book.setTitle("Baxter");

        book = bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getId());

        assertEquals(book1.get(), book);

    }

    //Delete an existing book record.
    @Test
    public void shouldDeleteBookById() {

        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Bobby");
        author.setStreet("123 Lincoln");
        author.setCity("Philly");
        author.setState("Pennsylvania");

        Publisher publisher = new Publisher();
        publisher.setName("Penguin Publishing");
        publisher.setStreet("123 Lincoln");
        publisher.setCity("Philly");
        publisher.setState("Pennsylvania");
        publisher.setPostalCode("12431");
        publisher.setPhone("1230-332-4499");
        publisher.setEmail("donny@gmail.com");

        publisher = publisherRepository.save(publisher);
        author = authorRepository.save(author);

        LocalDate date = LocalDate.now();

        Book book = new Book();
        book.setIsbn("123");
        book.setTitle("Arthur");
        book.setPrice(12);
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());
        book.setPublishDate(LocalDate.of(2010,1,5));

        //Act...
        book = bookRepository.save(book);

        Optional<Book> book1 = bookRepository.findById(book.getId());

        assertEquals(book1.get(), book);

        //Act...
        bookRepository.deleteById(book.getId());

        book1 = bookRepository.findById(book.getId());

        //Assert...
        assertFalse(book1.isPresent());
    }

    //Find book record by id.
    @Test
    public void shouldGetBookById() {

        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Bobby");
        author.setStreet("123 Lincoln");
        author.setCity("Philly");
        author.setState("Pennsylvania");

        Publisher publisher = new Publisher();
        publisher.setName("Penguin Publishing");
        publisher.setStreet("123 Lincoln");
        publisher.setCity("Philly");
        publisher.setState("Pennsylvania");
        publisher.setPostalCode("12431");
        publisher.setPhone("1230-332-4499");
        publisher.setEmail("donny@gmail.com");

        publisher = publisherRepository.save(publisher);
        author = authorRepository.save(author);

        LocalDate date = LocalDate.now();

        Book book = new Book();
        book.setIsbn("123");
        book.setTitle("Arthur");
        book.setPrice(12);
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());
        book.setPublishDate(LocalDate.of(2010,1,5));

        //Act...
        book = bookRepository.save(book);

        Optional<Book> foundBook = bookRepository.findById(book.getId());

        //Assert...
        assertEquals(foundBook.get(), book);
    }

    //READ ALL
    @Test
    public void shouldGetAll() {

        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Bobby");
        author.setStreet("123 Lincoln");
        author.setCity("Philly");
        author.setState("Pennsylvania");

        Publisher publisher = new Publisher();
        publisher.setName("Penguin Publishing");
        publisher.setStreet("123 Lincoln");
        publisher.setCity("Philly");
        publisher.setState("Pennsylvania");
        publisher.setPostalCode("12431");
        publisher.setPhone("1230-332-4499");
        publisher.setEmail("donny@gmail.com");

        publisher = publisherRepository.save(publisher);
        author = authorRepository.save(author);

        LocalDate date = LocalDate.now();

        Book book = new Book();
        book.setIsbn("123");
        book.setTitle("Arthur");
        book.setPrice(12);
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());
        book.setPublishDate(LocalDate.of(2010,1,5));

        //Act...
        book = bookRepository.save(book);

        author = new Author();
        author.setFirstName("John");
        author.setLastName("Bobby");
        author.setStreet("123 Lincoln");
        author.setCity("Philly");
        author.setState("Pennsylvania");

        publisher = new Publisher();
        publisher.setName("Penguin Publishing");
        publisher.setStreet("123 Lincoln");
        publisher.setCity("Philly");
        publisher.setState("Pennsylvania");
        publisher.setPostalCode("12431");
        publisher.setPhone("1230-332-4499");
        publisher.setEmail("donny@gmail.com");

        publisher = publisherRepository.save(publisher);
        author = authorRepository.save(author);


        book = new Book();
        book.setIsbn("123");
        book.setTitle("Arthur");
        book.setPrice(12);
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());
        book.setPublishDate(LocalDate.of(2010,1,5));

        //Act...
        book = bookRepository.save(book);

        //Act...
        List<Book> lList = bookRepository.findAll();

        //Assert...
        assertEquals(lList.size(), 2);
    }

    @Test
    public void shouldGetBookByAuthorID() {

        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Bobby");
        author.setStreet("123 Lincoln");
        author.setCity("Philly");
        author.setState("Pennsylvania");

        Publisher publisher = new Publisher();
        publisher.setName("Penguin Publishing");
        publisher.setStreet("123 Lincoln");
        publisher.setCity("Philly");
        publisher.setState("Pennsylvania");
        publisher.setPostalCode("12431");
        publisher.setPhone("1230-332-4499");
        publisher.setEmail("donny@gmail.com");

        publisher = publisherRepository.save(publisher);
        author = authorRepository.save(author);

        LocalDate date = LocalDate.now();

        Book book = new Book();
        book.setIsbn("123");
        book.setTitle("Arthur");
        book.setPrice(12);
        book.setAuthorId(author.getId());
        book.setPublisherId(publisher.getId());
        book.setPublishDate(LocalDate.of(2010,1,5));

        //Act...
        book = bookRepository.save(book);

        //Assert...
        List<Book> aList = bookRepository.findByAuthorId(author.getId());

        assertEquals(aList.size(), 1);
    }

}
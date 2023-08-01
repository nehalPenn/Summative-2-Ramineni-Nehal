package com.company.bookstore.repository;

import com.company.bookstore.model.Author;
import com.company.bookstore.model.Publisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PublisherRepositoryTest {

    @Autowired
    PublisherRepository publisherRepository;

    @BeforeEach
    public void setUp() throws Exception {
        publisherRepository.deleteAll();
    }

    //Create a new publisher record
    @Test
    public void shouldAddPublisher() {

        Publisher publisher = new Publisher();
        publisher.setName("Penguin Publishing");
        publisher.setStreet("123 Lincoln");
        publisher.setCity("Philly");
        publisher.setState("Pennsylvania");
        publisher.setPostalCode("12431");
        publisher.setPhone("1230-332-4499");
        publisher.setEmail("donny@gmail.com");

        //Act...
        publisher = publisherRepository.save(publisher);

        Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getId());

        assertEquals(publisher1.get(), publisher);
    }

    //Update an existing publisher record
    @Test
    public void shouldUpdatePublisher() {

        Publisher publisher = new Publisher();
        publisher.setName("Penguin Publishing");
        publisher.setStreet("123 Lincoln");
        publisher.setCity("Philly");
        publisher.setState("Pennsylvania");
        publisher.setPostalCode("12431");
        publisher.setPhone("1230-332-4499");
        publisher.setEmail("donny@gmail.com");

        //Act...
        publisher = publisherRepository.save(publisher);

        publisher.setName("Jameson");

        publisherRepository.save(publisher);

        //Act...
        Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getId());

        //Assert...
        assertEquals(publisher1.get(), publisher);
    }

    //Delete an existing publisher record.
    @Test
    public void shouldDeletePublisherById() {

        Publisher publisher = new Publisher();
        publisher.setName("Penguin Publishing");
        publisher.setStreet("123 Lincoln");
        publisher.setCity("Philly");
        publisher.setState("Pennsylvania");
        publisher.setPostalCode("12431");
        publisher.setPhone("1230-332-4499");
        publisher.setEmail("donny@gmail.com");

        //Act...
        publisher = publisherRepository.save(publisher);

        Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getId());

        assertEquals(publisher1.get(), publisher);

        //Act...
        publisherRepository.deleteById(publisher.getId());

        publisher1 = publisherRepository.findById(publisher.getId());

        //Assert...
        assertFalse(publisher1.isPresent());
    }

    //Find publisher record by id.
    @Test
    public void shouldGetPublisherById() {

        Publisher publisher = new Publisher();
        publisher.setName("Penguin Publishing");
        publisher.setStreet("123 Lincoln");
        publisher.setCity("Philly");
        publisher.setState("Pennsylvania");
        publisher.setPostalCode("12431");
        publisher.setPhone("1230-332-4499");
        publisher.setEmail("donny@gmail.com");

        //Act...
        publisher = publisherRepository.save(publisher);

        Optional<Publisher> foundPublisher = publisherRepository.findById(publisher.getId());

        //Assert...
        assertEquals(foundPublisher.get(), publisher);
    }

    //READ ALL
    @Test
    public void shouldGetAll() {

        Publisher publisher = new Publisher();
        publisher.setName("Penguin Publishing");
        publisher.setStreet("123 Lincoln");
        publisher.setCity("Philly");
        publisher.setState("Pennsylvania");
        publisher.setPostalCode("12431");
        publisher.setPhone("1230-332-4499");
        publisher.setEmail("donny@gmail.com");

        //Act...
        publisher = publisherRepository.save(publisher);

        publisher = new Publisher();
        publisher.setName("Porcupine Publishing");
        publisher.setStreet("123 Lincoln");
        publisher.setCity("Philly");
        publisher.setState("Pennsylvania");
        publisher.setPostalCode("12431");
        publisher.setPhone("1230-332-4499");
        publisher.setEmail("donny@gmail.com");

        //Act...
        publisher = publisherRepository.save(publisher);

        //Act...
        List<Publisher> lList = publisherRepository.findAll();

        //Assert...
        assertEquals(lList.size(), 2);
    }


}
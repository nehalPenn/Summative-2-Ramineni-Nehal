package com.company.bookstore.controller;

import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.AuthorRepository;
import com.company.bookstore.repository.BookRepository;
import com.company.bookstore.repository.PublisherRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
class BookControllerTest {

    private ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;
    private List<Book> bookList;

    @MockBean
    private BookRepository bookRepository;

    @MockBean
    private AuthorRepository authorRepository;

    @MockBean
    private PublisherRepository publisherRepository;

    private LocalDate date;

    // Testing POST /books/
    @Test
    public void shouldReturnBook() throws Exception {


        Book book = new Book();
        book.setIsbn("3141593");
        book.setTitle("How to run");
        book.setPublishDate("LocalDate.of(2010,1,5)");
        book.setAuthorId(2);
        book.setPrice(12);

        String inputJson = mapper.writeValueAsString(book);

        Book book2 = new Book();
        book2.setIsbn("3141593");
        book2.setTitle("How to run");
        book2.setPublishDate("LocalDate.of(2010,1,5)");
        book2.setAuthorId(2);
        book2.setPrice(12);
        book2.setId(1);

        String outputJson = mapper.writeValueAsString(book2);

        mockMvc.perform(post("/books")
                        .content(inputJson).contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isCreated());
    }

    // Testing GET /books/{id}
    @Test
    public void shouldReturnBookbyId() throws Exception {

        Book book = new Book();
        book.setIsbn("3141593");
        book.setTitle("How to run");
        book.setPublishDate("LocalDate.of(2010,1,5)");
        book.setAuthorId(2);
        book.setPrice(12);
        book.setId(1);

        mockMvc.perform(get("/books/1"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    // Testing GET /books/
    @Test
    public void shouldReturnAllBooks() throws Exception {

        mockMvc.perform(get("/books")).andDo(print()).andExpect(status().isOk());

    }

    // Testing PUT /books
    @Test
    public void shouldUpdateBook() throws Exception {

        Book book = new Book();
        book.setIsbn("3141593");
        book.setTitle("How to run");
        book.setPublishDate("LocalDate.of(2010,1,5)");
        book.setAuthorId(2);
        book.setPrice(12);
        book.setId(1);

        String inputJson = mapper.writeValueAsString(book);

        mockMvc.perform(
                        put("/books")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());

    }

    // Testing DELETE /books/{id}
    @Test
    public void shouldDeleteBookById() throws Exception {
        mockMvc.perform(delete("/books/1")).andDo(print()).andExpect(status().isNoContent());

    }

    // Testing GET /books/author/{id}
    @Test
    public void getReturnBookByAuthorId() throws Exception {

        Book book = new Book();
        book.setIsbn("3141593");
        book.setTitle("How to run");
        book.setPublishDate("LocalDate.of(2010,1,5)");
        book.setAuthorId(2);
        book.setPrice(12);
        book.setId(1);

        mockMvc.perform(get("/books/author/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
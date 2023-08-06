package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
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

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {
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

    @Test
    public void shouldReturnAuthor() throws Exception {

        Author author = new Author();
        author.setFirstName("mordi");
        author.setLastName("Manny");
        author.setStreet("7th St");
        author.setCity("New York City");
        author.setState("");
        author.setEmail("mordi@gmail");


        String inputJson = mapper.writeValueAsString(author);

        Author author2 = new Author();
        author2.setFirstName("mordi");
        author2.setLastName("Manny");
        author2.setStreet("7th St");
        author2.setCity("New York City");
        author2.setState("");
        author2.setEmail("mordi@gmail");

        String outputJson = mapper.writeValueAsString(author2);

        mockMvc.perform(post("/authors")
                        .content(inputJson).contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isCreated());
    }
    @Test
    public void shouldReturnAuthorbyId() throws Exception {
        mockMvc.perform(get("/authors/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void shouldReturnAllAuthors() throws Exception {

        mockMvc.perform(get("/authors")).andDo(print()).andExpect(status().isOk());
    }
    @Test
    public void shouldUpdateAuthor() throws Exception {

        Author author = new Author();
        author.setFirstName("mordi");
        author.setLastName("Manny");
        author.setStreet("7th St");
        author.setCity("New York City");
        author.setState("");
        author.setEmail("mordi@gmail");
        author.setId(1);

        String inputJson = mapper.writeValueAsString(author);

        mockMvc.perform(
                        put("/authors")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }
    @Test
    public void shouldDeleteAuthorById() throws Exception {
        mockMvc.perform(delete("/authors/1")).andDo(print()).andExpect(status().isNoContent());

    }

}
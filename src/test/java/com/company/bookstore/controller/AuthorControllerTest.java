package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import com.company.bookstore.repository.AuthorRepository;
import com.company.bookstore.repository.BookRepository;
import com.company.bookstore.repository.PublisherRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
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
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepository bookRepository;

    @MockBean
    private AuthorRepository authorRepository;

    @MockBean
    private PublisherRepository publisherRepository;

    private ObjectMapper mapper = new ObjectMapper();


    @BeforeEach
    public void setup() {

    }

    //CREATE
    @Test
    public void shouldCreateAuthor() throws Exception {

        //Arrange...
        Author author = new Author();
        author.setFirstName("John");
        author.setLastName("Bobby");
        author.setStreet("123 Lincoln");
        author.setCity("Philly");
        author.setState("Pennsylvania");


        String inputJson = mapper.writeValueAsString(author);


        mockMvc.perform(post("/author")
                        .content(inputJson).contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isCreated());
    }



    //A GET route that returns a specific customer by id.
    @Test
    public void shouldReturnAuthorbyId() throws Exception {
        mockMvc.perform(get("/author/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }


    //A GET route that returns all authors
    @Test
    public void shouldReturnAllAuthors() throws Exception {

        mockMvc.perform(get("/author")).andDo(print()).andExpect(status().isOk());
    }

    //A PUT route that updates an existing author
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
                        put("/author")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    //A DELETE route that deletes an existing author.
    @Test
    public void shouldDeleteAuthorById() throws Exception {
        mockMvc.perform(delete("/author/3")).andDo(print()).andExpect(status().isNoContent());

    }

}

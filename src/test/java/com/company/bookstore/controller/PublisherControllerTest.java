package com.company.bookstore.controller;


import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.PublisherRepository;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(PublisherController.class)
public class PublisherControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PublisherRepository repo;

    // ObjectMapper used to convert Java objects to JSON and vice versa


    private ObjectMapper mapper = new ObjectMapper();
    // A list of customers for testing purposes

    @BeforeEach
    public void setUp() throws Exception {
        Publisher pub = new Publisher();
        pub.setName("OVO Prod");
        pub.setStreet("27 King Way");
        pub.setCity("Seattle");
        pub.setState("WA");
        pub.setPostalCode("98109");pub.setEmail("ovo@gmail.com");
        pub.setPhone("404-444-4444");



        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(pub);

        Publisher pub_o = new Publisher();
        pub_o.setName("Donda Company");
        pub_o.setStreet("123 Fly Way");
        pub_o.setCity("Seattle");
        pub_o.setState("WA");
        pub_o.setPostalCode("98109");pub.setEmail("donda@gmail.com");
        pub_o.setPhone("404-424-4444");


        String outputJson = mapper.writeValueAsString(pub_o);

    }


    private List<Publisher> publisherList;
    @Test
    public void shouldReturnAllPublishersInCollection() throws Exception {
        String outputJson = mapper.writeValueAsString(publisherList);

        // ACT
        mockMvc.perform(get("/publisher"))                // Perform the GET request
                .andDo(print())                          // Print results to console
                .andExpect(status().isOk());              // ASSERT (status code is 200)
    }


    @Test
    public void shouldReturnPublisherbyId() throws Exception {
        String outputJson = mapper.writeValueAsString(publisherList);
        mockMvc
                .perform(get("/publisher/1"))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void shouldCreatePublisher() throws Exception {
        Publisher pub = new Publisher();
        pub.setName("Rocky Roads LLC");
        pub.setStreet("451 Smith St");
        pub.setCity("Seattle");
        pub.setState("WA");
        pub.setPostalCode("98109");
        pub.setEmail("jim@gmail.com");
        pub.setPhone("321-222-2222");

        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(pub);

        Publisher pub_o = new Publisher();
        pub.setName("Jig Smooth Corp");
        pub.setStreet("451 Smith St");
        pub.setCity("Seattle");
        pub.setState("WA");
        pub.setPostalCode("98109");pub.setEmail("jil@gmail.com");
        pub.setPhone("321-784-2222");

        String outputJson = mapper.writeValueAsString(pub_o);
        mockMvc.perform(
                        post("/publisher")                            // Perform the POST request
                                .content(inputJson)                       // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldUpdateExistingCustomer() throws Exception {
        Publisher pub = new Publisher();
        pub.setName("OVO Prod");
        pub.setStreet("27 King Way");
        pub.setCity("Seattle");
        pub.setState("WA");
        pub.setPostalCode("99099");pub.setEmail("ovo@gmail.com");
        pub.setPhone("321-444-2222");



        // Convert Java Object to JSON
        String inputJson = mapper.writeValueAsString(pub);

        Publisher pub_o = new Publisher();
        pub_o.setName("Donda Company");
        pub_o.setStreet("123 Fly Way");
        pub_o.setCity("Seattle");
        pub_o.setState("WA");
        pub_o.setPostalCode("98109");pub.setEmail("donda@gmail.com");
        pub_o.setPhone("321-424-2222");


        String outputJson = mapper.writeValueAsString(pub_o);

        mockMvc.perform(
                        put("/publisher")                            // Perform the PUT request
                                .content(inputJson)                       // Set the request body
                                .contentType(MediaType.APPLICATION_JSON)  // Tell the server it's in JSON format
                )
                .andDo(print())                                // Print results to console
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldDeletePublisher() throws Exception {
        String outputJson = mapper.writeValueAsString(publisherList);
        mockMvc.perform(delete("/publisher/4")).andDo(print()).andExpect(status().isNoContent());

    }
}

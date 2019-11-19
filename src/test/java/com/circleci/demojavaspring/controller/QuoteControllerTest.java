package com.circleci.demojavaspring.controller;

import com.circleci.demojavaspring.model.Author;
import com.circleci.demojavaspring.model.Quote;
import com.circleci.demojavaspring.model.QuoteList;
import com.circleci.demojavaspring.repository.AuthorRepository;
import com.circleci.demojavaspring.repository.QuoteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
@TestPropertySource("/test.properties")
public class QuoteControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    QuoteRepository quoteRepository;
    @Autowired
    AuthorRepository authorRepository;

    @Before
    public void setUp() throws Exception {
        //create one entry in the quote and author repositories repositories each

    }

    @Test
    public void testAddQuote() throws IOException {
        //create new quote DTO

        //use restTemplate with postForEntity to send a POST request to the url

        //check API returns additional quote

    }

    @After
    public void tearDown() throws Exception {
        quoteRepository.deleteAll();
        authorRepository.deleteAll();
    }
}
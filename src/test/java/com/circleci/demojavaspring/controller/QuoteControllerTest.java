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
        Author a = authorRepository.save(new Author("Marcus", "Aurelius", 121));
        Quote q = new Quote();
        q.setQuote("Whatever this is that I am, it is a little flesh and breath, and the ruling part.");
        q.setAuthor(a);
        quoteRepository.save(q);
    }

    @Test
    public void testAddQuote() throws IOException {
        CreateQuoteDTO dto = new CreateQuoteDTO();
        dto.setAuthorBirthYear("121");
        dto.setAuthorFirstName("Marcus");
        dto.setAuthorLastName("Aurelius");
        dto.setQuote("Begin the morning by saying to thyself, I shall meet with the busy-body, the ungrateful, arrogant, deceitful, envious, unsocial.");

        ResponseEntity<Quote> quoteResponseEntity = restTemplate.postForEntity("/quote", dto, Quote.class);
        assertEquals(HttpStatus.OK, quoteResponseEntity.getStatusCode() );

        ResponseEntity<QuoteList> result = restTemplate.getForEntity("/quote", QuoteList.class);
        assertEquals(2, result.getBody().getQuotes().size());
    }

    @After
    public void tearDown() throws Exception {
        quoteRepository.deleteAll();
        authorRepository.deleteAll();
    }
}
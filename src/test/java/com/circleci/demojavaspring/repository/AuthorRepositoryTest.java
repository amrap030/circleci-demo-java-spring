package com.circleci.demojavaspring.repository;

import com.circleci.demojavaspring.model.Author;
import com.circleci.demojavaspring.model.Quote;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
@TestPropertySource("/test.properties")
public class AuthorRepositoryTest {

    @Autowired
    QuoteRepository quoteRepository;
    @Autowired
    AuthorRepository authorRepository;

    @Before
    public void setupDB() {
        Author a = authorRepository.save(new Author("Marcus", "Aurelius", 121));
        Quote q = new Quote();
        q.setQuote("Whatever this is that I am, it is a little flesh and breath, and the ruling part.");
        q.setAuthor(a);
        quoteRepository.save(q);
    }

    @Test
    public void testFindMethod() {
        Optional<Author> result = authorRepository.findOneByFirstNameAndLastNameAndYearOfBirth("Marcus", "Aurelius", 121);
        Assert.assertTrue(result.isPresent());
    }
}
package com.circleci.demojavaspring.repository;

import com.circleci.demojavaspring.model.Author;
import com.circleci.demojavaspring.model.Quote;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
@TestPropertySource("/test.properties")
public class AuthorRepositoryTest {


    @Autowired
    AuthorRepository authorRepository;

    @Before
    public void setupDB() {
        Author a = authorRepository.save(new Author("Marcus", "Aurelius", 121));
    }

    @Test
    public void testFindMethod() {
        Optional<Author> result = authorRepository.findByFirstNameAndLastNameAndYearOfBirth("Marcus", "Aurelius", 121);
        assertTrue(result.isPresent());
    }

    @After
    public void tearDown() {
        authorRepository.deleteAll();
    }
}
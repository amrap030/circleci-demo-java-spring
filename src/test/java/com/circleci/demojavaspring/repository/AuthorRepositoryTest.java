package com.circleci.demojavaspring.repository;

import com.circleci.demojavaspring.model.Author;
import com.circleci.demojavaspring.model.Quote;
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

    @Test
    public void doTestHere() {

    }

}
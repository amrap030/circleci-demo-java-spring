package com.circleci.demojavaspring.controller;

import com.circleci.demojavaspring.model.Author;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateQuoteDTOTest {

    @Test
    void deriveAuthorValid() {
        CreateQuoteDTO validQuote = new CreateQuoteDTO();
        validQuote.setAuthorFirstName("Marcus");
        validQuote.setAuthorLastName("Aurelius");
        validQuote.setQuote("Whatever this is that I am, it is a little flesh and breath, and the ruling part.");
        validQuote.setAuthorBirthYear("121");

        Author author = validQuote.deriveAuthor();
        Assert.assertEquals(121, author.getYearOfBirth());
    }

    @Test
    void deriveAuthorInvalid() {
        CreateQuoteDTO invalidQuote = new CreateQuoteDTO();
        invalidQuote.setAuthorBirthYear("121AD");
        Assert.assertNull(invalidQuote.deriveAuthor());
    }
}
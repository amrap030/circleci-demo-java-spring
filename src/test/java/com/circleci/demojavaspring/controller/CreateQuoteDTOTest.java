package com.circleci.demojavaspring.controller;

import com.circleci.demojavaspring.model.Author;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

class CreateQuoteDTOTest {

    @Test
    void deriveAuthorValid() {
        CreateQuoteDTO validQuote = new CreateQuoteDTO();
        validQuote.setAuthorFirstName("Marcus");
        validQuote.setAuthorLastName("Aurelius");
        validQuote.setQuote("Whatever this is that I am, it is a little flesh and breath, and the ruling part.");
        validQuote.setAuthorBirthYear("121");

        Author author = validQuote.deriveAuthor();
        assertEquals(121, author.getYearOfBirth());
    }

    @Test
    void deriveAuthorInvalid() {
        CreateQuoteDTO invalidQuote = new CreateQuoteDTO();
        invalidQuote.setAuthorBirthYear("121AD");
        assertNotNull(invalidQuote.deriveAuthor());
    }
}
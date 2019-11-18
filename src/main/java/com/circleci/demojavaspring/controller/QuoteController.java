package com.circleci.demojavaspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.circleci.demojavaspring.model.Author;
import com.circleci.demojavaspring.model.Quote;
import com.circleci.demojavaspring.repository.AuthorRepository;
import com.circleci.demojavaspring.repository.QuoteRepository;

import java.util.Optional;

@Controller
@RequestMapping(path="/quote")
public class QuoteController {
    @Autowired
    public QuoteController(AuthorRepository authorRepository, QuoteRepository quoteRepository) {
        this.authorRepository = authorRepository;
        this.quoteRepository = quoteRepository;
    }

    private AuthorRepository authorRepository;
    private QuoteRepository quoteRepository;

    @PostMapping
    public ResponseEntity<Quote> addNewQuote (@RequestBody CreateQuoteDTO quote) {
        Author author = quote.deriveAuthor();
        if (author == null) {
            return ResponseEntity.badRequest().build();
        }
        Optional<Author> authorOfQuote = authorRepository.findOneByFirstNameAndLastNameAndYearOfBirth(author.getFirstName(), author.getLastName(), author.getYearOfBirth());
        if (authorOfQuote.isPresent()) {
            author = authorOfQuote.get();
        } else {
            author = authorRepository.save(author);
        }
        Quote q = new Quote();
        q.setAuthor(author);
        q.setQuote(quote.getQuote());
        q = quoteRepository.save(q);
        return ResponseEntity.ok(q);
    }
}
package com.circleci.demojavaspring.repository;

import org.springframework.data.repository.CrudRepository;

import com.circleci.demojavaspring.model.Quote;

import java.util.List;

public interface QuoteRepository extends CrudRepository<Quote, Integer> {
    List<Quote> findByAuthorLastName(String authorLastName);
}
package com.circleci.demojavaspring.repository;

import org.springframework.data.repository.CrudRepository;

import com.circleci.demojavaspring.model.Author;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
    Optional<Author> findOneByFirstNameAndLastNameAndYearOfBirth(String firstName, String lastName, int yearOfBirth);
}
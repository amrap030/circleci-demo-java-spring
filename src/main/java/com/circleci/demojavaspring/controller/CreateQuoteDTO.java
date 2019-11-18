package com.circleci.demojavaspring.controller;

import com.circleci.demojavaspring.model.Author;

public class CreateQuoteDTO {
    public CreateQuoteDTO() {
    }

    private String quote;

    private String authorFirstName;

    private String authorLastName;

    private String authorBirthYear;

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getAuthorBirthYear() {
        return authorBirthYear;
    }

    public void setAuthorBirthYear(String authorBirthYear) {
        this.authorBirthYear = authorBirthYear;
    }

    //Returns null if author birth year is invalid
    public Author deriveAuthor(){
        int birthYear = 0;
        try {
            birthYear = Integer.parseInt(authorBirthYear);
        } catch (NumberFormatException nfe) {
            return null;
        }
        if ((birthYear < 0) || (birthYear > 2019)) {
            return null;
        }
        return new Author(authorFirstName, authorLastName, birthYear);
    }
}

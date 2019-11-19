package com.circleci.demojavaspring.model;

import java.util.ArrayList;
import java.util.List;

public class QuoteList {
    private List<Quote> quotes;

    public QuoteList() {
        quotes = new ArrayList<Quote>();
    }

    public QuoteList(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }
}

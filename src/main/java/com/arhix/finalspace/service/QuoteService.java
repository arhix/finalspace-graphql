package com.arhix.finalspace.service;

import com.arhix.finalspace.api.QuotesQueryResolver;
import com.arhix.finalspace.model.QuoteEntity;
import com.arhix.finalspace.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService implements QuotesQueryResolver {

    @Autowired
    private QuoteRepository repository;

    public List<QuoteEntity> quotes() {
        return repository.findAll();
    }
}

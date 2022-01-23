package com.arhix.finalspace.service;

import com.arhix.finalspace.repository.CharacterRepository;
import com.arhix.finalspace.api.CharacterQueryResolver;
import com.arhix.finalspace.api.CharactersQueryResolver;
import com.arhix.finalspace.model.CharacterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService implements CharactersQueryResolver, CharacterQueryResolver {

    @Autowired
    private CharacterRepository repository;

    @Override
    public List<CharacterEntity> characters() {
        return repository.findAll();
    }

    @Override
    public CharacterEntity character(int id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }
}

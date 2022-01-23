package com.arhix.finalspace.service;

import com.arhix.finalspace.repository.EpisodeRepository;
import com.arhix.finalspace.api.EpisodeQueryResolver;
import com.arhix.finalspace.api.EpisodesQueryResolver;
import com.arhix.finalspace.model.EpisodeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeService implements EpisodesQueryResolver, EpisodeQueryResolver {

    @Autowired
    private EpisodeRepository repository;

    @Override
    public List<EpisodeEntity> episodes() {
        return repository.findAll();
    }

    @Override
    public EpisodeEntity episode(int id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }
}

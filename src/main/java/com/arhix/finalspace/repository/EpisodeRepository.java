package com.arhix.finalspace.repository;

import com.arhix.finalspace.model.EpisodeEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class EpisodeRepository {
    public static final String URL ="https://finalspaceapi.com/api/v0/episode/";

    public List<EpisodeEntity> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<EpisodeEntity[]> response = restTemplate.getForEntity(URL, EpisodeEntity[].class);

        if (response.getBody() != null) {
            return Arrays.asList(response.getBody());
        }

        return Collections.emptyList();
    }

    public Optional<EpisodeEntity> findById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<EpisodeEntity> response = restTemplate.getForEntity(URL + id, EpisodeEntity.class);
        return Optional.ofNullable(response.getBody());
    }
}

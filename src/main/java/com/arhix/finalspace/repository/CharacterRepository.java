package com.arhix.finalspace.repository;

import com.arhix.finalspace.model.CharacterEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
public class CharacterRepository {
    public static final String URL ="https://finalspaceapi.com/api/v0/character/";

    public List<CharacterEntity> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CharacterEntity[]> response = restTemplate.getForEntity(URL, CharacterEntity[].class);

        if (response.getBody() != null) {
            return Arrays.asList(response.getBody());
        }

        return Collections.emptyList();
    }

    public Optional<CharacterEntity> findById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CharacterEntity> response = restTemplate.getForEntity(URL + id, CharacterEntity.class);
        return Optional.ofNullable(response.getBody());
    }
}

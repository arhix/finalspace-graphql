package com.arhix.finalspace.repository;

import com.arhix.finalspace.model.QuoteEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class QuoteRepository {
    public static final String URL ="https://finalspaceapi.com/api/v0/quote/";

    public List<QuoteEntity> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<QuoteEntity[]> response = restTemplate.getForEntity(URL, QuoteEntity[].class);

        if (response.getBody() != null) {
            return Arrays.asList(response.getBody());
        }

        return Collections.emptyList();
    }
}

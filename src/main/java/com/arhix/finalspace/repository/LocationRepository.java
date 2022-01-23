package com.arhix.finalspace.repository;

import com.arhix.finalspace.model.LocationEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class LocationRepository {
    public static final String URL ="https://finalspaceapi.com/api/v0/location/";

    public List<LocationEntity> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<LocationEntity[]> response = restTemplate.getForEntity(URL, LocationEntity[].class);

        if (response.getBody() != null) {
            return Arrays.asList(response.getBody());
        }

        return Collections.emptyList();
    }

    public Optional<LocationEntity> findById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<LocationEntity> response = restTemplate.getForEntity(URL + id, LocationEntity.class);
        return Optional.ofNullable(response.getBody());
    }
}

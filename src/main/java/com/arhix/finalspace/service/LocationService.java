package com.arhix.finalspace.service;

import com.arhix.finalspace.api.LocationQueryResolver;
import com.arhix.finalspace.api.LocationsQueryResolver;
import com.arhix.finalspace.model.LocationEntity;
import com.arhix.finalspace.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService implements LocationsQueryResolver, LocationQueryResolver {

    @Autowired
    private LocationRepository repository;

    @Override
    public List<LocationEntity> locations() {
        return repository.findAll();
    }

    @Override
    public LocationEntity location(int id) throws RecordNotFoundException {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }
}

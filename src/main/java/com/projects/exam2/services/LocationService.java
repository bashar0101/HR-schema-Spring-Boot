package com.projects.exam2.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.exam2.DTO.LocationCreate;
import com.projects.exam2.entites.Country;
import com.projects.exam2.entites.Location;
import com.projects.exam2.repositories.CountryRepo;
import com.projects.exam2.repositories.LocationRepo;

@Service
public class LocationService {

    @Autowired
    private LocationRepo locationRepo;
    @Autowired
    private CountryRepo countryRepo;

    public Location create(LocationCreate location) {

        Location newLocation = new Location();
        Country country = countryRepo.findById(location.countryId())
                .orElseThrow(() -> new RuntimeException("Country not found with id: " + location.countryId()));
        newLocation.setStreetAddress(location.streetAddress());
        newLocation.setPostalCode(location.postalCode());
        newLocation.setCity(location.city());
        newLocation.setStateProvince(location.stateProvince());
        newLocation.setCountry(country);
        locationRepo.save(newLocation);
        locationRepo.save(newLocation);
        return newLocation;
    }

    public Location update(UUID id, LocationCreate location) {
        Location updatedLocation = locationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found with id: " + id));

        Country country = countryRepo.findById(location.countryId())
                .orElseThrow(() -> new RuntimeException("Country not found with id: " + location.countryId()));
        updatedLocation.setStreetAddress(location.streetAddress());
        updatedLocation.setPostalCode(location.postalCode());
        updatedLocation.setCity(location.city());
        updatedLocation.setStateProvince(location.stateProvince());
        updatedLocation.setCountry(country);
        locationRepo.save(updatedLocation);
        return updatedLocation;
    }

    public void delete(UUID id) {
        locationRepo.deleteById(id);
    }

    public Location findById(UUID id) {
        return locationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found with id: " + id));
    }

    public List<Location> findAll() {
        return locationRepo.findAll();
    }

}

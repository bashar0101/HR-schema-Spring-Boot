package com.projects.exam2.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.exam2.DTO.CountryCreate;
import com.projects.exam2.entites.Country;
import com.projects.exam2.entites.Region;
import com.projects.exam2.repositories.CountryRepo;
import com.projects.exam2.repositories.RegionRepo;

@Service
public class CountryService {

    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private RegionRepo regionRepo;

    public Country create(CountryCreate country) {
        Country newCountry = new Country();
        Region region = regionRepo.findById(country.regionId())
                .orElseThrow(() -> new RuntimeException("region not found with id: " + country.regionId()));

        newCountry.setCountryName(country.countryName());
        newCountry.setRegion(region);

        return countryRepo.save(newCountry);
    }

    public Country update(UUID id, CountryCreate country) {
        Country updatedCountry = countryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("country not found with id: " + id));
        Region region = regionRepo.findById(country.regionId())
                .orElseThrow(() -> new RuntimeException("Region not found with id: " + country.regionId()));

        updatedCountry.setCountryName(country.countryName());
        updatedCountry.setRegion(region);

        return countryRepo.save(updatedCountry);
    }

    public Country getById(UUID id) {
        return countryRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public List<Country> findAll() {
        return countryRepo.findAll();
    }

}

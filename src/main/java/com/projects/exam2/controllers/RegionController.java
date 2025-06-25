package com.projects.exam2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.exam2.DTO.CountryCreate;
import com.projects.exam2.DTO.LocationCreate;
import com.projects.exam2.entites.Country;
import com.projects.exam2.entites.Location;
import com.projects.exam2.entites.Region;
import com.projects.exam2.services.CountryService;
import com.projects.exam2.services.LocationService;
import com.projects.exam2.services.RegionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/region")
public class RegionController {

    @Autowired
    private RegionService regionService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private LocationService locationService;

    @PostMapping("/region")
    public ResponseEntity<?> createRegion(@RequestBody Region region) {
        Region newRegion = regionService.create(region);
        return new ResponseEntity<>(newRegion, HttpStatus.OK);
    }

    @PostMapping("/country")
    public ResponseEntity<?> createCountry(@RequestBody CountryCreate country) {
        Country newCountry = countryService.create(country);
        return new ResponseEntity<>(newCountry, HttpStatus.OK);
    }

    @PostMapping("/location")
    public ResponseEntity<?> createLocation(@RequestBody LocationCreate location) {
        Location newLocation = locationService.create(location);
        return new ResponseEntity<>(newLocation, HttpStatus.OK);
    }

}

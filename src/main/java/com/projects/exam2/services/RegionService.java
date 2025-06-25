package com.projects.exam2.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.exam2.entites.Region;
import com.projects.exam2.repositories.RegionRepo;

@Service
public class RegionService {

    @Autowired
    private RegionRepo regionRepo;

    public Region create(Region region) {
        return regionRepo.save(region);
    }

    public Region update(UUID id, Region region) {
        Region updatedRegion = regionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        updatedRegion.setRegionName(region.getRegionName());
        return regionRepo.save(updatedRegion);
    }

    public Region getById(UUID id) {
        return regionRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public List<Region> findAll() {
        return regionRepo.findAll();
    }
}

package com.projects.exam2.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.exam2.entites.Region;

@Repository
public interface RegionRepo extends JpaRepository<Region, UUID> {

}

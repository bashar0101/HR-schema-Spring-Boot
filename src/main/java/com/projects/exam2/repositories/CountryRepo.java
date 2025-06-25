package com.projects.exam2.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.exam2.entites.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, UUID> {

}

package com.projects.exam2.DTO;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CountryCreate(
        @NotNull(message = "Country name cannot be null") @Size(min = 2, max = 100, message = "Country name must be between 2 and 100 characters") String countryName,

        @NotNull(message = "Region ID cannot be null") UUID regionId

) {

}

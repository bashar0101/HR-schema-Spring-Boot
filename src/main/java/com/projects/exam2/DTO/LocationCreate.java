package com.projects.exam2.DTO;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record LocationCreate(
        @NotNull(message = "Street address cannot be null") @Size(min = 2, max = 100, message = "Street address must be between 2 and 100 characters") String streetAddress,

        @PositiveOrZero(message = "Postal code must be zero or a positive number") Integer postalCode,

        @NotNull(message = "City cannot be null") @Size(min = 2, max = 100, message = "City must be between 2 and 100 characters") String city,

        @Size(max = 100, message = "State/Province must be less than 100 characters") String stateProvince,

        @NotNull(message = "Country ID cannot be null") UUID countryId

) {

}

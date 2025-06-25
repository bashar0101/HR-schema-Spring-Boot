package com.projects.exam2.DTO;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DepartmentCreate(
        @NotNull(message = "Department name cannot be null") @Size(min = 2, max = 100, message = "Department name must be between 2 and 100 characters") String departmentName,
        UUID managerId,
        @NotNull(message = "Location ID cannot be null") UUID locationId

) {

}

package com.projects.exam2.DTO;

import java.sql.Date;
import java.util.UUID;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record EmployeeCreate(
        @NotNull(message = "First name cannot be null") @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters") String firstName,

        @NotNull(message = "Last name cannot be null") @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters") String lastName,

        @NotNull(message = "Email cannot be null") @Email(message = "Email should be valid") String email,

        @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number must be between 10 and 15 digits") String phoneNumber,

        @PastOrPresent(message = "Hire date must be in the past or present") Date hireDate,

        @NotNull(message = "Job ID cannot be null") UUID jobId,

        @NotNull(message = "Salary cannot be null") @Positive(message = "Salary must be positive") Double salary,

        @PositiveOrZero(message = "Commission percent must be zero or positive") Double commissionPct,

        @NotNull(message = "Manager ID cannot be null") UUID managerId,

        @NotNull(message = "Department ID cannot be null") UUID departmentId

) {

}

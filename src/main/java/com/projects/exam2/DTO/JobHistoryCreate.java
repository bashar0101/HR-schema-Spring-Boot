package com.projects.exam2.DTO;

import java.sql.Date;
import java.util.UUID;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public record JobHistoryCreate(
        @NotNull(message = "Employee ID cannot be null") UUID employeeId,
        @NotNull(message = "Start date cannot be null") @PastOrPresent(message = "Start date must be in the past or present") Date startDate,
        @NotNull(message = "End date cannot be null") @FutureOrPresent(message = "End date must be in the present or future") Date endDate,
        @NotNull(message = "Job ID cannot be null") UUID jobId,
        @NotNull(message = "Department ID cannot be null") UUID departmentId

) {

}

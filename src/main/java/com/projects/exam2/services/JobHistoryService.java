package com.projects.exam2.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.exam2.DTO.JobHistoryCreate;
import com.projects.exam2.entites.Department;
import com.projects.exam2.entites.Employee;
import com.projects.exam2.entites.Job;
import com.projects.exam2.entites.JobHistory;
import com.projects.exam2.repositories.DepartmentRepo;
import com.projects.exam2.repositories.EmployeeRepo;
import com.projects.exam2.repositories.JobHistoryRepo;
import com.projects.exam2.repositories.JobRepo;

@Service
public class JobHistoryService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private JobRepo jobRepo;

    @Autowired
    private JobHistoryRepo jobHistoryRepo;

    public JobHistory create(JobHistoryCreate jobHistory) {
        Department dept = departmentRepo.findById(jobHistory.departmentId())
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + jobHistory.departmentId()));
        Job job = jobRepo.findById(jobHistory.jobId())
                .orElseThrow(() -> new RuntimeException("job not found with id: " + jobHistory.departmentId()));
        Employee employee = employeeRepo.findById(jobHistory.employeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + jobHistory.departmentId()));
        JobHistory newJob = new JobHistory();
        newJob.setDepartment(dept);
        newJob.setEmployee(employee);
        newJob.setJob(job);
        newJob.setStartDate(jobHistory.startDate());
        newJob.setEndDate(jobHistory.endDate());
        jobHistoryRepo.save(newJob);
        return newJob;
    }

    // public JobHistory update(UUID id, JobHistoryCreate jobHistory) {
    // Department dept =
    // departmentRepo.findById(jobHistory.departmentId()).orElseThrow();
    // Job job = jobRepo.findById(jobHistory.jobId()).orElseThrow();
    // Employee employee =
    // employeeRepo.findById(jobHistory.employeeId()).orElseThrow();
    // JobHistory newJob = jobHistoryRepo.findById(id).orElseThrow();
    // newJob.setDepartment(dept);
    // newJob.setEmployee(employee);
    // newJob.setJob(job);
    // newJob.setStartDate(jobHistory.startDate());
    // newJob.setEndDate(jobHistory.endDate());
    // jobHistoryRepo.save(newJob);
    // return newJob;
    // }

    // public void deleteById(UUID id) {
    // jobHistoryRepo.deleteById(id);

    // }

    public JobHistory findById(UUID id) {
        return jobHistoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Job History not found with id: " + id));
    }

    public List<JobHistory> findAll() {
        return jobHistoryRepo.findAll();
    }

}

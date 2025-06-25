package com.projects.exam2.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.exam2.entites.Job;
import com.projects.exam2.repositories.JobRepo;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public Job creaet(Job job) {
        return jobRepo.save(job);
    }

    public Job update(UUID id, Job job) {
        Job updatedJob = jobRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        updatedJob.setJobTitle(job.getJobTitle());
        updatedJob.setMaxSalary(job.getMaxSalary());
        updatedJob.setMinSalary(job.getMinSalary());
        jobRepo.save(updatedJob);
        return updatedJob;
    }

    public void delete(UUID id) {
        jobRepo.deleteById(id);
    }

    public Job fintById(UUID id) {
        return jobRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public List<Job> findAll() {
        return jobRepo.findAll();
    }

}

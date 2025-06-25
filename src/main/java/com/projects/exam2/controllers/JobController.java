package com.projects.exam2.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.projects.exam2.entites.Job;
import com.projects.exam2.services.JobService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping("")
    public ResponseEntity<Job> postMethodName(@RequestBody Job job) {
        Job newJob = jobService.creaet(job);
        return new ResponseEntity<>(newJob, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> postMethodName(@PathVariable UUID id, @RequestBody Job job) {
        Job updatedJob = jobService.update(id, job);
        return new ResponseEntity<>(updatedJob, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Job>> findAllJobs() {
        List<Job> allJobs = jobService.findAll();
        return new ResponseEntity<>(allJobs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findById(@PathVariable UUID id) {
        Job job = jobService.fintById(id);
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

}

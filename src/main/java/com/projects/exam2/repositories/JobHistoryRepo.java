package com.projects.exam2.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projects.exam2.entites.JobHistory;

@Repository
public interface JobHistoryRepo extends JpaRepository<JobHistory, UUID> {

}

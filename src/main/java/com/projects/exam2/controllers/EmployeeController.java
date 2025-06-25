package com.projects.exam2.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.exam2.DTO.EmployeeCreate;
import com.projects.exam2.DTO.JobHistoryCreate;
import com.projects.exam2.entites.Employee;
import com.projects.exam2.services.EmployeeService;
import com.projects.exam2.services.JobHistoryService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JobHistoryService jobHistoryService;

    @PostMapping("")
    public ResponseEntity<Employee> create(@RequestBody EmployeeCreate employee) {
        Employee e = employeeService.createEmployee(employee);
        java.sql.Date startDate = new java.sql.Date(System.currentTimeMillis());
        JobHistoryCreate jobCreate = new JobHistoryCreate(e.getId(), startDate, null, employee.jobId(),
                employee.departmentId());
        jobHistoryService.create(jobCreate);
        return new ResponseEntity<>(e, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable UUID id, @RequestBody EmployeeCreate employee) {
        Employee e = employeeService.update(id, employee);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> allEmps = employeeService.findAll();
        return new ResponseEntity<>(allEmps, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable UUID id) {
        Employee dept = employeeService.findById(id);
        return new ResponseEntity<>(dept, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        employeeService.deleteById(id);

    }

}

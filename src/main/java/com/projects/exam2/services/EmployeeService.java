package com.projects.exam2.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.exam2.DTO.EmployeeCreate;
import com.projects.exam2.entites.Department;
import com.projects.exam2.entites.Employee;
import com.projects.exam2.entites.Job;
import com.projects.exam2.repositories.DepartmentRepo;
import com.projects.exam2.repositories.EmployeeRepo;
import com.projects.exam2.repositories.JobRepo;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private JobRepo jobRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    public Employee createEmployee(EmployeeCreate emp) {
        Employee employee = new Employee();
        Job job = jobRepo.findById(emp.jobId()).orElseThrow(null);
        // Employee manager = employeeRepo.findById(emp.managerId()).orElseThrow();
        Department d = departmentRepo.findById(emp.departmentId()).orElseThrow();
        java.sql.Date startDate = new java.sql.Date(System.currentTimeMillis());
        employee.setFirstName(emp.firstName());
        employee.setLasttName(emp.lastName());
        employee.setEmai(emp.email());
        employee.setPhoneNumer(emp.phoneNumber());
        employee.setHireDate(startDate);
        employee.setSalary(emp.salary());
        employee.setCommissionPct(emp.commissionPct());
        employee.setJob(job);
        employee.setEmployee(null);
        employee.setDepartment(d);
        return employeeRepo.save(employee);
    }

    public Employee findById(UUID id) {
        return employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    public Employee update(UUID id, EmployeeCreate emp) {

        Employee employee = new Employee();
        Job job = jobRepo.findById(emp.jobId()).orElseThrow(null);
        Employee manager = employeeRepo.findById(emp.managerId()).orElseThrow();
        Department d = departmentRepo.findById(emp.departmentId()).orElseThrow();

        employee.setFirstName(emp.firstName());
        employee.setLasttName(emp.lastName());
        // employee.setEmai(emp.email());
        employee.setPhoneNumer(emp.phoneNumber());
        // employee.setHireDate(emp.hireDate());
        employee.setSalary(emp.salary());
        employee.setCommissionPct(emp.commissionPct());
        employee.setJob(job);
        employee.setEmployee(manager);
        employee.setDepartment(d);
        return employeeRepo.save(employee);

    }

    public void deleteById(UUID id) {
        employeeRepo.deleteById(id);
    }
}

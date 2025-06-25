package com.projects.exam2.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.exam2.DTO.DepartmentCreate;
import com.projects.exam2.entites.Department;
import com.projects.exam2.services.DepartmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("")
    public ResponseEntity<Department> postMethodName(@RequestBody DepartmentCreate departmentRequest) {
        Department d = departmentService.create(departmentRequest);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @PutMapping("/{deptId}")
    public ResponseEntity<Department> putMethodName(@PathVariable UUID deptId,
            @RequestBody DepartmentCreate departmentRequest) {
        Department d = departmentService.create(departmentRequest);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Department>> findAll() {
        List<Department> allDepts = departmentService.findAll();
        return new ResponseEntity<>(allDepts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> findById(@PathVariable UUID id) {
        Department dept = departmentService.findById(id);
        return new ResponseEntity<>(dept, HttpStatus.OK);
    }

}

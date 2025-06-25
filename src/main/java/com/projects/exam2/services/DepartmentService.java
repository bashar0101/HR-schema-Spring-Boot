package com.projects.exam2.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.exam2.DTO.DepartmentCreate;
import com.projects.exam2.entites.Department;
import com.projects.exam2.entites.Employee;
import com.projects.exam2.entites.Location;
import com.projects.exam2.repositories.DepartmentRepo;
import com.projects.exam2.repositories.EmployeeRepo;
import com.projects.exam2.repositories.LocationRepo;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private LocationRepo locationRepo;

    public Department create(DepartmentCreate department) {
        Department newDept = new Department();
        // إذا في مدير، جيبه من قاعدة البيانات
        if (department.managerId() != null) {
            Employee manager = employeeRepo.findById(department.managerId())
                    .orElseThrow(() -> new RuntimeException("Manager not found with id: " + department.managerId()));
            newDept.setEmployee(manager); // ربط المدير مع القسم
        }
        Location location = locationRepo.findById(department.locationId())
                .orElseThrow(() -> new RuntimeException("Location not found with id: " + department.locationId()));

        newDept.setDepartmentName(department.departmentName());
        newDept.setLocation(location);
        
        departmentRepo.save(newDept);
        return newDept;
    }

    public Department updaet(UUID id, DepartmentCreate department) {
        Department updatedDept = departmentRepo.findById(id).orElseThrow();
        Employee manager = employeeRepo.findById(department.managerId())
                .orElseThrow(() -> new RuntimeException("Manager not found with id: " + department.managerId()));
        Location location = locationRepo.findById(department.locationId())
                .orElseThrow(() -> new RuntimeException("Location not found with id: " + department.locationId()));

        updatedDept.setDepartmentName(department.departmentName());
        updatedDept.setEmployee(manager);
        updatedDept.setLocation(location);
        departmentRepo.save(updatedDept);
        return updatedDept;
    }

    public void deleteById(UUID id) {
        departmentRepo.deleteById(id);

    }

    public Department findById(UUID id) {
        return departmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + id));
    }

    public List<Department> findAll() {
        return departmentRepo.findAll();
    }

}
